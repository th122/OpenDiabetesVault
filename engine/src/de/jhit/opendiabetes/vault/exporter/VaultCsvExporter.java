/*
 * Copyright (C) 2017 Jens Heuschkel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.jhit.opendiabetes.vault.exporter;

import com.csvreader.CsvWriter;
import de.jhit.opendiabetes.vault.container.VaultCsvEntry;
import de.jhit.opendiabetes.vault.util.TimestampUtils;
import de.jhit.opendiabetes.vault.container.VaultEntry;
import de.jhit.opendiabetes.vault.data.VaultDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class VaultCsvExporter {

    public final static int RESULT_OK = 0;
    public final static int RESULT_ERROR = -1;
    public final static int RESULT_NO_DATA = -2;
    public final static int RESULT_FILE_ACCESS_ERROR = -3;

    protected static final Logger LOG = Logger.getLogger(VaultCsvExporter.class.getName());
    protected static final String DOUBLE_FORMAT = "%1$.2f";

    private final ExporterOptions options;
    private final VaultDao db;
    private final String filePath;
    protected FileOutputStream fileOutpuStream;

    public VaultCsvExporter(ExporterOptions options, VaultDao db, String filePath) {
        this.options = options;
        this.db = db;
        this.filePath = filePath;
    }

    public int exportDataToFile() {
        List<VaultEntry> entrys;
        List<VaultCsvEntry> csvEntrys;

        // check file stuff        
        File checkFile = new File(filePath);
        if (checkFile.exists()
                && (!checkFile.isFile() || !checkFile.canWrite())) {
            return RESULT_FILE_ACCESS_ERROR;
        }
        try {
            fileOutpuStream = new FileOutputStream(checkFile);
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, "Error accessing file for output stream", ex);
            return RESULT_FILE_ACCESS_ERROR;
        }

        // query entrys
        if (options.isImportPeriodRestricted) {
            entrys = db.queryVaultEntrysBetween(options.exportPeriodFrom,
                    options.exportPeriodTo);
        } else {
            entrys = db.queryAllVaultEntrys();
        }

        if (entrys == null || entrys.isEmpty()) {
            return RESULT_NO_DATA;
        }

        // create csv data
        csvEntrys = prepareData(entrys);

        // write to file
        try {
            writeToFile(csvEntrys);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error writing odv csv file: {0}" + filePath, ex);
            return RESULT_ERROR;
        }
        return RESULT_OK;
    }

    protected void writeToFile(List<VaultCsvEntry> csvEntries) throws IOException {
        CsvWriter cwriter = new CsvWriter(fileOutpuStream, VaultCsvEntry.CSV_DELIMITER,
                Charset.forName("UTF-8"));

        cwriter.writeRecord(VaultCsvEntry.getCsvHeaderRecord());
        for (VaultCsvEntry item : csvEntries) {
            cwriter.writeRecord(item.toCsvRecord(DOUBLE_FORMAT));
        }
        cwriter.flush();
        cwriter.close();
        fileOutpuStream.close();
    }

    private List<VaultCsvEntry> prepareData(List<VaultEntry> tmpValues) {
        List<VaultCsvEntry> returnValues = new ArrayList<>();

        // list is ordered by timestamp from database (or should be ordered otherwise)
        Date fromTimestamp = tmpValues.get(0).getTimestamp();
        Date toTimestamp = tmpValues.get(tmpValues.size() - 1).getTimestamp();

        if (!tmpValues.isEmpty()) {
            int i = 0;
            while (!fromTimestamp.after(toTimestamp)) {

                VaultCsvEntry tmpCsvEntry = new VaultCsvEntry();
                tmpCsvEntry.setTimestamp(fromTimestamp);

                VaultEntry tmpEntry;
                while (fromTimestamp.equals((tmpEntry = tmpValues.get(i)).getTimestamp())) {
                    if (i < tmpValues.size() - 1) {
                        i++;
                    } else {
                        i--;
                        break;
                    }

                    switch (tmpEntry.getType()) {
                        case GLUCOSE_CGM_ALERT:
                            tmpCsvEntry.setCgmAlertValue(tmpEntry.getValue());
                            break;
                        case GLUCOSE_CGM:
                            // TODO y does this happen
                            // --> when more than one cgm value per minute is available
                            // but cgm ticks are every 15 minutes ...
                            if (tmpCsvEntry.getCgmValue()
                                    == VaultCsvEntry.UNINITIALIZED_DOUBLE) {
                                tmpCsvEntry.setCgmValue(tmpEntry.getValue());
                            } else {
                                LOG.log(Level.WARNING,
                                        "CGM Value for entry {0}, Drop {1}, hold: {2}",
                                        new Object[]{tmpEntry.getTimestamp().toString(),
                                            tmpEntry.toString(),
                                            tmpCsvEntry.toString()});
                            }
                            break;
                        case GLUCOSE_CGM_CALIBRATION:
                            tmpCsvEntry.addGlucoseAnnotation(tmpEntry.getType().toString()
                                    + "="
                                    + String.format(Locale.ENGLISH, DOUBLE_FORMAT, tmpEntry.getValue()));
                            break;
                        case GLUCOSE_CGM_RAW:
                            tmpCsvEntry.setCgmRawValue(tmpEntry.getValue());
                            break;
                        case GLUCOSE_BG:
                        case GLUCOSE_BG_MANUAL:
                            // TODO why does this happen ?
                            // it often happens with identical values, but db is cleaned bevore ...
                            if (tmpCsvEntry.getBgValue()
                                    == VaultCsvEntry.UNINITIALIZED_DOUBLE) {
                                tmpCsvEntry.setBgValue(tmpEntry.getValue());
                                tmpCsvEntry.addGlucoseAnnotation(tmpEntry.getType().toString());
                            } else {
                                LOG.log(Level.WARNING,
                                        "CGM Value for entry {0}, Drop {1}, hold: {2}",
                                        new Object[]{tmpEntry.getTimestamp().toString(),
                                            tmpEntry.toString(),
                                            tmpCsvEntry.toString()});
                            }
                            break;
                        case GLUCOSE_BOLUS_CALCULATION:
                            tmpCsvEntry.setBolusCalculationValue(tmpEntry.getValue());
                            break;
                        case BASAL_Manual:
                        case BASAL_Profile:
                        case BASAL_INTERPRETER:
                            tmpCsvEntry.setBasalValue(tmpEntry.getValue());
                            tmpCsvEntry.addBasalAnnotation(tmpEntry.getType().toString());
                            break;
                        case BOLUS_Square:
                            tmpCsvEntry.setBolusValue(tmpEntry.getValue());
                            tmpCsvEntry.addBolusAnnotation(
                                    tmpEntry.getType().toString()
                                    + "=" + String.format(Locale.ENGLISH, DOUBLE_FORMAT, tmpEntry.getValue2()));
                            break;
                        case BOLUS_Normal:
                            tmpCsvEntry.setBolusValue(tmpEntry.getValue());
                            tmpCsvEntry.addBolusAnnotation(
                                    tmpEntry.getType().toString());
                            break;
                        case MEAL_BolusExpert:
                        case MEAL_Manual:
                            tmpCsvEntry.setMealValue(tmpEntry.getValue());
                            break;
                        case EXERCISE_GoogleBicycle:
                        case EXERCISE_GoogleWalk:
                        case EXERCISE_GoogleRun:
                        case EXERCISE_Manual:
                        case EXERCISE_TrackerBicycle:
                        case EXERCISE_TrackerRun:
                        case EXERCISE_TrackerWalk:
                            tmpCsvEntry.setExerciseTimeValue(tmpEntry.getValue());
                            tmpCsvEntry.addExerciseAnnotation(tmpEntry.getType().toString());
                            break;
                        case PUMP_FILL:
                        case PUMP_FILL_INTERPRETER:
                        case PUMP_NO_DELIVERY:
                        case PUMP_REWIND:
                        case PUMP_UNKNOWN_ERROR:
                        case PUMP_SUSPEND:
                        case PUMP_UNSUSPEND:
                            tmpCsvEntry.addPumpAnnotation(tmpEntry.getType().toString());
                            break;
                        case PUMP_PRIME:
                            tmpCsvEntry.addPumpAnnotation(tmpEntry.getType().toString()
                                    + "="
                                    + String.format(Locale.ENGLISH, DOUBLE_FORMAT, tmpEntry.getValue()));
                            break;
                        case HEART_RATE:
                            tmpCsvEntry.setHeartRateValue(tmpEntry.getValue());
                            break;
                        case HEART_RATE_VARIABILITY:
                            tmpCsvEntry.setHeartRateVariabilityValue(tmpEntry.getValue());
                            tmpCsvEntry.setStressBalanceValue(tmpEntry.getValue2());
                            break;
                        case STRESS:
                            tmpCsvEntry.setStressValue(tmpEntry.getValue());
                            break;
                        case LOC_FOOD:
                        case LOC_HOME:
                        case LOC_OTHER:
                        case LOC_SPORTS:
                        case LOC_TRANSISTION:
                        case LOC_WORK:
                            tmpCsvEntry.addLocationAnnotation(tmpEntry.getType().toString());
                            break;
                        case SLEEP_DEEP:
                        case SLEEP_LIGHT:
                        case SLEEP_REM:
                            tmpCsvEntry.addSleepAnnotation(tmpEntry.getType().toString());
                            tmpCsvEntry.setSleepValue(tmpEntry.getValue());
                            break;
                        default:
                            LOG.severe("ASSERTION ERROR!");
                            throw new AssertionError();
                    }

                }

                if (!tmpCsvEntry.isEmpty()) {
                    returnValues.add(tmpCsvEntry);
                    //LOG.log(Level.INFO, "Export entry: {0}", tmpCsvEntry.toCsvString());
                }
                fromTimestamp = TimestampUtils.addMinutesToTimestamp(fromTimestamp, 1);
            }
        }
        return returnValues;
    }

}

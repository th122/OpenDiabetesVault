package de.jhit.opendiabetes.vault.plot.config;

public class PlotteriaConfig {

    private int hmin = 70;
    private int hmax = 180;
    private double barWidth = 0.004;
    private int bgCgmMaxValue = 300;
    private double maxBasalValue = 3.5;
    private int cgmBgHighLimit = 300;
    private int cgmBgLimitMarkerLow = 60;
    private int cgmBgLimitMarkerHigh = 250;
    private int minHrValue = 20;
    private int maxHrValue = 160;
    private int minCgmBgValue = 50;

    private double legendXOffset = -0.05;
    private double legendYOffset = 0.295;

    // Plot booleans
    private boolean statisticsFlag = false;
    private boolean filterBg = true; // TODO change name: filterBgManual
    private boolean plotCarb = true;
    private boolean plotBolus = true;
    private boolean plotBolusCalculation = true;
    private boolean plotBasal = true;
    private boolean plotBg = true;
    private boolean plotCgm = true;
    private boolean plotHeartRate = true;
    private boolean plotSleep = true;
    private boolean plotSymbols = true;
    private boolean plotLocation = true;
    private boolean plotExercise = true;
    private boolean plotStress = true;

    // Plot Colors 
    private String hbgColor = "#d1fff4";
    private String gridColor = "#E6E6E6";
    private String carbBarColor = "#ed1c24";
    private String bolusBarColor = "#177d36";
    private String bolusCalculationColor = "#00ff00";
    private String bgPlotColor = "#9245dd";
    private String cgmPlotColor = "#63a7de";
    private String basalPlotColor = "#FAAC58";
    private String heartRatePlotColor = "#cc3399";
    private String overMaxColor = "#FF0000";
    private String symbolsColor = "#000000";
    private String pumpColor = "#000000";
    private String symbolsBackgroundColor = "#FFE5BA";
    private String cgmBgLimitMarkerColor = "#FFFFFF";
    private String stress0Color = "#ffffff";
    private String stress1Color = "#d5d5ff";
    private String stress2Color = "#ababff";
    private String stress3Color = "#8181ff";
    private String stress4Color = "#ff0000";
    private String exerciseWalkColor = "#E9C7B9";
    private String exerciseRunColor = "#BBE9B9";
    private String exerciseBicycleColor = "#B9C8E9";
    private String exerciseOtherColor = "#E5B9E9";
    private String lightSleepColor = "#d9d9d9";
    private String deepSleepColor = "#b3b3b3";

    // Axis Labels
    private boolean showXaxisLabel = false;
    private String xaxisLabel = "Time of Day [hh:mm]";
    private String bolusLabel = "Bolus/Carb [IE/BE]";
    private String basalLabel = "Basal [IE]";
    private String bgLabel = "BG [mg/dl]";
    private String hrLabel = "HeartRate [Hz]";

    private String titelDateFormat = "%a %d. %b";

    private String delimiter = ":";

    // Legend Labels
    private String bgLegend = "bg";
    private String cgmLegend = "cgm";
    private String basalLegend = "basal";
    private String heartRateLegend = "heart rate";
    private String carbLegend = "carb";
    private String bolusLegend = "bolus";
    private String bolusCalculatonLegend = "bolus calculation";

    // Symbol Labels
    private String exerciseLegend = "exercise";
    private String pumpRewindLegend = "rewind";
    private String pumpKatErrLegend = "katheder problem";

    // Symbol Markers
    private String rewindMarker = "*";
    private String katErrMarker = "p";
    private String exerciseMarker = "^";

    // Locations
    private String locTransitionLabel = "Transition";
    private String locHomeLabel = "Home";
    private String locWorkLabel = "Work";
    private String locFoodLabel = "Food";
    private String locSportsLabel = "Sports";
    private String locOtherLabel = "Other";

    private String locTransitionColor = "#6791E6";
    private String locHomeColor = "#9DE667";
    private String locWorkColor = "#F2F4B3";
    private String locFoodColor = "#E6A567";
    private String locSportsColor = "#67E686";
    private String locOtherColor = "#E667E2";

    // Exercise
    private String exerciseWalkLabel = "Walk";
    private String exerciseRunLabel = "Run";
    private String exerciseBicycleLabel = "Bicycle";
    private String exerciseOtherLabel = "Other";

    // Sleep
    private String lightSleepLabel = "Light Sleep";
    private String deepSleepLabel = "Deep Sleep";

    // Linewidths
    private double heartRateLineWidth = 1.0;
    private double basalLineWidth = 1.0;
    private double cgmLineWidth = 2.0;
    private double bgLineWidth = 1.0;
    //TODO add bolusCalculationLineWidth

    // File Settings
    private String filenamePrefix = "Plot";
    private String filenameDateFormatString = "%d_%m_%y";
    private String fileExtension = ".pdf";
    private String plotListFileDaily = "plotListDaily.tex";
    private String plotListFileSlices = "plotListSlices.tex";
    private String headerFileDaily = "headerDaily.tex";
    private String headerFileSlices = "headerSlices.tex";
    private String legendFile = "legend.pdf";

    public int getHmin() {
        return hmin;
    }

    public void setHmin(int hmin) {
        this.hmin = hmin;
    }

    public int getHmax() {
        return hmax;
    }

    public void setHmax(int hmax) {
        this.hmax = hmax;
    }

    public double getBarWidth() {
        return barWidth;
    }

    public void setBarWidth(double barWidth) {
        this.barWidth = barWidth;
    }

    public int getBgCgmMaxValue() {
        return bgCgmMaxValue;
    }

    public void setBgCgmMaxValue(int bgCgmMaxValue) {
        this.bgCgmMaxValue = bgCgmMaxValue;
    }

    public double getMaxBasalValue() {
        return maxBasalValue;
    }

    public void setMaxBasalValue(double maxBasalValue) {
        this.maxBasalValue = maxBasalValue;
    }

    public int getCgmBgHighLimit() {
        return cgmBgHighLimit;
    }

    public void setCgmBgHighLimit(int cgmBgHighLimit) {
        this.cgmBgHighLimit = cgmBgHighLimit;
    }

    public int getCgmBgLimitMarkerLow() {
        return cgmBgLimitMarkerLow;
    }

    public void setCgmBgLimitMarkerLow(int cgmBgLimitMarkerLow) {
        this.cgmBgLimitMarkerLow = cgmBgLimitMarkerLow;
    }

    public int getCgmBgLimitMarkerHigh() {
        return cgmBgLimitMarkerHigh;
    }

    public void setCgmBgLimitMarkerHigh(int cgmBgLimitMarkerHigh) {
        this.cgmBgLimitMarkerHigh = cgmBgLimitMarkerHigh;
    }

    public int getMinHrValue() {
        return minHrValue;
    }

    public void setMinHrValue(int minHrValue) {
        this.minHrValue = minHrValue;
    }

    public int getMaxHrValue() {
        return maxHrValue;
    }

    public void setMaxHrValue(int maxHrValue) {
        this.maxHrValue = maxHrValue;
    }

    public int getMinCgmBgValue() {
        return minCgmBgValue;
    }

    public void setMinCgmBgValue(int minCgmBgValue) {
        this.minCgmBgValue = minCgmBgValue;
    }

    public double getLegendXOffset() {
        return legendXOffset;
    }

    public void setLegendXOffset(double legendXOffset) {
        this.legendXOffset = legendXOffset;
    }

    public double getLegendYOffset() {
        return legendYOffset;
    }

    public void setLegendYOffset(double legendYOffset) {
        this.legendYOffset = legendYOffset;
    }

    public boolean isStatisticsFlag() {
        return statisticsFlag;
    }

    public void setStatisticsFlag(boolean statisticsFlag) {
        this.statisticsFlag = statisticsFlag;
    }

    public boolean isFilterBg() {
        return filterBg;
    }

    public void setFilterBg(boolean filterBg) {
        this.filterBg = filterBg;
    }

    public boolean isPlotCarb() {
        return plotCarb;
    }

    public void setPlotCarb(boolean plotCarb) {
        this.plotCarb = plotCarb;
    }

    public boolean isPlotBolus() {
        return plotBolus;
    }

    public void setPlotBolus(boolean plotBolus) {
        this.plotBolus = plotBolus;
    }

    public boolean isPlotBolusCalculation() {
        return plotBolusCalculation;
    }

    public void setPlotBolusCalculation(boolean plotBolusCalculation) {
        this.plotBolusCalculation = plotBolusCalculation;
    }

    public boolean isPlotBasal() {
        return plotBasal;
    }

    public void setPlotBasal(boolean plotBasal) {
        this.plotBasal = plotBasal;
    }

    public boolean isPlotBg() {
        return plotBg;
    }

    public void setPlotBg(boolean plotBg) {
        this.plotBg = plotBg;
    }

    public boolean isPlotCgm() {
        return plotCgm;
    }

    public void setPlotCgm(boolean plotCgm) {
        this.plotCgm = plotCgm;
    }

    public boolean isPlotHeartRate() {
        return plotHeartRate;
    }

    public void setPlotHeartRate(boolean plotHeartRate) {
        this.plotHeartRate = plotHeartRate;
    }

    public boolean isPlotSleep() {
        return plotSleep;
    }

    public void setPlotSleep(boolean plotSleep) {
        this.plotSleep = plotSleep;
    }

    public boolean isPlotSymbols() {
        return plotSymbols;
    }

    public void setPlotSymbols(boolean plotSymbols) {
        this.plotSymbols = plotSymbols;
    }

    public boolean isPlotLocation() {
        return plotLocation;
    }

    public void setPlotLocation(boolean plotLocation) {
        this.plotLocation = plotLocation;
    }

    public boolean isPlotExercise() {
        return plotExercise;
    }

    public void setPlotExercise(boolean plotExercise) {
        this.plotExercise = plotExercise;
    }

    public boolean isPlotStress() {
        return plotStress;
    }

    public void setPlotStress(boolean plotStress) {
        this.plotStress = plotStress;
    }

    public String getHbgColor() {
        return hbgColor;
    }

    public void setHbgColor(String hbgColor) {
        this.hbgColor = hbgColor;
    }

    public String getGridColor() {
        return gridColor;
    }

    public void setGridColor(String gridColor) {
        this.gridColor = gridColor;
    }

    public String getCarbBarColor() {
        return carbBarColor;
    }

    public void setCarbBarColor(String carbBarColor) {
        this.carbBarColor = carbBarColor;
    }

    public String getBolusBarColor() {
        return bolusBarColor;
    }

    public void setBolusBarColor(String bolusBarColor) {
        this.bolusBarColor = bolusBarColor;
    }

    public String getBolusCalculationColor() {
        return bolusCalculationColor;
    }

    public void setBolusCalculationColor(String bolusCalculationColor) {
        this.bolusCalculationColor = bolusCalculationColor;
    }

    public String getBgPlotColor() {
        return bgPlotColor;
    }

    public void setBgPlotColor(String bgPlotColor) {
        this.bgPlotColor = bgPlotColor;
    }

    public String getCgmPlotColor() {
        return cgmPlotColor;
    }

    public void setCgmPlotColor(String cgmPlotColor) {
        this.cgmPlotColor = cgmPlotColor;
    }

    public String getBasalPlotColor() {
        return basalPlotColor;
    }

    public void setBasalPlotColor(String basalPlotColor) {
        this.basalPlotColor = basalPlotColor;
    }

    public String getHeartRatePlotColor() {
        return heartRatePlotColor;
    }

    public void setHeartRatePlotColor(String heartRatePlotColor) {
        this.heartRatePlotColor = heartRatePlotColor;
    }

    public String getOverMaxColor() {
        return overMaxColor;
    }

    public void setOverMaxColor(String overMaxColor) {
        this.overMaxColor = overMaxColor;
    }

    public String getSymbolsColor() {
        return symbolsColor;
    }

    public void setSymbolsColor(String symbolsColor) {
        this.symbolsColor = symbolsColor;
    }

    public String getPumpColor() {
        return pumpColor;
    }

    public void setPumpColor(String pumpColor) {
        this.pumpColor = pumpColor;
    }

    public String getSymbolsBackgroundColor() {
        return symbolsBackgroundColor;
    }

    public void setSymbolsBackgroundColor(String symbolsBackgroundColor) {
        this.symbolsBackgroundColor = symbolsBackgroundColor;
    }

    public String getCgmBgLimitMarkerColor() {
        return cgmBgLimitMarkerColor;
    }

    public void setCgmBgLimitMarkerColor(String cgmBgLimitMarkerColor) {
        this.cgmBgLimitMarkerColor = cgmBgLimitMarkerColor;
    }

    public String getStress1Color() {
        return stress1Color;
    }

    public void setStress1Color(String stress1Color) {
        this.stress1Color = stress1Color;
    }

    public String getStress2Color() {
        return stress2Color;
    }

    public void setStress2Color(String stress2Color) {
        this.stress2Color = stress2Color;
    }

    public String getStress3Color() {
        return stress3Color;
    }

    public void setStress3Color(String stress3Color) {
        this.stress3Color = stress3Color;
    }

    public String getStress4Color() {
        return stress4Color;
    }

    public void setStress4Color(String stress4Color) {
        this.stress4Color = stress4Color;
    }

    public String getExerciseWalkColor() {
        return exerciseWalkColor;
    }

    public void setExerciseWalkColor(String exerciseWalkColor) {
        this.exerciseWalkColor = exerciseWalkColor;
    }

    public String getExerciseRunColor() {
        return exerciseRunColor;
    }

    public void setExerciseRunColor(String exerciseRunColor) {
        this.exerciseRunColor = exerciseRunColor;
    }

    public String getExerciseBicycleColor() {
        return exerciseBicycleColor;
    }

    public void setExerciseBicycleColor(String exerciseBicycleColor) {
        this.exerciseBicycleColor = exerciseBicycleColor;
    }

    public String getExerciseOtherColor() {
        return exerciseOtherColor;
    }

    public void setExerciseOtherColor(String exerciseOtherColor) {
        this.exerciseOtherColor = exerciseOtherColor;
    }

    public String getLightSleepColor() {
        return lightSleepColor;
    }

    public void setLightSleepColor(String lightSleepColor) {
        this.lightSleepColor = lightSleepColor;
    }

    public String getDeepSleepColor() {
        return deepSleepColor;
    }

    public void setDeepSleepColor(String deepSleepColor) {
        this.deepSleepColor = deepSleepColor;
    }

    public boolean isShowXaxisLabel() {
        return showXaxisLabel;
    }

    public void setShowXaxisLabel(boolean showXaxisLabel) {
        this.showXaxisLabel = showXaxisLabel;
    }

    public String getXaxisLabel() {
        return xaxisLabel;
    }

    public void setXaxisLabel(String xaxisLabel) {
        this.xaxisLabel = xaxisLabel;
    }

    public String getBolusLabel() {
        return bolusLabel;
    }

    public void setBolusLabel(String bolusLabel) {
        this.bolusLabel = bolusLabel;
    }

    public String getBasalLabel() {
        return basalLabel;
    }

    public void setBasalLabel(String basalLabel) {
        this.basalLabel = basalLabel;
    }

    public String getBgLabel() {
        return bgLabel;
    }

    public void setBgLabel(String bgLabel) {
        this.bgLabel = bgLabel;
    }

    public String getHrLabel() {
        return hrLabel;
    }

    public void setHrLabel(String hrLabel) {
        this.hrLabel = hrLabel;
    }

    public String getTitelDateFormat() {
        return titelDateFormat;
    }

    public void setTitelDateFormat(String titelDateFormat) {
        this.titelDateFormat = titelDateFormat;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getBgLegend() {
        return bgLegend;
    }

    public void setBgLegend(String bgLegend) {
        this.bgLegend = bgLegend;
    }

    public String getCgmLegend() {
        return cgmLegend;
    }

    public void setCgmLegend(String cgmLegend) {
        this.cgmLegend = cgmLegend;
    }

    public String getBasalLegend() {
        return basalLegend;
    }

    public void setBasalLegend(String basalLegend) {
        this.basalLegend = basalLegend;
    }

    public String getHeartRateLegend() {
        return heartRateLegend;
    }

    public void setHeartRateLegend(String heartRateLegend) {
        this.heartRateLegend = heartRateLegend;
    }

    public String getCarbLegend() {
        return carbLegend;
    }

    public void setCarbLegend(String carbLegend) {
        this.carbLegend = carbLegend;
    }

    public String getBolusLegend() {
        return bolusLegend;
    }

    public void setBolusLegend(String bolusLegend) {
        this.bolusLegend = bolusLegend;
    }

    public String getBolusCalculatonLegend() {
        return bolusCalculatonLegend;
    }

    public void setBolusCalculatonLegend(String bolusCalculatonLegend) {
        this.bolusCalculatonLegend = bolusCalculatonLegend;
    }

    public String getExerciseLegend() {
        return exerciseLegend;
    }

    public void setExerciseLegend(String exerciseLegend) {
        this.exerciseLegend = exerciseLegend;
    }

    public String getPumpRewindLegend() {
        return pumpRewindLegend;
    }

    public void setPumpRewindLegend(String pumpRewindLegend) {
        this.pumpRewindLegend = pumpRewindLegend;
    }

    public String getPumpKatErrLegend() {
        return pumpKatErrLegend;
    }

    public void setPumpKatErrLegend(String pumpKatErrLegend) {
        this.pumpKatErrLegend = pumpKatErrLegend;
    }

    public String getRewindMarker() {
        return rewindMarker;
    }

    public void setRewindMarker(String rewindMarker) {
        this.rewindMarker = rewindMarker;
    }

    public String getKatErrMarker() {
        return katErrMarker;
    }

    public void setKatErrMarker(String katErrMarker) {
        this.katErrMarker = katErrMarker;
    }

    public String getExerciseMarker() {
        return exerciseMarker;
    }

    public void setExerciseMarker(String exerciseMarker) {
        this.exerciseMarker = exerciseMarker;
    }

    public String getLocTransitionLabel() {
        return locTransitionLabel;
    }

    public void setLocTransitionLabel(String locTransitionLabel) {
        this.locTransitionLabel = locTransitionLabel;
    }

    public String getLocHomeLabel() {
        return locHomeLabel;
    }

    public void setLocHomeLabel(String locHomeLabel) {
        this.locHomeLabel = locHomeLabel;
    }

    public String getLocWorkLabel() {
        return locWorkLabel;
    }

    public void setLocWorkLabel(String locWorkLabel) {
        this.locWorkLabel = locWorkLabel;
    }

    public String getLocFoodLabel() {
        return locFoodLabel;
    }

    public void setLocFoodLabel(String locFoodLabel) {
        this.locFoodLabel = locFoodLabel;
    }

    public String getLocSportsLabel() {
        return locSportsLabel;
    }

    public void setLocSportsLabel(String locSportsLabel) {
        this.locSportsLabel = locSportsLabel;
    }

    public String getLocOtherLabel() {
        return locOtherLabel;
    }

    public void setLocOtherLabel(String locOtherLabel) {
        this.locOtherLabel = locOtherLabel;
    }

    public String getLocTransitionColor() {
        return locTransitionColor;
    }

    public void setLocTransitionColor(String locTransitionColor) {
        this.locTransitionColor = locTransitionColor;
    }

    public String getLocHomeColor() {
        return locHomeColor;
    }

    public void setLocHomeColor(String locHomeColor) {
        this.locHomeColor = locHomeColor;
    }

    public String getLocWorkColor() {
        return locWorkColor;
    }

    public void setLocWorkColor(String locWorkColor) {
        this.locWorkColor = locWorkColor;
    }

    public String getLocFoodColor() {
        return locFoodColor;
    }

    public void setLocFoodColor(String locFoodColor) {
        this.locFoodColor = locFoodColor;
    }

    public String getLocSportsColor() {
        return locSportsColor;
    }

    public void setLocSportsColor(String locSportsColor) {
        this.locSportsColor = locSportsColor;
    }

    public String getLocOtherColor() {
        return locOtherColor;
    }

    public void setLocOtherColor(String locOtherColor) {
        this.locOtherColor = locOtherColor;
    }

    public String getExerciseWalkLabel() {
        return exerciseWalkLabel;
    }

    public void setExerciseWalkLabel(String exerciseWalkLabel) {
        this.exerciseWalkLabel = exerciseWalkLabel;
    }

    public String getExerciseRunLabel() {
        return exerciseRunLabel;
    }

    public void setExerciseRunLabel(String exerciseRunLabel) {
        this.exerciseRunLabel = exerciseRunLabel;
    }

    public String getExerciseBicycleLabel() {
        return exerciseBicycleLabel;
    }

    public void setExerciseBicycleLabel(String exerciseBicycleLabel) {
        this.exerciseBicycleLabel = exerciseBicycleLabel;
    }

    public String getExerciseOtherLabel() {
        return exerciseOtherLabel;
    }

    public void setExerciseOtherLabel(String exerciseOtherLabel) {
        this.exerciseOtherLabel = exerciseOtherLabel;
    }

    public String getLightSleepLabel() {
        return lightSleepLabel;
    }

    public void setLightSleepLabel(String lightSleepLabel) {
        this.lightSleepLabel = lightSleepLabel;
    }

    public String getDeepSleepLabel() {
        return deepSleepLabel;
    }

    public void setDeepSleepLabel(String deepSleepLabel) {
        this.deepSleepLabel = deepSleepLabel;
    }

    public double getHeartRateLineWidth() {
        return heartRateLineWidth;
    }

    public void setHeartRateLineWidth(double heartRateLineWidth) {
        this.heartRateLineWidth = heartRateLineWidth;
    }

    public double getBasalLineWidth() {
        return basalLineWidth;
    }

    public void setBasalLineWidth(double basalLineWidth) {
        this.basalLineWidth = basalLineWidth;
    }

    public double getCgmLineWidth() {
        return cgmLineWidth;
    }

    public void setCgmLineWidth(double cgmLineWidth) {
        this.cgmLineWidth = cgmLineWidth;
    }

    public double getBgLineWidth() {
        return bgLineWidth;
    }

    public void setBgLineWidth(double bgLineWidth) {
        this.bgLineWidth = bgLineWidth;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }

    public String getFilenameDateFormatString() {
        return filenameDateFormatString;
    }

    public void setFilenameDateFormatString(String filenameDateFormatString) {
        this.filenameDateFormatString = filenameDateFormatString;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getPlotListFileDaily() {
        return plotListFileDaily;
    }

    public void setPlotListFileDaily(String plotListFileDaily) {
        this.plotListFileDaily = plotListFileDaily;
    }

    public String getPlotListFileSlices() {
        return plotListFileSlices;
    }

    public void setPlotListFileSlices(String plotListFileSlices) {
        this.plotListFileSlices = plotListFileSlices;
    }

    public String getHeaderFileDaily() {
        return headerFileDaily;
    }

    public void setHeaderFileDaily(String headerFileDaily) {
        this.headerFileDaily = headerFileDaily;
    }

    public String getHeaderFileSlices() {
        return headerFileSlices;
    }

    public void setHeaderFileSlices(String headerFileSlices) {
        this.headerFileSlices = headerFileSlices;
    }

    public String getLegendFile() {
        return legendFile;
    }

    public void setLegendFile(String legendFile) {
        this.legendFile = legendFile;
    }
}
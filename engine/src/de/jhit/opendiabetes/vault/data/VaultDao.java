/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jhit.opendiabetes.vault.data;

import de.jhit.opendiabetes.vault.util.TimestampUtils;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.HsqldbDatabaseType;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import de.jhit.opendiabetes.vault.container.VaultEntry;
import de.jhit.opendiabetes.vault.container.VaultEntryType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mswin
 */
public class VaultDao {

    private static final String DATABASE_URL = "jdbc:hsqldb:mem:odvault";
    private static final Logger LOG = Logger.getLogger(VaultDao.class.getName());
    private static VaultDao INSTANCE = null;

    private ConnectionSource connectionSource;
    private Dao<VaultEntry, Long> vaultDao;

    private VaultDao() {
    }

    public static VaultDao getInstance() {
        if (INSTANCE == null) {
            LOG.severe("Database is not initialized. Call VaultDao.initializeDb first!");
            System.exit(-1);
        }
        return INSTANCE;
    }

    public static void finalizeDb() throws IOException {
        INSTANCE.connectionSource.close();
    }

    public static void initializeDb() throws SQLException {
        //TODO combine logging
        System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "INFO");
        INSTANCE = new VaultDao();
        INSTANCE.initDb();
    }

    private void initDb() throws SQLException {
        // create a connection source to our database
        connectionSource = new JdbcConnectionSource(DATABASE_URL, "sa", "", new HsqldbDatabaseType());
        // instantiate the DAO to handle Account with String id
        vaultDao = DaoManager.createDao(connectionSource, VaultEntry.class);
        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, VaultEntry.class);
    }

    public boolean putEntryIfNotExist(VaultEntry entry) {
        try {
            PreparedQuery<VaultEntry> query = vaultDao.queryBuilder()
                    .where()
                    .eq(VaultEntry.TIMESTAMP_FIELD_NAME, entry.getTimestamp())
                    .prepare();
            List<VaultEntry> dublicates = vaultDao.query(query);
            for (VaultEntry item : dublicates) {
                if (item.equals(entry)) {
                    return true;
                }
            }
            // not found --> put it in
            vaultDao.createIfNotExists(entry);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error saving entry:\n" + entry.toString(), ex);
            return false;
        }
        return true;
    }

    public List<VaultEntry> queryGlucoseBetween(Date from, Date to) {
        List<VaultEntry> returnValues = null;
        try {
            PreparedQuery<VaultEntry> query
                    = vaultDao.queryBuilder().orderBy("timestamp", true)
                            .where()
                            .eq(VaultEntry.TYPE_FIELD_NAME, VaultEntryType.GLUCOSE_BG)
                            .or()
                            .eq(VaultEntry.TYPE_FIELD_NAME, VaultEntryType.GLUCOSE_CGM)
                            .or()
                            .eq(VaultEntry.TYPE_FIELD_NAME, VaultEntryType.GLUCOSE_CGM_ALERT)
                            .between(VaultEntry.TIMESTAMP_FIELD_NAME, from, to)
                            .prepare();
            returnValues = vaultDao.query(query);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error while db query", ex);
        }
        return returnValues;
    }

    public List<VaultEntry> queryAllVaultEntrys() {
        List<VaultEntry> returnValues = new ArrayList<>();
        try {

            PreparedQuery<VaultEntry> query
                    = vaultDao.queryBuilder().orderBy("timestamp", true)
                            .prepare();
            returnValues = vaultDao.query(query);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error while db query", ex);
        }
        return returnValues;
    }

    public List<VaultEntry> queryVaultEntrysBetween(Date from, Date to) {
        List<VaultEntry> returnValues = new ArrayList<>();
        try {
            Date fromTimestamp = TimestampUtils.createCleanTimestamp(from);
            Date toTimestamp = TimestampUtils.createCleanTimestamp(to);

            PreparedQuery<VaultEntry> query
                    = vaultDao.queryBuilder().orderBy("timestamp", true)
                            .where()
                            .between(VaultEntry.TIMESTAMP_FIELD_NAME, fromTimestamp, toTimestamp)
                            .prepare();
            returnValues = vaultDao.query(query);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error while db query", ex);
        }
        return returnValues;
    }

    public void doit() throws SQLException {

// retrieve the account
//        Account account2 = accountDao.queryForId(name);
    }
}
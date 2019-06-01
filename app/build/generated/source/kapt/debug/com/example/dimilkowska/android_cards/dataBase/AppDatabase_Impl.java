package com.example.dimilkowska.android_cards.dataBase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.example.dimilkowska.android_cards.dao.CardDao;
import com.example.dimilkowska.android_cards.dao.CardDao_Impl;
import com.example.dimilkowska.android_cards.dao.TransactionDao;
import com.example.dimilkowska.android_cards.dao.TransactionDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AppDatabase_Impl extends AppDatabase {
  private volatile CardDao _cardDao;

  private volatile TransactionDao _transactionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Card` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `account` TEXT NOT NULL, `period` INTEGER NOT NULL, `limit_total` REAL NOT NULL, `limit_count` REAL NOT NULL, `free_100` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cardTransaction` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT NOT NULL, `amount` REAL NOT NULL, `account` TEXT NOT NULL, `id_card` INTEGER, `date_created` INTEGER NOT NULL, FOREIGN KEY(`id_card`) REFERENCES `Card`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE  INDEX `index_cardTransaction_title` ON `cardTransaction` (`title`)");
        _db.execSQL("CREATE  INDEX `index_cardTransaction_amount` ON `cardTransaction` (`amount`)");
        _db.execSQL("CREATE  INDEX `index_cardTransaction_account` ON `cardTransaction` (`account`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"1216cf2df47eacb406293e0575f0481e\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Card`");
        _db.execSQL("DROP TABLE IF EXISTS `cardTransaction`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCard = new HashMap<String, TableInfo.Column>(7);
        _columnsCard.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsCard.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsCard.put("account", new TableInfo.Column("account", "TEXT", true, 0));
        _columnsCard.put("period", new TableInfo.Column("period", "INTEGER", true, 0));
        _columnsCard.put("limit_total", new TableInfo.Column("limit_total", "REAL", true, 0));
        _columnsCard.put("limit_count", new TableInfo.Column("limit_count", "REAL", true, 0));
        _columnsCard.put("free_100", new TableInfo.Column("free_100", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCard = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCard = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCard = new TableInfo("Card", _columnsCard, _foreignKeysCard, _indicesCard);
        final TableInfo _existingCard = TableInfo.read(_db, "Card");
        if (! _infoCard.equals(_existingCard)) {
          throw new IllegalStateException("Migration didn't properly handle Card(com.example.dimilkowska.android_cards.entity.Card).\n"
                  + " Expected:\n" + _infoCard + "\n"
                  + " Found:\n" + _existingCard);
        }
        final HashMap<String, TableInfo.Column> _columnsCardTransaction = new HashMap<String, TableInfo.Column>(6);
        _columnsCardTransaction.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsCardTransaction.put("title", new TableInfo.Column("title", "TEXT", true, 0));
        _columnsCardTransaction.put("amount", new TableInfo.Column("amount", "REAL", true, 0));
        _columnsCardTransaction.put("account", new TableInfo.Column("account", "TEXT", true, 0));
        _columnsCardTransaction.put("id_card", new TableInfo.Column("id_card", "INTEGER", false, 0));
        _columnsCardTransaction.put("date_created", new TableInfo.Column("date_created", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCardTransaction = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysCardTransaction.add(new TableInfo.ForeignKey("Card", "NO ACTION", "NO ACTION",Arrays.asList("id_card"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesCardTransaction = new HashSet<TableInfo.Index>(3);
        _indicesCardTransaction.add(new TableInfo.Index("index_cardTransaction_title", false, Arrays.asList("title")));
        _indicesCardTransaction.add(new TableInfo.Index("index_cardTransaction_amount", false, Arrays.asList("amount")));
        _indicesCardTransaction.add(new TableInfo.Index("index_cardTransaction_account", false, Arrays.asList("account")));
        final TableInfo _infoCardTransaction = new TableInfo("cardTransaction", _columnsCardTransaction, _foreignKeysCardTransaction, _indicesCardTransaction);
        final TableInfo _existingCardTransaction = TableInfo.read(_db, "cardTransaction");
        if (! _infoCardTransaction.equals(_existingCardTransaction)) {
          throw new IllegalStateException("Migration didn't properly handle cardTransaction(com.example.dimilkowska.android_cards.entity.Transaction).\n"
                  + " Expected:\n" + _infoCardTransaction + "\n"
                  + " Found:\n" + _existingCardTransaction);
        }
      }
    }, "1216cf2df47eacb406293e0575f0481e", "0e22630e1c8d6730a73bbd33a2c3d5e9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Card","cardTransaction");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `cardTransaction`");
      _db.execSQL("DELETE FROM `Card`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CardDao cardDao() {
    if (_cardDao != null) {
      return _cardDao;
    } else {
      synchronized(this) {
        if(_cardDao == null) {
          _cardDao = new CardDao_Impl(this);
        }
        return _cardDao;
      }
    }
  }

  @Override
  public TransactionDao transactionDao() {
    if (_transactionDao != null) {
      return _transactionDao;
    } else {
      synchronized(this) {
        if(_transactionDao == null) {
          _transactionDao = new TransactionDao_Impl(this);
        }
        return _transactionDao;
      }
    }
  }
}

package com.example.dimilkowska.android_cards.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.example.dimilkowska.android_cards.entity.Transaction;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class TransactionDao_Impl implements TransactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTransaction;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTransaction;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTransaction;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTransactionByCardId;

  public TransactionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransaction = new EntityInsertionAdapter<Transaction>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `cardTransaction`(`id`,`title`,`amount`,`account`,`id_card`,`date_created`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Transaction value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        stmt.bindDouble(3, value.getAmount());
        if (value.getAccount() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAccount());
        }
        if (value.getId_card() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getId_card());
        }
        stmt.bindLong(6, value.getDate_created());
      }
    };
    this.__deletionAdapterOfTransaction = new EntityDeletionOrUpdateAdapter<Transaction>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `cardTransaction` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Transaction value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfTransaction = new EntityDeletionOrUpdateAdapter<Transaction>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `cardTransaction` SET `id` = ?,`title` = ?,`amount` = ?,`account` = ?,`id_card` = ?,`date_created` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Transaction value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        stmt.bindDouble(3, value.getAmount());
        if (value.getAccount() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAccount());
        }
        if (value.getId_card() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getId_card());
        }
        stmt.bindLong(6, value.getDate_created());
        if (value.getId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteTransactionByCardId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM cardTransaction WHERE id_card = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertTransaction(Transaction transaction) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTransaction.insert(transaction);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTransaction(Transaction transaction) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTransaction.handle(transaction);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTransaction(Transaction transaction) {
    __db.beginTransaction();
    try {
      __updateAdapterOfTransaction.handle(transaction);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTransactionByCardId(int cardId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTransactionByCardId.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, cardId);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTransactionByCardId.release(_stmt);
    }
  }

  @Override
  public List<Transaction> getAllTransactions(int cardId) {
    final String _sql = "SELECT * FROM cardTransaction WHERE id_card = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cardId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("amount");
      final int _cursorIndexOfAccount = _cursor.getColumnIndexOrThrow("account");
      final int _cursorIndexOfIdCard = _cursor.getColumnIndexOrThrow("id_card");
      final int _cursorIndexOfDateCreated = _cursor.getColumnIndexOrThrow("date_created");
      final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Transaction _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final float _tmpAmount;
        _tmpAmount = _cursor.getFloat(_cursorIndexOfAmount);
        final String _tmpAccount;
        _tmpAccount = _cursor.getString(_cursorIndexOfAccount);
        final Integer _tmpId_card;
        if (_cursor.isNull(_cursorIndexOfIdCard)) {
          _tmpId_card = null;
        } else {
          _tmpId_card = _cursor.getInt(_cursorIndexOfIdCard);
        }
        final long _tmpDate_created;
        _tmpDate_created = _cursor.getLong(_cursorIndexOfDateCreated);
        _item = new Transaction(_tmpId,_tmpTitle,_tmpAmount,_tmpAccount,_tmpId_card,_tmpDate_created);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long noAllTransactionsByDate(long from, long to, int cardId) {
    final String _sql = "SELECT count(*) FROM cardTransaction WHERE date_created BETWEEN ? AND ? AND id_card = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, from);
    _argIndex = 2;
    _statement.bindLong(_argIndex, to);
    _argIndex = 3;
    _statement.bindLong(_argIndex, cardId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long sumAllTransactionsByDate(long from, long to, int cardId) {
    final String _sql = "SELECT sum(amount) FROM cardTransaction WHERE date_created BETWEEN ? AND ? AND id_card = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, from);
    _argIndex = 2;
    _statement.bindLong(_argIndex, to);
    _argIndex = 3;
    _statement.bindLong(_argIndex, cardId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

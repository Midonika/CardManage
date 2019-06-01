package com.example.dimilkowska.android_cards.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import com.example.dimilkowska.android_cards.entity.Card;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class CardDao_Impl implements CardDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCard;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCard;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCard;

  public CardDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCard = new EntityInsertionAdapter<Card>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Card`(`id`,`name`,`account`,`period`,`limit_total`,`limit_count`,`free_100`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Card value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAccount() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAccount());
        }
        stmt.bindLong(4, value.getPeriod());
        stmt.bindDouble(5, value.getLimit_total());
        stmt.bindDouble(6, value.getLimit_count());
        final int _tmp;
        _tmp = value.getFree_100() ? 1 : 0;
        stmt.bindLong(7, _tmp);
      }
    };
    this.__deletionAdapterOfCard = new EntityDeletionOrUpdateAdapter<Card>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Card` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Card value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfCard = new EntityDeletionOrUpdateAdapter<Card>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Card` SET `id` = ?,`name` = ?,`account` = ?,`period` = ?,`limit_total` = ?,`limit_count` = ?,`free_100` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Card value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAccount() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAccount());
        }
        stmt.bindLong(4, value.getPeriod());
        stmt.bindDouble(5, value.getLimit_total());
        stmt.bindDouble(6, value.getLimit_count());
        final int _tmp;
        _tmp = value.getFree_100() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getId());
        }
      }
    };
  }

  @Override
  public long insertCard(Card card) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCard.insertAndReturnId(card);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCard(Card card) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCard.handle(card);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCard(Card card) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCard.handle(card);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Card> getCardByName(String name) {
    final String _sql = "SELECT * FROM card WHERE name == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfAccount = _cursor.getColumnIndexOrThrow("account");
      final int _cursorIndexOfPeriod = _cursor.getColumnIndexOrThrow("period");
      final int _cursorIndexOfLimitTotal = _cursor.getColumnIndexOrThrow("limit_total");
      final int _cursorIndexOfLimitCount = _cursor.getColumnIndexOrThrow("limit_count");
      final int _cursorIndexOfFree100 = _cursor.getColumnIndexOrThrow("free_100");
      final List<Card> _result = new ArrayList<Card>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Card _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpAccount;
        _tmpAccount = _cursor.getString(_cursorIndexOfAccount);
        final int _tmpPeriod;
        _tmpPeriod = _cursor.getInt(_cursorIndexOfPeriod);
        final double _tmpLimit_total;
        _tmpLimit_total = _cursor.getDouble(_cursorIndexOfLimitTotal);
        final double _tmpLimit_count;
        _tmpLimit_count = _cursor.getDouble(_cursorIndexOfLimitCount);
        final boolean _tmpFree_100;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfFree100);
        _tmpFree_100 = _tmp != 0;
        _item = new Card(_tmpId,_tmpName,_tmpAccount,_tmpPeriod,_tmpLimit_total,_tmpLimit_count,_tmpFree_100);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Card> getCards() {
    final String _sql = "SELECT * FROM card";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfAccount = _cursor.getColumnIndexOrThrow("account");
      final int _cursorIndexOfPeriod = _cursor.getColumnIndexOrThrow("period");
      final int _cursorIndexOfLimitTotal = _cursor.getColumnIndexOrThrow("limit_total");
      final int _cursorIndexOfLimitCount = _cursor.getColumnIndexOrThrow("limit_count");
      final int _cursorIndexOfFree100 = _cursor.getColumnIndexOrThrow("free_100");
      final List<Card> _result = new ArrayList<Card>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Card _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpAccount;
        _tmpAccount = _cursor.getString(_cursorIndexOfAccount);
        final int _tmpPeriod;
        _tmpPeriod = _cursor.getInt(_cursorIndexOfPeriod);
        final double _tmpLimit_total;
        _tmpLimit_total = _cursor.getDouble(_cursorIndexOfLimitTotal);
        final double _tmpLimit_count;
        _tmpLimit_count = _cursor.getDouble(_cursorIndexOfLimitCount);
        final boolean _tmpFree_100;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfFree100);
        _tmpFree_100 = _tmp != 0;
        _item = new Card(_tmpId,_tmpName,_tmpAccount,_tmpPeriod,_tmpLimit_total,_tmpLimit_count,_tmpFree_100);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

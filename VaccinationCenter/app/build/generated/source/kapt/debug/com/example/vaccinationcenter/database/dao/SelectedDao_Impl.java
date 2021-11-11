package com.example.vaccinationcenter.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.vaccinationcenter.database.entity.Selected;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SelectedDao_Impl implements SelectedDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Selected> __insertionAdapterOfSelected;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SelectedDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSelected = new EntityInsertionAdapter<Selected>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Selected` (`id`,`centerName`,`sido`,`sigungu`,`facilityName`,`address`,`phoneNumber`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Selected value) {
        stmt.bindLong(1, value.getId());
        if (value.getCenterName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCenterName());
        }
        if (value.getSido() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSido());
        }
        if (value.getSigungu() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSigungu());
        }
        if (value.getFacilityName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFacilityName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAddress());
        }
        if (value.getPhoneNumber() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhoneNumber());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Selected WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Selected";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Selected selected) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSelected.insert(selected);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<Selected> getAll() {
    final String _sql = "SELECT * FROM Selected";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCenterName = CursorUtil.getColumnIndexOrThrow(_cursor, "centerName");
      final int _cursorIndexOfSido = CursorUtil.getColumnIndexOrThrow(_cursor, "sido");
      final int _cursorIndexOfSigungu = CursorUtil.getColumnIndexOrThrow(_cursor, "sigungu");
      final int _cursorIndexOfFacilityName = CursorUtil.getColumnIndexOrThrow(_cursor, "facilityName");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
      final List<Selected> _result = new ArrayList<Selected>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Selected _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCenterName;
        if (_cursor.isNull(_cursorIndexOfCenterName)) {
          _tmpCenterName = null;
        } else {
          _tmpCenterName = _cursor.getString(_cursorIndexOfCenterName);
        }
        final String _tmpSido;
        if (_cursor.isNull(_cursorIndexOfSido)) {
          _tmpSido = null;
        } else {
          _tmpSido = _cursor.getString(_cursorIndexOfSido);
        }
        final String _tmpSigungu;
        if (_cursor.isNull(_cursorIndexOfSigungu)) {
          _tmpSigungu = null;
        } else {
          _tmpSigungu = _cursor.getString(_cursorIndexOfSigungu);
        }
        final String _tmpFacilityName;
        if (_cursor.isNull(_cursorIndexOfFacilityName)) {
          _tmpFacilityName = null;
        } else {
          _tmpFacilityName = _cursor.getString(_cursorIndexOfFacilityName);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        _item = new Selected(_tmpId,_tmpCenterName,_tmpSido,_tmpSigungu,_tmpFacilityName,_tmpAddress,_tmpPhoneNumber);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

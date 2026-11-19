package ar.jornadas.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CarteleraDao_Impl extends CarteleraDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Charla> __insertionAdapterOfCharla;

  private final SharedSQLiteStatement __preparedStmtOfAlternar;

  private final SharedSQLiteStatement __preparedStmtOfBorrarTodas;

  public CarteleraDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCharla = new EntityInsertionAdapter<Charla>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `charlas` (`id`,`titulo`,`tema`,`dia`,`hora`,`sala`,`ponente`,`resumen`,`favorita`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Charla entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitulo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitulo());
        }
        if (entity.getTema() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTema());
        }
        statement.bindLong(4, entity.getDia());
        if (entity.getHora() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getHora());
        }
        if (entity.getSala() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSala());
        }
        if (entity.getPonente() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPonente());
        }
        if (entity.getResumen() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getResumen());
        }
        final int _tmp = entity.getFavorita() ? 1 : 0;
        statement.bindLong(9, _tmp);
      }
    };
    this.__preparedStmtOfAlternar = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE charlas SET favorita = NOT favorita WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfBorrarTodas = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM charlas";
        return _query;
      }
    };
  }

  @Override
  public Object guardar(final List<Charla> fichas, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCharla.insert(fichas);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object reemplazarPrograma(final List<Charla> nuevas,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> CarteleraDao_Impl.super.reemplazarPrograma(nuevas, __cont), $completion);
  }

  @Override
  public Object alternar(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfAlternar.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfAlternar.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object borrarTodas(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfBorrarTodas.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfBorrarTodas.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Charla>> observar() {
    final String _sql = "SELECT * FROM charlas ORDER BY dia, hora, sala";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"charlas"}, new Callable<List<Charla>>() {
      @Override
      @NonNull
      public List<Charla> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
          final int _cursorIndexOfTema = CursorUtil.getColumnIndexOrThrow(_cursor, "tema");
          final int _cursorIndexOfDia = CursorUtil.getColumnIndexOrThrow(_cursor, "dia");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfSala = CursorUtil.getColumnIndexOrThrow(_cursor, "sala");
          final int _cursorIndexOfPonente = CursorUtil.getColumnIndexOrThrow(_cursor, "ponente");
          final int _cursorIndexOfResumen = CursorUtil.getColumnIndexOrThrow(_cursor, "resumen");
          final int _cursorIndexOfFavorita = CursorUtil.getColumnIndexOrThrow(_cursor, "favorita");
          final List<Charla> _result = new ArrayList<Charla>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Charla _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitulo;
            if (_cursor.isNull(_cursorIndexOfTitulo)) {
              _tmpTitulo = null;
            } else {
              _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
            }
            final String _tmpTema;
            if (_cursor.isNull(_cursorIndexOfTema)) {
              _tmpTema = null;
            } else {
              _tmpTema = _cursor.getString(_cursorIndexOfTema);
            }
            final int _tmpDia;
            _tmpDia = _cursor.getInt(_cursorIndexOfDia);
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final String _tmpSala;
            if (_cursor.isNull(_cursorIndexOfSala)) {
              _tmpSala = null;
            } else {
              _tmpSala = _cursor.getString(_cursorIndexOfSala);
            }
            final String _tmpPonente;
            if (_cursor.isNull(_cursorIndexOfPonente)) {
              _tmpPonente = null;
            } else {
              _tmpPonente = _cursor.getString(_cursorIndexOfPonente);
            }
            final String _tmpResumen;
            if (_cursor.isNull(_cursorIndexOfResumen)) {
              _tmpResumen = null;
            } else {
              _tmpResumen = _cursor.getString(_cursorIndexOfResumen);
            }
            final boolean _tmpFavorita;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorita);
            _tmpFavorita = _tmp != 0;
            _item = new Charla(_tmpId,_tmpTitulo,_tmpTema,_tmpDia,_tmpHora,_tmpSala,_tmpPonente,_tmpResumen,_tmpFavorita);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object idsFavoritas(final Continuation<? super List<String>> $completion) {
    final String _sql = "SELECT id FROM charlas WHERE favorita = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<String>>() {
      @Override
      @NonNull
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object borrarRetiradas(final List<String> vigentes,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("DELETE FROM charlas WHERE id NOT IN (");
        final int _inputSize = vigentes.size();
        StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
        _stringBuilder.append(")");
        final String _sql = _stringBuilder.toString();
        final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
        int _argIndex = 1;
        for (String _item : vigentes) {
          if (_item == null) {
            _stmt.bindNull(_argIndex);
          } else {
            _stmt.bindString(_argIndex, _item);
          }
          _argIndex++;
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

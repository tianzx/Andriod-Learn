package net.tianzx.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tianzx on 2016/3/13.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tb1_songs (uuid varchar(20) , name varchar(20),savePath varchar(200)";
        db.execSQL(sql);

        sql = "insert into tb1_songs values('1111111','test.mp3','/mysongs')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table tb1_songs";
        db.execSQL(sql);

        sql = "create table tb1_songs (uuid varchar(20) , name varchar(20),savePath varchar(200)";
        db.execSQL(sql);
    }

    @Override
    public void onOpen(SQLiteDatabase  db) {
        super.onOpen(db);

    }
}

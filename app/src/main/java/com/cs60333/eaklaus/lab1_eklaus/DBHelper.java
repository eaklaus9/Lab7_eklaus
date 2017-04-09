package com.cs60333.eaklaus.lab1_eklaus;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eakla on 4/7/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "teams.db";
    public static int DATABASE_VERSION = 1;
    public static String TABLE_TEAMS = "Teams";
    public static String COL_TEAM_ID = "_id";
    public static String COL_LOGO = "logo";
    public static String COL_NAME = "team_name";
    public static String COL_MASCOT = "mascot";
    public static String COL_RECORD = "record";
    public static String TABLE_GAMES = "Games";
    public static String COL_GAME_ID = "_id";
    public static String COL_DATE = "date";
    public static String COL_DETAIL_DATE = "detail_date";
    public static String COL_LOCATION = "location";
    public static String COL_SCORE = "score";
    public static String COL_TIME_LEFT = "time_left";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_TEAMS + " ( " + COL_TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_LOGO + " TEXT, " + COL_NAME + " TEXT, " + COL_MASCOT + " Text, " + COL_RECORD + " Text )");
        db.execSQL("CREATE TABLE " + TABLE_GAMES + " ( " + COL_GAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_DATE + " TEXT, " + COL_DETAIL_DATE + " TEXT, " + COL_LOCATION + " TEXT, " +
                COL_SCORE + " TEXT, " + COL_TIME_LEFT + " Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists " + TABLE_TEAMS);
        db.execSQL("DROP TABLE if exists " + TABLE_GAMES);
        onCreate(db);
    }

    //Insert Data into the database tables
    public void insertData(String tblname, ContentValues contentValues) {
        SQLiteDatabase db = getWritableDatabase();
        long ret = db.insert(tblname, null, contentValues );
        if (ret > -1) {
            System.out.println("Successfully inserted");
        } else {
            System.out.println("Insert Unsuccessful");
        }
        db.close();
    }

    //Delete Data from the database tables
    public void deleteData(String tblname, String clause, int _id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(tblname, clause, new String[]{Integer.toString(_id)});
        db.close();
    }
}
package com.example.id_admchaset.kajisystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by id_admchaset on 2/6/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Kajian.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_KAJIAN = "CREATE TABLE " + Kajian.TABLE  + "("
                + Kajian.COL_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Kajian.COL_CODE + " INTEGER, "
                + Kajian.COL_CODEUST + "INTEGER, "
                + Kajian.COL_TITLE + " TEXT, "
                + Kajian.COL_ARTIST + " TEXT, "
                + Kajian.COL_DESCRIPTION + " TEXT, "
                + Kajian.COL_DURATION + " TEXT, "
                + Kajian.COL_SIZE+ " TEXT, "
                + Kajian.COL_ISDOWNLOAD + " INTEGER, "
                + Kajian.COL_ISFAVORITE + " INTEGER, "
                + Kajian.COL_ISNEW + " INTEGER,"
                + Kajian.COL_URL1+ " TEXT, "
                + Kajian.COL_URL2 + " TEXT, "
                + Kajian.COL_LOCALPATH1 + " TEXT, "
                + Kajian.COL_LOCALPATH2 + " TEXT )";


        db.execSQL(CREATE_TABLE_KAJIAN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Kajian.TABLE);
        // Create tables again
        onCreate(db);
    }
}

package com.example.id_admchaset.kajisystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by id_admchaset on 2/6/2017.
 */

public class KajianRepo {
    private DBHelper dbHelper;

    public KajianRepo(Context contex){
        dbHelper = new DBHelper(contex);
    }

    public int Insert(Kajian kajianModel){

        //OPEN Connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(kajianModel.COL_CODE, kajianModel.code);
        values.put(kajianModel.COL_CODEUST,kajianModel.codeUst);
        values.put(kajianModel.COL_TITLE, kajianModel.title);
        values.put(kajianModel.COL_ARTIST, kajianModel.artis);
        values.put(kajianModel.COL_DESCRIPTION, kajianModel.description);
        values.put(kajianModel.COL_DURATION, kajianModel.duration);
        values.put(kajianModel.COL_SIZE, kajianModel.size);
        values.put(kajianModel.COL_ISDOWNLOAD, kajianModel.isDownload);
        values.put(kajianModel.COL_ISFAVORITE, kajianModel.isFavorite);
        values.put(kajianModel.COL_ISNEW, kajianModel.isNew);
        values.put(kajianModel.COL_URL1, kajianModel.url1);
        values.put(kajianModel.COL_URL2, kajianModel.url2);
        values.put(kajianModel.COL_LOCALPATH1, kajianModel.localPath1);
        values.put(kajianModel.COL_LOCALPATH2, kajianModel.localPath2);

        // Inserting Row
        long Kajian_ID = db.insert(kajianModel.TABLE,null,values);
        db.close();

        return (int)Kajian_ID;
    }

    public void delete(int kajian_ID) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Kajian.TABLE, Kajian.COL_ID + "= ?", new String[] { String.valueOf(kajian_ID) });
        db.close(); // Closing database connection
    }

    public void update(Kajian kajianModel) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(kajianModel.COL_CODE, kajianModel.code);
        values.put(kajianModel.COL_CODEUST, kajianModel.codeUst);
        values.put(kajianModel.COL_TITLE,kajianModel.title);
        values.put(kajianModel.COL_ARTIST, kajianModel.artis);
        values.put(kajianModel.COL_DESCRIPTION, kajianModel.description);
        values.put(kajianModel.COL_DURATION, kajianModel.duration);
        values.put(kajianModel.COL_SIZE, kajianModel.size);
        values.put(kajianModel.COL_ISDOWNLOAD, kajianModel.isDownload);
        values.put(kajianModel.COL_ISFAVORITE, kajianModel.isFavorite);
        values.put(kajianModel.COL_ISNEW, kajianModel.isNew);
        values.put(kajianModel.COL_URL1,kajianModel.url1);
        values.put(kajianModel.COL_URL2, kajianModel.url2);
        values.put(kajianModel.COL_LOCALPATH1, kajianModel.localPath1);
        values.put(kajianModel.COL_LOCALPATH2, kajianModel.localPath2);
        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(kajianModel.TABLE, values, kajianModel.COL_ID  + "= ?", new String[] { String.valueOf(kajianModel.kajian_id) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getKajianList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Kajian.COL_ID + "," +
                Kajian.COL_CODE + "," +
                Kajian.COL_CODEUST + "," +
                Kajian.COL_TITLE + "," +
                Kajian.COL_ARTIST + "," +
                Kajian.COL_DESCRIPTION + "," +
                Kajian.COL_DURATION + "," +
                Kajian.COL_SIZE + "," +
                Kajian.COL_ISFAVORITE + "," +
                Kajian.COL_ISDOWNLOAD + "," +
                Kajian.COL_ISNEW + "," +
                Kajian.COL_URL1 + "," +
                Kajian.COL_URL2 + "," +
                Kajian.COL_LOCALPATH1 + "," +
                Kajian.COL_LOCALPATH2 +
                " FROM " + Kajian.TABLE;


        ArrayList<HashMap<String, String>> kajianList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> kajian = new HashMap<String, String>();
                kajian.put(Kajian.COL_ID, cursor.getString(cursor.getColumnIndex(Kajian.COL_ID)));
                kajian.put(Kajian.COL_CODE, cursor.getString(cursor.getColumnIndex(Kajian.COL_CODE)));
                kajian.put(Kajian.COL_CODEUST, cursor.getString(cursor.getColumnIndex(Kajian.COL_CODEUST)));
                kajian.put(Kajian.COL_TITLE, cursor.getString(cursor.getColumnIndex(Kajian.COL_TITLE)));
                kajian.put(Kajian.COL_ARTIST, cursor.getString(cursor.getColumnIndex(Kajian.COL_ARTIST)));
                kajian.put(Kajian.COL_DESCRIPTION, cursor.getString(cursor.getColumnIndex(Kajian.COL_DESCRIPTION)));
                kajian.put(Kajian.COL_DURATION, cursor.getString(cursor.getColumnIndex(Kajian.COL_DURATION)));
                kajian.put(Kajian.COL_SIZE, cursor.getString(cursor.getColumnIndex(Kajian.COL_SIZE)));
                kajian.put(Kajian.COL_ISDOWNLOAD, cursor.getString(cursor.getColumnIndex(Kajian.COL_ISDOWNLOAD)));
                kajian.put(Kajian.COL_ISFAVORITE, cursor.getString(cursor.getColumnIndex(Kajian.COL_ISFAVORITE)));
                kajian.put(Kajian.COL_ISNEW, cursor.getString(cursor.getColumnIndex(Kajian.COL_ISNEW)));
                kajian.put(Kajian.COL_URL1, cursor.getString(cursor.getColumnIndex(Kajian.COL_URL1)));
                kajian.put(Kajian.COL_URL2, cursor.getString(cursor.getColumnIndex(Kajian.COL_URL2)));
                kajian.put(Kajian.COL_LOCALPATH1, cursor.getString(cursor.getColumnIndex(Kajian.COL_LOCALPATH1)));
                kajian.put(Kajian.COL_LOCALPATH2, cursor.getString(cursor.getColumnIndex(Kajian.COL_LOCALPATH2)));
                kajianList.add(kajian);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return kajianList;

    }

    public ArrayList<HashMap<String, String>> getCustomKajianList(String[] Columns,String[] Values) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        StringBuilder ColumnParams = new StringBuilder();
        String currentSeparator = "";
        for(String parameter : Columns){
            ColumnParams.append(currentSeparator);
            ColumnParams.append(parameter+"=?");
            currentSeparator = ",";
        }

        ArrayList<HashMap<String, String>> kajianList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.query(Kajian.TABLE, Kajian.COLUMNS, ColumnParams.toString(), Values, null, null, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> kajian = new HashMap<String, String>();
                kajian.put(Kajian.COL_ID, cursor.getString(cursor.getColumnIndex(Kajian.COL_ID)));
                kajian.put(Kajian.COL_CODE, cursor.getString(cursor.getColumnIndex(Kajian.COL_CODE)));
                kajian.put(Kajian.COL_CODEUST, cursor.getString(cursor.getColumnIndex(Kajian.COL_CODEUST)));
                kajian.put(Kajian.COL_TITLE, cursor.getString(cursor.getColumnIndex(Kajian.COL_TITLE)));
                kajian.put(Kajian.COL_ARTIST, cursor.getString(cursor.getColumnIndex(Kajian.COL_ARTIST)));
                kajian.put(Kajian.COL_DESCRIPTION, cursor.getString(cursor.getColumnIndex(Kajian.COL_DESCRIPTION)));
                kajian.put(Kajian.COL_DURATION, cursor.getString(cursor.getColumnIndex(Kajian.COL_DURATION)));
                kajian.put(Kajian.COL_SIZE, cursor.getString(cursor.getColumnIndex(Kajian.COL_SIZE)));
                kajian.put(Kajian.COL_ISDOWNLOAD, cursor.getString(cursor.getColumnIndex(Kajian.COL_ISDOWNLOAD)));
                kajian.put(Kajian.COL_ISFAVORITE, cursor.getString(cursor.getColumnIndex(Kajian.COL_ISFAVORITE)));
                kajian.put(Kajian.COL_ISNEW, cursor.getString(cursor.getColumnIndex(Kajian.COL_ISNEW)));
                kajian.put(Kajian.COL_URL1, cursor.getString(cursor.getColumnIndex(Kajian.COL_URL1)));
                kajian.put(Kajian.COL_URL2, cursor.getString(cursor.getColumnIndex(Kajian.COL_URL2)));
                kajian.put(Kajian.COL_LOCALPATH1, cursor.getString(cursor.getColumnIndex(Kajian.COL_LOCALPATH1)));
                kajian.put(Kajian.COL_LOCALPATH2, cursor.getString(cursor.getColumnIndex(Kajian.COL_LOCALPATH2)));
                kajianList.add(kajian);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return kajianList;
    }
    public Kajian getStudentById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Kajian.COL_ID + "," +
                Kajian.COL_CODE + "," +
                Kajian.COL_CODEUST + "," +
                Kajian.COL_TITLE + "," +
                Kajian.COL_ARTIST + "," +
                Kajian.COL_DESCRIPTION + "," +
                Kajian.COL_DURATION + "," +
                Kajian.COL_SIZE + "," +
                Kajian.COL_ISDOWNLOAD + "," +
                Kajian.COL_ISFAVORITE + "," +
                Kajian.COL_ISNEW + "," +
                Kajian.COL_URL1 + "," +
                Kajian.COL_URL2 + "," +
                Kajian.COL_LOCALPATH1 + "," +
                Kajian.COL_LOCALPATH2 +
                " FROM " + Kajian.TABLE
                + " WHERE " +
                Kajian.COL_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Kajian kajian = new Kajian();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                kajian.kajian_id =cursor.getInt(cursor.getColumnIndex(Kajian.COL_ID));
                kajian.code =cursor.getInt(cursor.getColumnIndex(Kajian.COL_CODE));
                kajian.codeUst =cursor.getInt(cursor.getColumnIndex(Kajian.COL_CODEUST));
                kajian.title =cursor.getString(cursor.getColumnIndex(Kajian.COL_TITLE));
                kajian.artis =cursor.getString(cursor.getColumnIndex(Kajian.COL_ARTIST));
                kajian.description =cursor.getString(cursor.getColumnIndex(Kajian.COL_DESCRIPTION));
                kajian.duration =cursor.getString(cursor.getColumnIndex(Kajian.COL_DURATION));
                kajian.size =cursor.getString(cursor.getColumnIndex(Kajian.COL_SIZE));
                kajian.isFavorite =cursor.getInt(cursor.getColumnIndex(Kajian.COL_ISFAVORITE));
                kajian.isDownload =cursor.getInt(cursor.getColumnIndex(Kajian.COL_ISDOWNLOAD));
                kajian.isNew=cursor.getInt(cursor.getColumnIndex(Kajian.COL_ISNEW));
                kajian.url1 =cursor.getString(cursor.getColumnIndex(Kajian.COL_URL1));
                kajian.url2 =cursor.getString(cursor.getColumnIndex(Kajian.COL_URL2));
                kajian.localPath1 = cursor.getString(cursor.getColumnIndex(Kajian.COL_LOCALPATH1));
                kajian.localPath2 = cursor.getString(cursor.getColumnIndex(Kajian.COL_LOCALPATH2));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return kajian;
    }

}

package com.example.id_admchaset.kajisystem;
/**
 * Created by id_admchaset on 2/6/2017.
 */

public class Kajian {
    // Labels table name
    public static final String TABLE = "tbKajian";



    // Labels Table Columns names
    public static final String COL_ID = "id";
    public static final String COL_CODE = "code";
    public static final String COL_CODEUST = "codeUst";
    public static final String COL_TITLE = "title";
    public static final String COL_ARTIST = "artist";
    public static final String COL_DURATION = "duration";
    public static final String COL_SIZE = "size";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_ISFAVORITE = "isFavorite";
    public static final String COL_ISDOWNLOAD = "isDownload";
    public static final String COL_ISNEW = "isNew";
    public static final String COL_URL1 = "url1";
    public static final String COL_URL2 = "url2";
    public static final String COL_LOCALPATH1 = "localPath1";
    public static final String COL_LOCALPATH2 = "localPath2";

    public static final String[] COLUMNS = new String[]{COL_ID,COL_CODE,COL_CODEUST,COL_TITLE,COL_ARTIST,COL_DURATION,COL_SIZE,COL_DESCRIPTION,COL_ISFAVORITE,COL_ISDOWNLOAD,COL_ISNEW,COL_URL1,COL_URL2,COL_LOCALPATH1,COL_LOCALPATH2};

    // property help us to keep data
    public int kajian_id;
    public int code;
    public int codeUst;
    public String title;
    public String artis;
    public String duration;
    public String size;
    public String description;
    public int isFavorite;
    public int isDownload;
    public int isNew;
    public String url1;
    public String url2;
    public String localPath1;
    public String localPath2;

}

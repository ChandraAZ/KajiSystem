package com.example.id_admchaset.kajisystem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by id_admchaset on 2/9/2017.
 */

public class ParseJSON {
    public static String[] ids;
    public static String[] titles;
    public static String[] arties;
    public static String[] durations;
    public static String[] sizes;
    public static String[] descriptions;
    public static String[] urls1;
    public static String[] urls2;

    public static final String JSON_ARRAY = "result";

    private JSONArray kajians = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            kajians = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[kajians.length()];
            titles = new String[kajians.length()];
            arties = new String[kajians.length()];
            durations = new String[kajians.length()];
            sizes = new String[kajians.length()];
            descriptions= new String[kajians.length()];
            urls1= new String[kajians.length()];
            urls2= new String[kajians.length()];

            for(int i=0;i<kajians.length();i++){
                JSONObject jo = kajians.getJSONObject(i);
                ids[i] = jo.getString(Kajian.COL_ID);
                titles[i] = jo.getString(Kajian.COL_TITLE);
                arties[i] = jo.getString(Kajian.COL_ARTIST);
                durations[i] = jo.getString(Kajian.COL_DURATION);
                sizes[i] = jo.getString(Kajian.COL_SIZE);
                descriptions[i] = jo.getString(Kajian.COL_DESCRIPTION);
                urls1[i] = jo.getString(Kajian.COL_URL1);
                urls2[i] = jo.getString(Kajian.COL_URL2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
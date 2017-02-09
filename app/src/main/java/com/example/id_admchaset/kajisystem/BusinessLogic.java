package com.example.id_admchaset.kajisystem;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by id_admchaset on 2/9/2017.
 */

public class BusinessLogic {

    private static Context context;
    public BusinessLogic(Context _context){
        this.context = _context;
    }

    public boolean IsCheckingVersion(){
        boolean isSameVersion = false;

        return  isSameVersion;
    }

    public void SendRequest()
    {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

    }


/*
    public String ReadXML(KajianRepo repo, InputStream is) {
        String msgError = "";
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("item");

            for (int i = 0; i < nList.getLength(); i++) {
                Kajian kj = new Kajian();
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;
                    kj.title = getValue(Kajian.COL_TITLE, element2);
                    kj.description = getValue(Kajian.COL_DESCRIPTION, element2);
                    kj.duration = getValue(Kajian.COL_DURATION, element2);
                    kj.artis = getValue(Kajian.COL_ARTIST, element2);
                    kj.size = getValue(Kajian.COL_SIZE, element2);
                    kj.url1 = getValue(Kajian.COL_URL1, element2);
                    kj.url2 = getValue(Kajian.COL_URL2, element2);
                    kj.code = i;
                    kj.codeUst = 1;
                    kj.isNew = 1;
                    kj.isDownload = 0;
                    kj.isFavorite = 0;
                    kj.localPath1 = "";
                    kj.localPath2 = "";
                    // INSERT
                    try {
                        int kajianId = repo.Insert(kj);
                        if (kajianId != 0) {
                            msgError = "INSERT SUCCESS : " + i +" Row(s).";
                        }
                    } catch (Exception e) {
                           return  msgError = "ERR : " + e.getMessage();

                    }
                }
            }
        return  msgError;
        } catch (Exception e) {
            e.printStackTrace();
            return msgError = "ERR : " + e.getMessage();
        }
    }
    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    } */

}

package com.example.id_admchaset.kajisystem;

import android.content.res.AssetManager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener,Response.Listener, Response.ErrorListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    //This is our tablayout
    private TabLayout tabLayout;

    private int IsRequestFaild = 0;
    public static final String REQUEST_TAG = "MainVolleyActivity";
    private TextView mTextView;
    private RequestQueue mQueue;
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTextView = (TextView) findViewById(R.id.tvTestRespon);
        setSupportActionBar(toolbar);
        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Online"));
        tabLayout.addTab(tabLayout.newTab().setText("Offline"));
        tabLayout.addTab(tabLayout.newTab().setText("Favorite"));
        tabLayout.addTab(tabLayout.newTab().setText("Option"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        mViewPager = (ViewPager) findViewById(R.id.container);

        //Creating our pager adapter
        pager adapter = new pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        mViewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        //tabLayout.setOnTabSelectedListener(this);
        //tabLayout.addOnTabSelectedListener(this);
        //tabLayout.removeOnTabSelectedListener(this);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Load DB SQLite
        //int kajianID = 0;

       // KajianRepo repo = new KajianRepo(this);
       // BusinessLogic bis = new BusinessLogic(this);
       // bis.SendRequest();
        // Checking XML VERSION

        // READ & INSERT
       /* try {
            InputStream is = getAssets().open("Syafiq-v01.xml");
            String msgResult = bis.ReadXML(repo,is);
            Toast.makeText(this, msgResult, Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(this, "ERR Read or Insert data : " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        // SELECT
        ArrayList<HashMap<String, String>> kajianList = new ArrayList<HashMap<String, String>>();
        try {
            kajianList = repo.getKajianList();
        }catch (Exception e){
            Toast.makeText(this,"ERR : " + e.getMessage(),Toast.LENGTH_SHORT).show();
        }
       if(kajianList.size()!=0) {
            Toast.makeText(this,"COUNT : " + kajianList.size(),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No Kajian!",Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Instantiate the RequestQueue.
       mQueue = CustomVolleyRequestQueue.getInstance(this.getApplicationContext())
                .getRequestQueue();
        String url = Kajian.URL;
        try {
            final CustomJSONObjectRequest jsonRequest = new CustomJSONObjectRequest(Request.Method.GET, url, new JSONObject(), this, this);
            jsonRequest.setTag(REQUEST_TAG);
            mQueue.add(jsonRequest);
        }catch (Exception ex){
            Toast.makeText(this,"ERR : " + ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mQueue != null) {
            mQueue.cancelAll(REQUEST_TAG);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        mTextView.setText(error.getMessage());
    }

    @Override
    public void onResponse(Object response) {
        //mTextView.setText("Response is: " + response);
        String testStr= "";
        try {
            testStr = ((JSONObject) response).getString("syafiq");
            //mTextView.setText(((JSONObject) response).getString("syafiq"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}

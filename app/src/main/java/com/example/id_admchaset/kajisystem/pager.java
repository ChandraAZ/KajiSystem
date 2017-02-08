package com.example.id_admchaset.kajisystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by id_admchaset on 2/6/2017.
 */

public class pager extends FragmentStatePagerAdapter {
    int tabCount;
    //Constructor to the class
    public pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                tabonline tbonline = new tabonline();
                return tbonline;
            case 1:
                taboffline tboffline = new taboffline();
                return tboffline;
            case 2:
                tabfavorite tbfavorite = new tabfavorite();
                return tbfavorite;
            case 3:
                taboption tboption = new taboption();
                return tboption;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

}

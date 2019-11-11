package com.example.groupprojectfinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                IntroActivity introActivity = new IntroActivity();
                return introActivity;
            case 1:
                DrinksActivity drinksActivity = new DrinksActivity();
                return drinksActivity;
            case 2:
                KidsActivity kidsActivity = new KidsActivity();
                return kidsActivity;
            case 3:
                AdultsActivity adultsActivity = new AdultsActivity();
                return adultsActivity;
            case 4:
                DrinksActivity dessertActivity = new DrinksActivity();
                return dessertActivity;
            case 5:
                BillActivity billActivity = new BillActivity();
                return billActivity;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}

package miwok.android.example.com.tourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * Created by Paul on 23-Jun-17.
 */

public class CategoriesAdapter extends FragmentPagerAdapter {


    private Context mcontext;
    String title[];


    public CategoriesAdapter (FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mcontext = context;
       title  = new String[] {mcontext.getResources().getString(R.string.Eating), mcontext.getResources().getString(R.string.Social), mcontext.getResources().getString(R.string.Shopping), mcontext.getResources().getString(R.string.HistoricalBuildings) };
    }

    @Override
    public Fragment getItem (int aling) {
        if (aling == 0) {
            return new EatingFragment();
        } else if (aling == 1) {
            return new SocialFragment();
        } else if (aling == 2) {
            return new ShoppingFragment();
        } else {
            return new HistoricalBuildings();
        }
    }
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return title[position];
    }
}

package miwok.android.example.com.tourapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * Created by Paul on 23-Jun-17.
 */

public class CategoriesAdapter extends FragmentPagerAdapter {

    private String title[] = new String[] {"Eating", "Social", "Shopping", "Historical Buildings" };

    public CategoriesAdapter (FragmentManager fragmentManager) {
        super(fragmentManager);
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

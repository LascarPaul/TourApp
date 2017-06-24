package miwok.android.example.com.tourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
/**
 * Created by Paul on 23-Jun-17.
 */

public class SocialFragment extends Fragment {
    public SocialFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        final ArrayList<Location> Location = new ArrayList<Location>();
        Location.add(new Location(getString(R.string.HerastrauPark), getString(R.string.Adress7), getString(R.string.url8),  R.drawable.herastrau1, getString(R.string.Free)));
        Location.add(new Location(getString(R.string.ExtendedWalkingTourofBucharest), getString(R.string.description2), getString(R.string.url9),  R.drawable.tour, getString(R.string.price2)));
        Location.add(new Location(getString(R.string.WineTasting), getString(R.string.description6), getString(R.string.url10),  R.drawable.wine, getString(R.string.price2)));


        final LocationAdapter adapter = new LocationAdapter(getActivity(), Location, R.color.social);

        final ListView PoiListView = (ListView) rootView.findViewById(R.id.list);

        PoiListView.setAdapter(adapter);

        PoiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Location locationPlace = adapter.getItem(position);
                Uri PoiUrl = Uri.parse(locationPlace.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, PoiUrl);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }
}

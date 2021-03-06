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

public class ShoppingFragment extends Fragment {
    public ShoppingFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        final ArrayList<Location> Location = new ArrayList<Location>();
        Location.add(new Location(getString(R.string.AFIPalaceCotroceni), getString(R.string.Adress4), getString(R.string.url6),  R.drawable.afi, getString(R.string.price1)));
        Location.add(new Location(getString(R.string.CarturestiCarusel), getString(R.string.Adress5), getString(R.string.url7),  R.drawable.carturesti, getString(R.string.price1)));


        final LocationAdapter adapter = new LocationAdapter(getActivity(), Location, R.color.historical);


        final ListView poiListView = (ListView) rootView.findViewById(R.id.list);

        poiListView.setAdapter(adapter);
        poiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Location currentLocation = adapter.getItem(position);
                Uri PoiUrl = Uri.parse(currentLocation.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, PoiUrl);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }

}

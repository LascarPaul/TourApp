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

public class EatingFragment extends Fragment {
    public EatingFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        final ArrayList<POI> POI = new ArrayList<POI>();
        POI.add(new POI("the ARTIST", "Calea Victoriei 147, Sector 1", "https://www.tripadvisor.com/Restaurant_Review-g294458-d3469196-Reviews-The_ARTIST-Bucharest.html",  R.drawable.osho1, "$$$$"));
        POI.add(new POI("Vacamuuu", " Calea Floreasca No. 111", "https://www.tripadvisor.com/Restaurant_Review-g294458-d3637747-Reviews-Vacamuuu-Bucharest.html",  R.drawable.a2, "$$$$"));
        POI.add(new POI("OSHO", "Boulevardul Primaveri 19-21", "https://www.tripadvisor.com/Restaurant_Review-g294458-d2074211-Reviews-OSHO-Bucharest.html",  R.drawable.a3, "$$$"));



        final POIAdapter adapter = new POIAdapter(getActivity(), POI, R.color.eating);


        final ListView poiListView = (ListView) rootView.findViewById(R.id.list);

        poiListView.setAdapter(adapter);
        poiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                POI currentPOI = adapter.getItem(position);
                Uri PoiUrl = Uri.parse(currentPOI.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, PoiUrl);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }
}

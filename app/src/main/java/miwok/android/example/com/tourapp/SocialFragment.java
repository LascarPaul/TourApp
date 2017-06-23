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


        final ArrayList<POI> POI = new ArrayList<POI>();
        POI.add(new POI("Herastrau Park", "B-dul Aviatorilor", "https://www.tripadvisor.com/Attraction_Review-g294458-d548240-Reviews-Herastrau_Park-Bucharest.html",  R.drawable.herastrau1, "Free"));
        POI.add(new POI("Extended Walking Tour of Bucharest", "6-hour walking tour", "https://www.tripadvisor.com/AttractionProductDetail?product=11058P1&d=294458&aidSuffix=xsell&partner=Viator",  R.drawable.tour, "$"));
        POI.add(new POI("Wine Tasting", "Romantic experience", "https://www.tripadvisor.com/AttractionProductDetail?product=27172P2&d=294458&aidSuffix=xsell&partner=Viator",  R.drawable.wine, "$"));


        final POIAdapter adapter = new POIAdapter(getActivity(), POI, R.color.social);

        final ListView PoiListView = (ListView) rootView.findViewById(R.id.list);

        PoiListView.setAdapter(adapter);

        PoiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                POI PoiPlace = adapter.getItem(position);
                Uri PoiUrl = Uri.parse(PoiPlace.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, PoiUrl);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }
}

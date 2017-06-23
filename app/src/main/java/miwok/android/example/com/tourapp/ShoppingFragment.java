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


        final ArrayList<POI> POI = new ArrayList<POI>();
        POI.add(new POI("AFI Palace Cotroceni", "Bd vasile Milea No 4", "https://www.tripadvisor.com/Attraction_Review-g294458-d3340332-Reviews-AFI_Palace_Cotroceni-Bucharest.html",  R.drawable.afi, ""));
        POI.add(new POI("Carturesti Carusel", "Strada Lipscani 55", "https://www.tripadvisor.com/Attraction_Review-g294458-d4757849-Reviews-Carturesti_Carusel-Bucharest.html",  R.drawable.carturesti, "$"));


        final POIAdapter adapter = new POIAdapter(getActivity(), POI, R.color.historical);


        final ListView poiListView = (ListView) rootView.findViewById(R.id.list);

        poiListView.setAdapter(adapter);
        poiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                POI currentPoi = adapter.getItem(position);
                Uri PoiUrl = Uri.parse(currentPoi.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, PoiUrl);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }

}

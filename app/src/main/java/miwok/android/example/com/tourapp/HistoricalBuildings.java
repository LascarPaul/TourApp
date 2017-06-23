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

public class HistoricalBuildings extends Fragment {
    public HistoricalBuildings() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        final ArrayList<POI> POI = new ArrayList<POI>();
        POI.add(new POI("Communism Tour", "3-hour Communist history walking tour", "https://www.tripadvisor.com/AttractionProductDetail?product=10914P1&d=294458&aidSuffix=xsell&partner=Viator", R.drawable.palace, "$"));

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

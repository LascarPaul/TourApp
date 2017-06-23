package miwok.android.example.com.tourapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
/**
 * Created by Paul on 23-Jun-17.
 */

public class POIAdapter extends ArrayAdapter<POI> {

    private int mcolorId;

    public POIAdapter(Context context, ArrayList<POI> pPOI, int colorId) {
        super(context, 0, pPOI);
        mcolorId = colorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.display, parent, false);
        }


        POI currentPoi = getItem(position);


        TextView name = (TextView) listView.findViewById(R.id.name);
        name.setText(currentPoi.getName());

        TextView description = (TextView) listView.findViewById(R.id.description);
        description.setText(currentPoi.getDescription());


        View container = listView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mcolorId);
        container.setBackgroundColor(color);

        TextView price = (TextView) listView.findViewById(R.id.price);
        price.setText(currentPoi.getPrice());


        ImageView imageView = (ImageView) listView.findViewById(R.id.image);

        if (currentPoi.hasImage()) {

            imageView.setImageResource(currentPoi.getmImageResourceId());

            imageView.setVisibility(View.VISIBLE);
        } else {

            imageView.setVisibility(View.GONE);
        }
        return listView;
    }
}
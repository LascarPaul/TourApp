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

public class LocationAdapter extends ArrayAdapter<Location> {

    private int mcolorId;

    public LocationAdapter(Context context, ArrayList<Location> pLocation, int colorId) {
        super(context, 0, pLocation);
        mcolorId = colorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.display, parent, false);
        }


        Location currentLocation = getItem(position);


        TextView name = (TextView) listView.findViewById(R.id.name);
        name.setText(currentLocation.getName());

        TextView description = (TextView) listView.findViewById(R.id.description);
        description.setText(currentLocation.getDescription());


        View container = listView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mcolorId);
        container.setBackgroundColor(color);

        TextView price = (TextView) listView.findViewById(R.id.price);
        price.setText(currentLocation.getPrice());


        ImageView imageView = (ImageView) listView.findViewById(R.id.image);

        if (currentLocation.hasImage()) {

            imageView.setImageResource(currentLocation.getmImageResourceId());

            imageView.setVisibility(View.VISIBLE);
        } else {

            imageView.setVisibility(View.GONE);
        }
        return listView;
    }
}
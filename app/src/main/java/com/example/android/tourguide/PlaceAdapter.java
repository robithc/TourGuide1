package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter (Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.place_item, parent, false);
        }

        //Create Place currentPlace  to get current item in list of places
        final Place currentPlace = getItem(position);

        //Create imageButton for place image
        ImageButton placeImageButton = listItemView.findViewById(R.id.place_image);
        //Set it to resource from list of places
        placeImageButton.setImageResource(currentPlace.getPlaceImage());

        //Create textView for name of the place
        TextView placeName = listItemView.findViewById(R.id.place_name_text);
        //Set it to resource from list of places
        placeName.setText(currentPlace.getPlaceName());

        //Create textView for location of the place
        TextView placeLocation = listItemView.findViewById(R.id.place_location_text);
        //Set it to resource from list of places
        placeLocation.setText(currentPlace.getPlaceLocation());

        return listItemView;
}
}



package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceDetailsAdapter extends ArrayAdapter<Place> {

    public PlaceDetailsAdapter (Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.place_details, parent, false);
        }

        final Place currentPlace = getItem(position);

        ImageButton placeImageButton = listItemView.findViewById(R.id.place_details_image);
        placeImageButton.setImageResource(currentPlace.getPlaceImage());

        TextView placeName = listItemView.findViewById(R.id.place_details_name_text);
        placeName.setText(currentPlace.getPlaceName());

        TextView placeLocation = listItemView.findViewById(R.id.place_details_location_text);
        placeLocation.setText(currentPlace.getPlaceLocation());

        TextView placeDescription = listItemView.findViewById(R.id.place_details_description_text);
        placeDescription.setText(currentPlace.getPlaceDescription());



        ImageButton goToMapButton = listItemView.findViewById(R.id.details_go_to_map_button);
        goToMapButton.setImageResource(R.drawable.ic_place_black_24dp);



        return listItemView;
    }
}



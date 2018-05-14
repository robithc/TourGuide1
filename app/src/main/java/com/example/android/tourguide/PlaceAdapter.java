package com.example.android.tourguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

        final Place currentPlace = getItem(position);



        ImageButton placeImageButton = listItemView.findViewById(R.id.place_image);
        placeImageButton.setImageResource(currentPlace.getPlaceImage());

        TextView placeName = listItemView.findViewById(R.id.place_name_text);
        placeName.setText(currentPlace.getPlaceName());

        TextView placeLocation = listItemView.findViewById(R.id.place_location_text);
        placeLocation.setText(currentPlace.getPlaceLocation());

        //TextView placeDescription = listItemView.findViewById(R.id.place_description_text);
        //placeDescription.setText(currentPlace.getPlaceDescription());



       //ImageButton goToMapButton = listItemView.findViewById(R.id.go_to_map_button);
       //goToMapButton.setImageResource(R.drawable.ic_place_black_24dp);



        return listItemView;
}




}



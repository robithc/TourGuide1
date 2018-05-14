package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DrinkFragment extends android.support.v4.app.Fragment {


    public DrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);


        //Create list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.fratelli_name, R.string.fratelli_location, R.string.fratelli_description, R.string.fratelli_geo_data, R.drawable.fratelli));
        places.add(new Place(R.string.hype_name, R.string.hype_location, R.string.hype_description, R.string.hype_geo_data, R.drawable.hype));
        places.add(new Place(R.string.pub80_name, R.string.pub80_location, R.string.pub80_description, R.string.pub80_geo_data, R.drawable.pub80s));
        places.add(new Place(R.string.no_name_club_name, R.string.no_name_club_location, R.string.no_name_club_description, R.string.no_name_club_geo_data, R.drawable.no_name));
        places.add(new Place(R.string.cuib_name, R.string.cuib_location, R.string.cuib_description, R.string.cuib_geo_data, R.drawable.cuib));
        places.add(new Place(R.string.darc_pemal_name, R.string.darc_pemal_location, R.string.darc_pemal_description, R.string.darc_pemal_geo_data, R.drawable.darc));
        places.add(new Place(R.string.epic_society_name, R.string.epic_society_location, R.string.epic_society_description, R.string.epic_society_geo_data, R.drawable.epic));
        places.add(new Place(R.string.drunken_rat_name, R.string.drunken_rat_location, R.string.drunken_rat_description, R.string.drunken_rat_geo_data, R.drawable.drunken_rat));

        //Create placeAdapter
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places);
        //Create listView
        ListView listView = rootView.findViewById(R.id.list);
        //Set placeAdapter on listView
        listView.setAdapter(placeAdapter);
        //Set onItemClickListener on listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //get index position of item in list of places
                Place currentPlace = places.get(position);
                //create intent to send values from list of places to DetailsActivity
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("placeName", getText(currentPlace.getPlaceName()).toString());
                intent.putExtra("placeLocation", getText(currentPlace.getPlaceLocation()).toString());
                intent.putExtra("placeDescription", getText(currentPlace.getPlaceDescription()).toString());
                intent.putExtra("placeGeoData", getText(currentPlace.getPlaceGeoData()).toString());
                intent.putExtra("placeImage", currentPlace.getPlaceImage());

                startActivity(intent);
            }
        });
        return rootView;
    }
}
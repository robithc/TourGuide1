package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class VisitFragment extends android.support.v4.app.Fragment {


    public VisitFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        //Create list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.libert_square_name, R.string.libert_square_location, R.string.libert_square_description, R.string.libert_square_geo_data,R.drawable.liberty_square  ));
        places.add(new Place(R.string.piata_unirii_name, R.string.piata_unirii_location, R.string.piata_unirii_description, R.string.piata_unirii_geo_data,R.drawable.uniri));
        places.add(new Place(R.string.piata_victoriei_name, R.string.piata_victoriei_location, R.string.piata_victoriei_description, R.string.piata_victoriei_data,R.drawable.piata_victory  ));
        places.add(new Place(R.string.roses_park_name, R.string.roses_park_location, R.string.roses_park_description, R.string.roses_park_geo_data,R.drawable.roses_park  ));
        places.add(new Place(R.string.complex_name, R.string.complex_location, R.string.complex_description, R.string.complex_geo_data,R.drawable.complex  ));
        places.add(new Place(R.string.sunbeach_name, R.string.sunbeach_location, R.string.sunbeach_description, R.string.sunbeach_geo_data,R.drawable.sunbeach  ));
        places.add(new Place(R.string.iulius_name, R.string.iulius_location, R.string.iulius_description, R.string.iulius_geo_data,R.drawable.iulius_mall  ));
        places.add(new Place(R.string.copilor_park_name, R.string.copilor_park_location, R.string.copilor_park_description, R.string.copilor_park_geo_data,R.drawable.copilior ));

        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Place currentPlace = places.get(position);
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
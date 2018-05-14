package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        //Create list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.zone_cafe  ));
        places.add(new Place(R.string.pizza_napoleon_name, R.string.pizza_napoleon_location, R.string.pizza_napoleon_description, R.string.pizza_napoleon_geo_data,R.drawable.napoleon  ));
        places.add(new Place(R.string.oxford_name, R.string.oxford_location, R.string.oxford_description, R.string.oxford_geo_data,R.drawable.oxford  ));
        places.add(new Place(R.string.helios_name, R.string.helios_location, R.string.helios_description, R.string.helios_geo_data,R.drawable.helios  ));
        places.add(new Place(R.string.neata_omelette_bistro_name, R.string.neata_omelette_bistro_location, R.string.neata_omelette_bistro_description, R.string.neata_omelette_bistro_geo_data,R.drawable.neata  ));
        places.add(new Place(R.string.biofresh_name, R.string.biofresh_location, R.string.biofresh_description, R.string.biofresh_geo_data,R.drawable.biofresh  ));
        places.add(new Place(R.string.radha_cuisine_name, R.string.radha_cusine_location, R.string.radha_cousine_description, R.string.radha_cusine_geo_data,R.drawable.radha  ));
        places.add(new Place(R.string.oro_toro_name, R.string.oro_toro_location, R.string.oro_toro_description, R.string.oro_toro_geo_data,R.drawable.oro_toro  ));

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
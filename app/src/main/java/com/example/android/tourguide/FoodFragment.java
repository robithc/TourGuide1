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
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.ic_place_black_24dp  ));
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.ic_place_black_24dp  ));
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.ic_place_black_24dp  ));
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.ic_place_black_24dp  ));
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.ic_place_black_24dp  ));
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.ic_place_black_24dp  ));
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.ic_place_black_24dp  ));
        places.add(new Place(R.string.zone_cafe_name, R.string.zone_cafe_location, R.string.zone_cafe_description, R.string.zone_cafe_geo_data,R.drawable.ic_place_black_24dp  ));

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

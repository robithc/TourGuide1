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

/**
 * A simple {@link Fragment} subclass.
 */
public class StayFragment extends Fragment {


    public StayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        //Create list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.hotel_continental_name, R.string.hotel_continental_location, R.string.hotel_continental_description, R.string.hotel_continental_geo_data,R.drawable.continental  ));
        places.add(new Place(R.string.hostel_costel_name, R.string.hostel_costel_location, R.string.hostel_costel_description, R.string.hostel_costel_geo_data,R.drawable.costel));
        places.add(new Place(R.string.lido_hotel_name, R.string.lido_hotel_location, R.string.lido_hotel_description, R.string.lido_hotel_geo_data,R.drawable.hotellido ));
        places.add(new Place(R.string.hotel_boavista_name, R.string.hotel_boavista_location, R.string.hotel_continental_description, R.string.hotel_boavista_geo_data,R.drawable.boavista  ));
        places.add(new Place(R.string.hotel_timisoara_name, R.string.hotel_timisoara_location, R.string.hotel_timisoara_description, R.string.hotel_timisoara_geo_data,R.drawable.timisoara  ));
        places.add(new Place(R.string.hotel_exclusiv_name, R.string.hotel_exclusiv_location, R.string.hotel_exclusiv_description, R.string.hotel_exclusiv_geo_data,R.drawable.exclusiv  ));



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

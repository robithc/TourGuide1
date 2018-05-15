package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.place_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView detailsPlaceName = findViewById(R.id.place_details_name_text);
        TextView detailsPlaceDescription = findViewById(R.id.place_details_description_text);
        TextView detailsPlaceLocation = findViewById(R.id.place_details_location_text);
        ImageButton detailsPlaceImageButton = findViewById(R.id.place_details_image);
        ImageButton mapButton = findViewById(R.id.details_go_to_map_button);




        Intent intent = getIntent();


        Integer placeImage = intent.getIntExtra("placeImage", 0);
        String placeName = intent.getStringExtra("placeName");
        String placeLocation = intent.getStringExtra("placeLocation");
        String placeDescription = intent.getStringExtra("placeDescription");
        final String geoData = intent.getStringExtra("placeGeoData");
        final Uri uriGeoData = Uri.parse(geoData);

        final String example = "https://goo.gl/maps/R6JsghTPFez";



        detailsPlaceName.setText(placeName);
        detailsPlaceDescription.setText(placeDescription);
        detailsPlaceLocation.setText(placeLocation);
        detailsPlaceImageButton.setImageResource(placeImage);
        mapButton.setImageResource(R.drawable.ic_place_black_24dp);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(getApplication(),geoData, Toast.LENGTH_SHORT).show();


                Intent mapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(geoData));


                    startActivity(mapIntent);





            }
        });

    }


}

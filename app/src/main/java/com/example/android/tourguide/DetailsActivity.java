package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the place_details.xml layout file
        setContentView(R.layout.place_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Create textView for name of place
        TextView detailsPlaceName = findViewById(R.id.place_details_name_text);
        //Create textView for place description
        TextView detailsPlaceDescription = findViewById(R.id.place_details_description_text);
        //Create textView for place location
        TextView detailsPlaceLocation = findViewById(R.id.place_details_location_text);
        //Create imageButton for image of place
        ImageButton detailsPlaceImageButton = findViewById(R.id.place_details_image);
        //Create imageButton for opening the Google Maps
        ImageButton mapButton = findViewById(R.id.details_go_to_map_button);

        //Create intent to receive variables from fragments
        Intent intent = getIntent();
        //Receive variables with getExtra
        Integer placeImage = intent.getIntExtra("placeImage", 0);
        String placeName = intent.getStringExtra("placeName");
        String placeLocation = intent.getStringExtra("placeLocation");
        String placeDescription = intent.getStringExtra("placeDescription");
        final String geoData = intent.getStringExtra("placeGeoData");

        //Set received variables to textViews and buttonViews created before
        detailsPlaceName.setText(placeName);
        detailsPlaceDescription.setText(placeDescription);
        detailsPlaceLocation.setText(placeLocation);
        detailsPlaceImageButton.setImageResource(placeImage);
        mapButton.setImageResource(R.drawable.ic_place_black_24dp);
        //Set onClickListener on button for Google Maps
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent to open Google Maps with recived Uri from fragment
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoData));
                startActivity(mapIntent);
            }
        });
    }
}

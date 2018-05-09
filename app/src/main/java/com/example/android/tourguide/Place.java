package com.example.android.tourguide;

import android.net.Uri;

/**
 * {@link Place} represents a place in city that user can visit.
 * It contains resource IDs for the name of the place,
 * image of the place, description, location, geo data for google maps for that place.
 */

public class Place {


    //String resourde ID for the name of the place.
    private int mPlaceName;

    //String resource ID for the location of the place.
    private int mPlaceLocation;

    //String resource ID for the description of the place.
    private int mPlaceDescription;

    //Uri resource for the geo data of the place.
    private  int mPlaceGeoData;

    //Image resource for the image of the place.
    private int mPlaceImage;

    /** Constant value that represents no description was provided for this place */
    private static final int NO_DESCRIPTION_PROVIDED = -1;

    /**
     * Create a new Place object.
     *
     * @param placeName is the string resource ID for the name of the place
     * @param placeLocation is the string resource ID for location of the place
     * @param placeDescription is the resource ID for description of the place
     * @param placeGeoData is the resource ID for Uri geo data
     * @param placeImage is the resource ID for image of the place
     *       */
    public Place(int placeName, int placeLocation, int placeDescription, int placeGeoData, int placeImage) {
        mPlaceName = placeName;
        mPlaceLocation = placeLocation;
        mPlaceDescription = placeDescription;
        mPlaceGeoData = placeGeoData;
        mPlaceImage = placeImage;
    }

    // Return string resource id for the name of place
    public int getPlaceName(){
        return mPlaceName;
    }

    //Return string resource id for the location of the place
    public int getPlaceLocation(){
        return mPlaceLocation;
    }
    //Return string resource id for the description of the place
    public int getPlaceDescription () {
        return mPlaceDescription;
    }
    //Return uri resource id for the geo data for the place
    public int getPlaceGeoData (){
        return mPlaceGeoData;
    }

    //Return image resource id for the image od the place
    public int getPlaceImage (){
        return mPlaceImage;
    }


    // Returns whether or not there is an description for this word.

    public boolean hasDescription() {
        return mPlaceDescription != NO_DESCRIPTION_PROVIDED;
    }
}

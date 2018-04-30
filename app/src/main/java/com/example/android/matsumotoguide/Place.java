package com.example.android.matsumotoguide;
import android.net.Uri;


/**
 * this class hold the place information such
 * name, coordinates, business hours, image, description
 */
public class Place {
    //place name
    private String mName;
    //place description
    private String mDescription;
    //business hours if it museum or something have them
    private String mBusinessHours;
    //image of place (link to drawable ID)
    private int mImage;

    private String mLocation;
    //maps coordinates of this place
    private Uri mUriLocation;

    //do we have business hours?
    private boolean isBusinessHours = true;
    private final static int SHORT_DESCRIPTION_LENGTH = 80;


    /**
     * first constructor for Place class
     * @param name name of place
     * @param description description of place
     * @param businessHours business hours
     * @param imageId link to drawable image id
     * @param location location of place on the map
     */
    public Place(String name, String description, String businessHours, int imageId, String location) {
        mName = name;
        mDescription = description;
        mBusinessHours = businessHours;
        mImage = imageId;
        mLocation = location;
        // we have business hours in that place
        isBusinessHours = true;
    }

    /**
     * second constructor for Place class
     * @param name name of place
     * @param description description of place
     * @param imageId link to drawable image id
     * @param location location of place on the map
     */
    public Place(String name, String description, int imageId, String location) {
        mName = name;
        mDescription = description;
        mImage = imageId;
        mLocation = location;
        // we don't have business hours in that place
        isBusinessHours = false;
    }


    /**
     * @return name of place
     */
    public String getName(){
        return mName;
    }

    /**
     * @return place's description
     */
    public String getDescription() {
        return mDescription;
    }

    public String getShortDescription() {
        String shortDescription;
        if (mDescription.length() > SHORT_DESCRIPTION_LENGTH) {
            shortDescription = mDescription.substring(0, SHORT_DESCRIPTION_LENGTH) + "...";
        } else {
            shortDescription = mDescription;
        }
        return shortDescription;
    }

    /**
     * @return Business hours if they are, or blank line
     */
    public String getBusinessHours() {
        if (isBusinessHours) {
            return mBusinessHours;
        }
        return "";
    }


    /**
     * @return place's image resource id
     */
    public int getImage() {
        return mImage;
    }

    /**
     * @return place's location on the map as String
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * @return place's location on the map as Uri
     */
    public Uri getUriLocation() {
        return Uri.parse(mLocation);
    }

    /**
     * Do that place have a business hours?
     * @return true if they are or false if they not
     */

    public boolean hasBussinessHours() {
        return isBusinessHours;
    }

}

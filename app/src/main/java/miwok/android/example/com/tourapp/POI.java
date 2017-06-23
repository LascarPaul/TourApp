package miwok.android.example.com.tourapp;

/**
 * Created by Paul on 23-Jun-17.
 */

public class POI {
    private String mName;


    private String mDescription;


    private String mUrl;


    private String mPrice;


    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    public POI(String name, String description, String url, int imageResourceId, String price) {
        mName = name;
        mDescription = description;
        mUrl = url;
        mImageResourceId = imageResourceId;
        mPrice = price;
    }

    public String getName() { return mName; }
    public String getDescription() {return mDescription; }
    public String getUrl() {return mUrl; }
    public int getmImageResourceId() { return mImageResourceId; }
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    public String getPrice() {return mPrice; }

}

package Models;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Ben on 01/12/2016.
 */

public class LocationModel {
    private String road ;
    private String city ;
    private LatLng latLong;

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public LatLng getLatLong() {
        return latLong;
    }

    public void setLatLong(LatLng latLong) {
        this.latLong = latLong;
    }


}

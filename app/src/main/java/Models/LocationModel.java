package Models;


import com.google.android.gms.maps.model.LatLng;

import io.realm.RealmObject;

/**
 * Created by Ben on 01/12/2016.
 */

public class LocationModel  extends RealmObject {
    private String road ;
    private String city ;
    private RealmLatLong latLong;

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



    public RealmLatLong getLatLong() {
        return latLong;
    }

    public void setLatLong(RealmLatLong latLong) {
        this.latLong = latLong;
    }


}

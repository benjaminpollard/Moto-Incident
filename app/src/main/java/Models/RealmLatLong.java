package Models;


import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by Ben on 05/01/2017.
 */
@RealmClass
public class RealmLatLong extends RealmObject {



    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    double lat;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    double lng;

}

package Helpers;

import com.google.android.gms.maps.model.LatLng;

import Models.RealmLatLong;

/**
 * Created by Ben on 05/01/2017.
 */

public  class RealmLatLongToGLatLong {

    public static LatLng  GetLatLong(RealmLatLong rLatLong )
    {
      return new LatLng(rLatLong.getLat(),rLatLong.getLng());
    }
}

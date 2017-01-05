package Models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Ben on 05/01/2017.
 */

public class GalleryModel  extends RealmObject {

    public RealmList<RealmStringWrapper> getPhotos() {
        return photos;
    }

    public void setPhotos(RealmList<RealmStringWrapper> photos) {
        this.photos = photos;
    }

    private RealmList<RealmStringWrapper> photos;

}

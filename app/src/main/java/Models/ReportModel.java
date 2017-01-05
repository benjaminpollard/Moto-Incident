package Models;

import io.realm.RealmObject;

/**
 * Created by Ben on 05/01/2017.
 */

public class ReportModel extends RealmObject {
    DescriptionModel descriptionModel;
    DriverInformationModel driverInformationModel;
    GalleryModel galleryModel;

    public LocationModel getLocationModel() {
        return locationModel;
    }

    public void setLocationModel(LocationModel locationModel) {
        this.locationModel = locationModel;
    }

    public GalleryModel getGalleryModel() {
        return galleryModel;
    }

    public void setGalleryModel(GalleryModel galleryModel) {
        this.galleryModel = galleryModel;
    }

    public DriverInformationModel getDriverInformationModel() {
        return driverInformationModel;
    }

    public void setDriverInformationModel(DriverInformationModel driverInformationModel) {
        this.driverInformationModel = driverInformationModel;
    }

    public DescriptionModel getDescriptionModel() {
        return descriptionModel;
    }

    public void setDescriptionModel(DescriptionModel descriptionModel) {
        this.descriptionModel = descriptionModel;
    }

    LocationModel locationModel;
}

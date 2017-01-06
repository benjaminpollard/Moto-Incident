package Helpers;

import java.util.List;

import Models.DescriptionModel;
import Models.DriverInformationModel;
import Models.GalleryModel;
import Models.LocationModel;
import Models.RealmLatLong;
import Models.RealmStringWrapper;
import io.realm.RealmList;

/**
 * Created by Ben on 06/01/2017.
 */

public class ModelBuilderHelper {

    public static RealmLatLong locationModelBuilder(LocationModel modelParam)
    {
        RealmLatLong model = new RealmLatLong();
        model.setLat(modelParam.getLatLong().getLat());
        model.setLng(modelParam.getLatLong().getLng());

        return model;
    }

    public static DescriptionModel DescriptionModelBuilder(String desc)
    {
        DescriptionModel model = new DescriptionModel();
        model.setDescription(desc);

        return model;
    }

    public static DriverInformationModel DescriptionModelBuilder(String setFullName,String setRegistrationPlateNumber,String setVehichleModel,String setVehicleManufacture,String setVehicleRange, String setVechicleInfo)
    {
        DriverInformationModel model = new DriverInformationModel();
        model.setFullName(setFullName);
        model.setRegistrationPlateNumber(setRegistrationPlateNumber);
        model.setVehichleModel(setVehichleModel);
        model.setVehicleManufacture(setVehicleManufacture);
        model.setVehicleRange(setVehicleRange);
        model.setAdditionalInformation(setVechicleInfo);
        return model;
    }

    public static GalleryModel GalleryModelBuilder(List<String> photoList){
        GalleryModel model = new GalleryModel();
        RealmList<RealmStringWrapper> list = new RealmList<>();
        for(String photo : photoList)
        {
            RealmStringWrapper temp = new RealmStringWrapper();
            temp.setString(photo);
            list.add(temp);
        }

        model.setPhotos(list);

        return model;
    }
}

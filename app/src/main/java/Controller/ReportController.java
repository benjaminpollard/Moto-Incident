package Controller;

import android.content.Context;

import Models.CurrentReportModel;
import Models.DescriptionModel;
import Models.DriverInformationModel;
import Models.GalleryModel;
import Models.LocationModel;
import Models.RealmLatLong;
import Models.RealmStringWrapper;
import Models.ReportModel;
import app.mono.com.monoapp.R;
import io.realm.Realm;
import io.realm.RealmLatLongRealmProxy;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ben on 05/01/2017.
 */

public class ReportController {

    ReportModel reportModel;
    Boolean isTest = false;

    public ReportController ()
    {

        SetUpRealmObjects();
    }

    private void SetUpRealmObjects()
    {
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<CurrentReportModel> currentReportQuery = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult = currentReportQuery.findAll();
        //always only one
        if(currentReportResult.size() ==0)
        {
            realm.beginTransaction();

            final ReportModel m = realm.createObject(ReportModel.class);
            CurrentReportModel item = realm.createObject(CurrentReportModel.class);
            item.setCurrentReport( m );
            reportModel = m;
            realm.commitTransaction();
        }else
        {
            reportModel = currentReportResult.get(0).getCurrentReport();
        }
    }
    public ReportController (Boolean Testing)
    {
        isTest = Testing;
        reportModel = new ReportModel();
    }

    public ReportModel GetReport()
    {
        if(reportModel == null)
            SetUpRealmObjects();

        return reportModel;
    }
    public CurrentReportModel GetCurrentReport()
    {
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<CurrentReportModel> currentReportQuery = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult = currentReportQuery.findAll();
        if(currentReportResult.size() >0)
        return currentReportResult.get(0);
        else
        {
            SetUpRealmObjects();
            RealmQuery<CurrentReportModel> currentReportQueryT = realm.where(CurrentReportModel.class);
            RealmResults<CurrentReportModel>currentReportResultT = currentReportQuery.findAll();
            return currentReportResultT.get(0);

        }
    }


    public void AddGalleryItemsToReport(GalleryModel galleryModel)
    {
        if(galleryModel == null)
            return;

        Realm realm = Realm.getDefaultInstance();

        RealmQuery<CurrentReportModel> currentReportQuery = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult = currentReportQuery.findAll();

        CurrentReportModel n = currentReportResult.get(0);


        realm.beginTransaction();

        GalleryModel realmObj = realm.createObject(GalleryModel.class);
        RealmList<RealmStringWrapper> realmPhotoList = new RealmList<RealmStringWrapper>();
        for (RealmStringWrapper photo : galleryModel.getPhotos())
        {
            RealmStringWrapper temp = realm.createObject(RealmStringWrapper.class);
            temp.setString(photo.getString());
            realmPhotoList.add(temp);
        }
        realmObj.setPhotos(realmPhotoList);
        n.getCurrentReport().setGalleryModel(realmObj);


        realm.copyToRealm(n);

        realm.commitTransaction();
        RealmQuery<CurrentReportModel> currentReportQueryv = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResultv = currentReportQueryv.findAll();


    }

    public void AddDescriptionToReport(DescriptionModel descriptionModel)
    {
        if(descriptionModel == null)
            return;

        Realm realm = Realm.getDefaultInstance();

        RealmQuery<CurrentReportModel> currentReportQuery = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult = currentReportQuery.findAll();

        realm.beginTransaction();

        DescriptionModel m = realm.copyToRealm(descriptionModel);
//        GetCurrentReport().getCurrentReport().setDescriptionModel(m);
        currentReportResult.get(0).getCurrentReport().setDescriptionModel(m);

        realm.commitTransaction();

        RealmQuery<CurrentReportModel> currentReportQuery2 = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult2 = currentReportQuery2.findAll();

    }

    public void AddLocationModelReport(RealmLatLong locationModel)
    {
        if(locationModel == null)
            return;

        Realm realm = Realm.getDefaultInstance();

        RealmQuery<CurrentReportModel> currentReportQuery = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult = currentReportQuery.findAll();

        realm.beginTransaction();

        RealmLatLong m = realm.copyToRealm(locationModel);
//        GetCurrentReport().getCurrentReport().setLocationModel(m);
        currentReportResult.get(0).getCurrentReport().setLocationModel(m);

        realm.commitTransaction();


    }

    public void AddDriverInformasionReport(DriverInformationModel driverInformationModel)
    {
        if(driverInformationModel == null)
            return;

        Realm realm = Realm.getDefaultInstance();

        RealmQuery<CurrentReportModel> currentReportQuery = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult = currentReportQuery.findAll();

        realm.beginTransaction();

        DriverInformationModel m = realm.copyToRealm(driverInformationModel);
//        GetCurrentReport().getCurrentReport().setLocationModel(m);
        currentReportResult.get(0).getCurrentReport().setDriverInformationModel(m);

        realm.commitTransaction();

    }

    public String ReturnStringForNoFilledInfo(Context context)
    {
        String ErrorMessage = "";
        if(reportModel.getDescriptionModel() == null)
        {
            ErrorMessage = ErrorMessage + "/n" + context.getResources().getString(R.string.description_not_enetered);
        }
        if(reportModel.getDriverInformationModel() == null)
        {
            ErrorMessage = ErrorMessage  + "/n" +  context.getResources().getString(R.string.info_not_enetered);
        }
        if(reportModel.getGalleryModel() == null)
        {
            ErrorMessage = ErrorMessage  + "/n" +  context.getResources().getString(R.string.gallery_not_enetered);
        }
        if(reportModel.getLocationModel() == null)
        {
            ErrorMessage = ErrorMessage  + "/n" +  context.getResources().getString(R.string.location_not_enetered);
        }
        return ErrorMessage;
    }
}

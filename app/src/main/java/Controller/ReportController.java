package Controller;

import android.content.Context;

import Models.CurrentReportModel;
import Models.DescriptionModel;
import Models.DriverInformationModel;
import Models.GalleryModel;
import Models.LocationModel;
import Models.ReportModel;
import app.mono.com.monoapp.R;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ben on 05/01/2017.
 */

public class ReportController {

    ReportModel reportModel;
    Boolean isTest;

    public ReportController ()
    {
        reportModel = new ReportModel();
    }
    public ReportController (Boolean Testing)
    {
        isTest = Testing;
        reportModel = new ReportModel();
    }
    public ReportModel GetReport()
    {
        return reportModel;
    }
    private void SaveItem()
    {
        //as of right now no plans to support mocking so just skip realm as we cant init in tests
        if(isTest)
            return;

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<CurrentReportModel> currentReportQuery = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult = currentReportQuery.findAll();
        //always only one
        CurrentReportModel currentReport = currentReportResult.get(0);
        currentReport.setCurrentReport(reportModel);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(currentReport);
        realm.commitTransaction();
    }
    public void AddGalleryItemsToReport(GalleryModel galleryModel)
    {
        if(galleryModel == null)
            return;

        reportModel.setGalleryModel(galleryModel);

        SaveItem();
    }

    public void AddDescriptionToReport(DescriptionModel descriptionModel)
    {
        if(descriptionModel == null)
            return;

        reportModel.setDescriptionModel(descriptionModel);

        SaveItem();
    }

    public void AddLocationModelReport(LocationModel locationModel)
    {
        if(locationModel == null)
            return;

        reportModel.setLocationModel(locationModel);

        SaveItem();

    }

    public void AddDriverInformasionReport(DriverInformationModel driverInformationModel)
    {
        if(driverInformationModel == null)
            return;

        reportModel.setDriverInformationModel(driverInformationModel);

        SaveItem();
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

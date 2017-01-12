package Controller;

import java.util.ArrayList;
import java.util.List;

import Models.CurrentReportModel;
import Models.ReportModel;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ben on 05/01/2017.
 */

public class ReportsListController {
    


    public List<ReportModel>  GetAllReports()
    {
        List<ReportModel> reportModelsList = new ArrayList<>();
        RealmQuery<ReportModel> items = Realm.getDefaultInstance().where(ReportModel.class);
        RealmResults<ReportModel> results = items.findAll();
        reportModelsList.addAll(results);
        
        return reportModelsList;
    }

    public void  SaveReport(ReportModel reportToSave)
    {
        List<ReportModel> reportsList =  GetAllReports();
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        reportsList.add(realm.copyToRealm(reportToSave));
        realm.commitTransaction();
    }

    public void  SaveCurrentReportToList()
    {
//        ReportModel currentreport =  GetCurrentReport();
//
//        Realm realm = Realm.getDefaultInstance();
//        RealmQuery<ReportModel> items = Realm.getDefaultInstance().where(ReportModel.class);
//        RealmResults<ReportModel> results = items.findAll();
//
//        realm.beginTransaction();
//        realm.copyToRealm(currentreport);
//        realm.commitTransaction();


    }
    public void RemoveCurrenrReport()
    {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(CurrentReportModel.class);
        realm.commitTransaction();
    }
    public ReportModel  GetCurrentReport()
    {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<CurrentReportModel> currentReportQuery = realm.where(CurrentReportModel.class);
        RealmResults<CurrentReportModel>currentReportResult = currentReportQuery.findAll();
        //always only one
        return currentReportResult.get(0).getCurrentReport();
    }
}

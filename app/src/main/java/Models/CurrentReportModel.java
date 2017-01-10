package Models;

import io.realm.RealmObject;

/**
 * Created by Ben on 05/01/2017.
 */

public class CurrentReportModel extends RealmObject {

    public ReportModel getCurrentReport() {
        if(currentReport == null)
            currentReport = new ReportModel();

        return currentReport;
    }

    public void setCurrentReport(ReportModel currentReport) {
        this.currentReport = currentReport;
    }

    ReportModel currentReport;
}

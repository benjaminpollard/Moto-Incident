package Models;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ben on 05/01/2017.
 */

public class CurrentReportModel extends RealmObject {



    public ReportModel getCurrentReport() {

        return currentReport;
    }

    public CurrentReportModel ()
    {
        currentReport = new ReportModel();
    }

    public void setCurrentReport(ReportModel currentReportp) {
        currentReport = currentReportp;
    }

    ReportModel currentReport;
}

package app.mono.com.monoapp.ControllerTests;

import org.junit.Before;
import org.junit.Test;

import Controller.ReportController;
import Models.DescriptionModel;
import Models.DriverInformationModel;
import Models.GalleryModel;
import Models.LocationModel;
import Models.ReportModel;
import io.realm.Realm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Ben on 05/01/2017.
 */

public class ReportControllerTests {

    private ReportController controller ;

    @Before
    public void SetUp()
    {
        controller = new ReportController(true);
    }
    @Test
    public void CantSetLocasionModelToNull() throws Exception {
        controller.AddLocationModelReport(null);
        ReportModel model = controller.GetReport();
        assertNull(model.getGalleryModel());
    }
    @Test
    public void CantSetDesctrionModelToNull() throws Exception {
        controller.AddDescriptionToReport(null);
        ReportModel model = controller.GetReport();
        assertNull(model.getDescriptionModel());
    }
    @Test
    public void CantSetGalleryModelToNull() throws Exception {
        controller.AddGalleryItemsToReport(null);
        ReportModel model = controller.GetReport();
        assertNull(model.getGalleryModel());
    }
    @Test
    public void CantSetDriverInfoModelToNull() throws Exception {
        controller.AddGalleryItemsToReport(null);
        ReportModel model = controller.GetReport();
        assertNull(model.getDriverInformationModel());
    }

    @Test
    public void CanGalleryModel() throws Exception {
        GalleryModel testItem = new GalleryModel();
        controller.AddGalleryItemsToReport(testItem);
        ReportModel model = controller.GetReport();
        assertEquals(model.getGalleryModel(),testItem);
    }
    @Test
    public void CanDriverInfoModel() throws Exception {
        DriverInformationModel testItem = new DriverInformationModel();
        controller.AddDriverInformasionReport(testItem);
        ReportModel model = controller.GetReport();
        assertEquals(model.getDriverInformationModel(),testItem);
    }
    @Test
    public void CanLocastionModel() throws Exception {
        LocationModel testItem = new LocationModel();
        controller.AddLocationModelReport(testItem);
        ReportModel model = controller.GetReport();
        assertEquals(model.getLocationModel(),testItem);
    }
    @Test
    public void CanSetDescModel() throws Exception {
        DescriptionModel testItem = new DescriptionModel();
        controller.AddDescriptionToReport(testItem);
        ReportModel model = controller.GetReport();
        assertEquals(model.getDescriptionModel(),testItem);
    }
}

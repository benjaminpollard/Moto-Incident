package app.mono.com.monoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.maps.model.LatLng;
import com.tangxiaolv.telegramgallery.GalleryActivity;
import com.tangxiaolv.telegramgallery.GalleryConfig;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import Controller.ReportController;
import Controller.ReportsListController;
import Helpers.ModelBuilderHelper;
import Models.DriverInformationModel;
import Models.GalleryModel;
import Models.RealmStringWrapper;
import Models.ReportModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmList;

public class TheftActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 228;
    @BindView(R.id.button_theft_des) Button description;
    @BindView(R.id.button_theft_image) Button addImage;
    @BindView(R.id.button_theft_loc) Button locasion;
    @BindView(R.id.button_theft_info) Button info;
    @BindView(R.id.button_theft_back) Button back;
    @BindView(R.id.button_theft_summit) Button sumbit;

    private ReportController controller;
    private ReportsListController reportsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theft);

        reportsList = new ReportsListController();

        controller = new ReportController();
        ButterKnife.bind(this);
        SetUpOnClicks();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(reportsList !=null)
        reportsList.RemoveCurrenrReport();
    }

    private void SetIntentAndStartingPage(Context context, int start)
    {
        Intent intent = new Intent(context,FragmentHostActivity.class);
        intent.putExtra(FragmentHostActivity.SET_EXTRA,FragmentHostActivity.INCDIENT_TYPE_THEIFT);
        intent.putExtra(FragmentHostActivity.SET_PAGE,start);

        startActivity(intent);
    }
    private void SetUpOnClicks()
    {
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetIntentAndStartingPage(v.getContext(),0);
            }
        });

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartGallery();
            }
        });

        locasion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetIntentAndStartingPage(v.getContext(),2);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetIntentAndStartingPage(v.getContext(),1);
            }
        });

        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //todo summit to email
                SendEmail();
                reportsList.SaveCurrentReportToList();

                reportsList.RemoveCurrenrReport();

                Activity act = (Activity) v.getContext();
                act.finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Activity activity = (Activity) v.getContext();
                activity.finish();
            }
        });
    }

    private void SendEmail() {
        ReportsListController controller = new ReportsListController();
        ReportModel currentReport = controller.GetCurrentReport();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// set the type to 'email'
        emailIntent .setType("vnd.android.cursor.dir/email");

// the attachment
        if(currentReport.getGalleryModel() != null)
        {
            for (RealmStringWrapper file : currentReport.getGalleryModel().getPhotos())
            {
                File filet = new File(file.getString());
                Uri uri = Uri.fromFile(filet);
                emailIntent.putExtra(Intent.EXTRA_STREAM,  uri);
            }
            emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }


        DriverInformationModel driverInfoModel = currentReport.getDriverInformationModel();
        String result = "";
        if(driverInfoModel != null )
        {
            result = String.format("%1 \n Registration Plate : %s \n VehicleModel : %s \n Vehicle Manufacture: %s \n Vehicle Range : %s \n Additional Information :\n %s \n", driverInfoModel.getFullName(),
                    driverInfoModel.getRegistrationPlateNumber() ,driverInfoModel.getVehichleModel() ,driverInfoModel.getVehicleManufacture(),driverInfoModel.getVehicleRange()
                    ,driverInfoModel.getAdditionalInformation());
        }
        result =  String.format(result + "Description : \n %s ", currentReport.getDescriptionModel().getDescription());


        Geocoder geocoder;
        List<android.location.Address> addresses;
        geocoder = new Geocoder(this,Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(currentReport.getLocationModel().getLat(), currentReport.getLocationModel().getLng(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String postalCode = addresses.get(0).getPostalCode();

            result = String.format(result + "Location : \n Address : %s \n City : %s \n Post Code : %s ", address, city ,postalCode);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if(currentReport.getLocationModel() != null)
        result = String.format(result + " \nLatitude and Longitude : %s & %s \n", currentReport.getLocationModel().getLat(), currentReport.getLocationModel().getLng());


        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, result );
        emailIntent .putExtra(Intent.EXTRA_SUBJECT, "Subject");
        startActivity(Intent.createChooser(emailIntent , "Send email report"));
    }

    private void StartGallery(){
        GalleryConfig config = new GalleryConfig.Build()
                .limitPickPhoto(6)
                .singlePhoto(false)
                .hintOfPick(getString(R.string.photo_picker_hint))
                .filterMimeTypes(new String[]{"image/jpeg"})
                .build();

        GalleryActivity.openActivity(this, REQUEST_CODE, config);
    }

    //process result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && data!= null)
        {
            List<String> list = (List<String>) data.getSerializableExtra(GalleryActivity.PHOTOS);
            controller.AddGalleryItemsToReport(ModelBuilderHelper.GalleryModelBuilder(list));

            //not supproting video as of right now
            //list of videos of seleced
           // List<String> vides = (List<String>) data.getSerializableExtra(GalleryActivity.VIDEO);
        }
    }

}

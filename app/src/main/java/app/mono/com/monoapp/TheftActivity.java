package app.mono.com.monoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tangxiaolv.telegramgallery.GalleryActivity;
import com.tangxiaolv.telegramgallery.GalleryConfig;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TheftActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 228;
    @BindView(R.id.button_theft_des) Button description;
    @BindView(R.id.button_theft_image) Button addImage;
    @BindView(R.id.button_theft_loc) Button locasion;
    @BindView(R.id.button_theft_info) Button info;
    @BindView(R.id.button_theft_back) Button back;
    @BindView(R.id.button_theft_summit) Button sumbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theft);

        ButterKnife.bind(this);
        SetUpOnClicks();

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
                SetIntentAndStartingPage(v.getContext(),3);
            }
        });

        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //todo summit to email

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
    private void StartGallery(){
        GalleryConfig config = new GalleryConfig.Build()
                .limitPickPhoto(6)
                .singlePhoto(false)
                .hintOfPick("photo of incident")
                .filterMimeTypes(new String[]{"image/jpeg"})
                .build();
        GalleryActivity.openActivity(this, REQUEST_CODE, config);
    }

    //process result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && data!= null)
        {
            List<String> photos = (List<String>) data.getSerializableExtra(GalleryActivity.PHOTOS);
            //todo save photos
            //list of videos of seleced
            List<String> vides = (List<String>) data.getSerializableExtra(GalleryActivity.VIDEO);
        }
    }
}

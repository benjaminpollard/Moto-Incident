package app.mono.com.monoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.view.View;
import android.widget.Button;

import Controller.ReportController;
import butterknife.BindView;
import butterknife.ButterKnife;

public class IncidentTypeActivity extends AppCompatActivity {

    @BindView(R.id.button_incedenttype_one) Button buttonOne;
    @BindView(R.id.button_incedenttype_two) Button buttonTwo;
    @BindView(R.id.button_incedenttype_three) Button buttonThree;
    @BindView(R.id.button_incedenttype_four) Button buttonFour;
    @BindView(R.id.button_incedenttype_back) Button buttonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incedent_type_actvitiy);

        ButterKnife.bind(this);

        SetUp();


    }

    private void SetUp() {

        SetUpOnClicks();

    }
    private void SetUpOnClicks()
    {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = (IncidentTypeActivity) v.getContext();
                activity.startActivity(new Intent(activity,TheftActivity.class));
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = (IncidentTypeActivity) v.getContext();
                activity.startActivity(new Intent(activity,TheftActivity.class));
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = (IncidentTypeActivity) v.getContext();
                activity.startActivity(new Intent(activity,TheftActivity.class));
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = (IncidentTypeActivity) v.getContext();
                activity.startActivity(new Intent(activity,TheftActivity.class));
            }
        });
//        Drawable img;
//        Resources res = getResources();
//        img = res.getDrawable(R.drawable.tempicon);
//        img.setBounds(0, 0, 1, 1);
//
//        buttonOne.setCompoundDrawablesWithIntrinsicBounds(img,null,img,null);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = (IncidentTypeActivity) v.getContext();
                activity.finish();
            }
        });


    }
}

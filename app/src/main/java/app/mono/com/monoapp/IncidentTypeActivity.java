package app.mono.com.monoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = (IncidentTypeActivity) v.getContext();
                activity.finish();
            }
        });
    }
}

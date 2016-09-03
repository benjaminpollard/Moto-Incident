package app.mono.com.monoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IncidentTypeActivity extends AppCompatActivity {

    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incedent_type_actvitiy);

        SetUp();


    }

    private void SetUp() {
        buttonOne = (Button)findViewById(R.id.button_incedenttype_one);
        buttonTwo = (Button)findViewById(R.id.button_incedenttype_two);
        buttonThree = (Button)findViewById(R.id.button_incedenttype_three);
        buttonFour = (Button)findViewById(R.id.button_incedenttype_four);
        buttonBack = (Button)findViewById(R.id.button_incedenttype_back);

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

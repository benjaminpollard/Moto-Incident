package app.mono.com.monoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TheftActivity extends AppCompatActivity {

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
                SetIntentAndStartingPage(v.getContext(),1);
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
                SetIntentAndStartingPage(v.getContext(),0);
            }
        });
    }
}

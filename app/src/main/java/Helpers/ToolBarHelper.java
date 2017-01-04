package Helpers;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Ben on 04/01/2017.
 */

public class ToolBarHelper {

    public static void  SetUpFragmentToolBar(Fragment fragment, Toolbar bar , String title)
    {
        AppCompatActivity activity = (AppCompatActivity) fragment.getActivity();
        activity.setSupportActionBar( bar );
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowCustomEnabled(false);
        activity.setTitle(title);
    }
}

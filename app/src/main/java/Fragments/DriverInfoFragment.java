package Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import Helpers.ToolBarHelper;
import app.mono.com.monoapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.google.android.gms.plus.PlusOneButton;

public class DriverInfoFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    @BindView(R.id.driver_info_name)  AppCompatEditText driverInfoName;
    @BindView(R.id.driver_info_reg) AppCompatEditText driverInfoReg;
    @BindView(R.id.driver_info_vec) AppCompatEditText driverInfoVec;
    @BindView(R.id.driver_info_range) AppCompatEditText driverInfoModel;
    @BindView(R.id.driver_info_model) AppCompatEditText driverInfoRange;
    @BindView(R.id.driver_info_info) AppCompatEditText driverInfoInfo;
    @BindView(R.id.driver_info_sub_btn) Button summitButton;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private OnDriverInfoFragmentInteractionListener mListener;

    public DriverInfoFragment() {
        // Required empty public constructor
    }


    public static DriverInfoFragment newInstance() {
        DriverInfoFragment fragment = new DriverInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_driver_info, container, false);
        ButterKnife.bind(this,view);

        ToolBarHelper.SetUpFragmentToolBar(this,toolbar,getActivity().getString(R.string.driver_informacion_fragment_name));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onDriveInfoFragmentInteraction(driverInfoName.getText().toString()
                    ,driverInfoReg.getText().toString()
                    ,driverInfoVec.getText().toString()
                    ,driverInfoModel.getText().toString()
                    ,driverInfoRange.getText().toString(),
                     driverInfoInfo.getText().toString());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDriverInfoFragmentInteractionListener) {
            mListener = (OnDriverInfoFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnDriverInfoFragmentInteractionListener {
        void onDriveInfoFragmentInteraction(String driverInfoName,String driverInfoReg,String driverInfoVec,String driverInfoModel, String driverInfoRange, String driverInfoInfo);
    }

}

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

    private OnFragmentInteractionListener mListener;

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
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}

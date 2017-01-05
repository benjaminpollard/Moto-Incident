package Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import Helpers.ToolBarHelper;
import app.mono.com.monoapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;


public class DescriptionFragment extends Fragment {



    private OnDescriptionFragmentInteractionListener mListener;

    @BindView(R.id.desc_frag_button_summit) Button summit;
    @BindView(R.id.desc_frag_edit_text) AppCompatEditText descEditText;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    public DescriptionFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DescriptionFragment newInstance() {
        DescriptionFragment fragment = new DescriptionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        ButterKnife.bind(this,view);

        ToolBarHelper.SetUpFragmentToolBar(this,toolbar,getActivity().getString(R.string.description_fragment_name));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String des) {
        if (mListener != null) {
            mListener.onDescriptionFragmentInteraction(des);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDescriptionFragmentInteractionListener) {
            mListener = (OnDescriptionFragmentInteractionListener) context;
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
    public interface OnDescriptionFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDescriptionFragmentInteraction(String desc);
    }
}

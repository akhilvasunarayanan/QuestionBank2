package com.example.akhi.questionbank;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link exam_settings.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link exam_settings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class exam_settings extends Fragment {

    myDbAdapter helper;
    EditText rightMark, wrongMark;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public exam_settings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment exam_settings.
     */
    // TODO: Rename and change types and number of parameters
    public static exam_settings newInstance(String param1, String param2) {
        exam_settings fragment = new exam_settings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_exam_settings, container, false);

        rightMark = (EditText)view.findViewById(R.id.rMark);
        wrongMark = (EditText) view.findViewById(R.id.wMark);

        helper = new myDbAdapter(this.getContext());

        Button btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveSettings(v);
            }
        });

        showSettings();

        return  view;
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
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public  void  showSettings()
    {
        String rVal = helper.getSettings("RightAnswerMark");
        String wVal = helper.getSettings("WrongAnswerMark");

        rightMark.setText(rVal);
        wrongMark.setText(wVal);
    }

    public void saveSettings(View view)
    {
        String rMarkValue = rightMark.getText().toString();
        String wMarkValue = wrongMark.getText().toString();

        if(rMarkValue.length() == 0 || wMarkValue.length() == 0)
        {
            Message.message(getContext().getApplicationContext(),"Enter Both Name and Password");
        }
        else
        {
            long idR = helper.SaveSettings("RightAnswerMark", rMarkValue);
            long idW = helper.SaveSettings("WrongAnswerMark", wMarkValue);
            if(idR<=0 || idW<=0)
            {
                Message.message(getContext().getApplicationContext(),"Updation Failed");
                //Name.setText("");
                //Pass.setText("");
            } else
            {
                Message.message(getContext().getApplicationContext(),"Updated");
                //Name.setText("");
                //Pass.setText("");
            }
        }
    }
}

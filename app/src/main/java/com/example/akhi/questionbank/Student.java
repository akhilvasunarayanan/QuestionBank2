package com.example.akhi.questionbank;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.content.Intent;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Student.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Student#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student extends Fragment {

    private myDbAdapter dbManager;

    private ListView listView;
    private TextView emptyText;

    private android.support.v4.widget.SimpleCursorAdapter adapter;

    final String[] from = new String[] { myDbAdapter.tableStudents.UID,
            myDbAdapter.tableStudents.REGNO, myDbAdapter.tableStudents.NAME };

    final int[] to = new int[] { R.id.id, R.id.rollno, R.id.name };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Student() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Student.
     */
    // TODO: Rename and change types and number of parameters
    public static Student newInstance(String param1, String param2) {
        Student fragment = new Student();
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
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        listView = (ListView) view.findViewById(R.id.list_view);
        emptyText = view.findViewById(R.id.empty);
        fillStudents();

        return view;
    }

    @Override
    public void  onResume()
    {
        fillStudents();
        super.onResume();
    }

    public  void fillStudents()
    {
        dbManager = new myDbAdapter(this.getContext());

        Cursor cursor = dbManager.GetAllStudents();

        listView.setEmptyView(emptyText);

        adapter = new android.support.v4.widget.SimpleCursorAdapter(this.getContext(), R.layout.activity_view_students, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView rollnoTextView = (TextView) view.findViewById(R.id.rollno);
                TextView nameTextView = (TextView) view.findViewById(R.id.name);

                String id = idTextView.getText().toString();
                String rollno = rollnoTextView.getText().toString();
                String name = nameTextView.getText().toString();

                Intent modify_intent = new Intent(getContext(), modify_record.class);
                modify_intent.putExtra("rollno", rollno);
                modify_intent.putExtra("name", name);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);
            }
        });
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
       /* if (context instanceof OnFragmentInteractionListener) {
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
}

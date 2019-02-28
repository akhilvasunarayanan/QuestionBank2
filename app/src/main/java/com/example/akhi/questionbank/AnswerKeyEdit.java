package com.example.akhi.questionbank;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswerKeyEdit extends AppCompatActivity implements View.OnClickListener {

    private long examId;
    private int answerSheetId;
    private ListView listView;
    private AnswerKeyAdapter aAdapter;
    private myDbAdapter dbManager;
    private Button BtnSave;
    ArrayList<myDbAdapter.AnswerKey> answerKeyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Answer Key Edit");
        setContentView(R.layout.activity_answer_key_edit);

        BtnSave = (Button) findViewById(R.id.btnAnswerKeyEditSave);
        listView = (ListView) findViewById(R.id.listViewAnswerKeyEditKey);

        BtnSave.setOnClickListener(this);

        Intent intent = getIntent();
        examId = Long.parseLong(intent.getStringExtra("ExamId"));
        answerSheetId = Integer.parseInt(intent.getStringExtra("AnswerSheetId"));

        fillAnswerKey();
    }

    private void fillAnswerKey()
    {
        dbManager = new myDbAdapter(this.getApplicationContext());

        ArrayList<myDbAdapter.AnswerKey> dbAnswerKeyList = dbManager.GetAnswerKeys(examId);
        answerKeyList = new ArrayList<myDbAdapter.AnswerKey>();

        for (int qNo = 1; qNo <= Global.GetAnswerSheet(answerSheetId).Questions; qNo++)
        {
            boolean found = false;

            for (myDbAdapter.AnswerKey aKey: dbAnswerKeyList)
            {
                if(aKey.QuestionNo == qNo) {
                    answerKeyList.add(aKey);
                    found = true;

                    break;
                }
            }

            if(!found)
            {
                answerKeyList.add(dbManager.new AnswerKey(qNo, 0));
            }
        }

        aAdapter = new AnswerKeyAdapter(this);
        listView.setAdapter(aAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAnswerKeyEditSave:
                dbManager.InsertAnswerKey(examId, answerKeyList);
                finish();
                break;
        }
    }

    public class AnswerKeyAdapter extends ArrayAdapter<myDbAdapter.AnswerKey>
    {
        private Context mContext;

        public AnswerKeyAdapter(@NonNull Context context)
        {
            super(context, 0 , answerKeyList);
            mContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItem = convertView;

            if (listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_view_answer_key_edit, parent, false);

            myDbAdapter.AnswerKey currentAnswerKey = answerKeyList.get(position);

            Button btnAnswerKeyNo = (Button) listItem.findViewById(R.id.btnViewAnswerKeyEditNo);
            btnAnswerKeyNo.setText(Integer.toString(currentAnswerKey.QuestionNo));

            RadioButton radBtnA = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditA);
            RadioButton radBtnB = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditB);
            RadioButton radBtnC = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditC);
            RadioButton radBtnD = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditD);
            RadioButton radBtnE = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditE);
            RadioGroup radGrp = (RadioGroup) listItem.findViewById(R.id.radGrpViewAnswerKeyEdit);

            switch (currentAnswerKey.Option) {
                case 1:
                    radGrp.check(R.id.radViewAnswerKeyEditA);
                    break;
                case 2:
                    radGrp.check(R.id.radViewAnswerKeyEditB);
                    break;
                case 3:
                    radGrp.check(R.id.radViewAnswerKeyEditC);
                    break;
                case 4:
                    radGrp.check(R.id.radViewAnswerKeyEditD);
                    break;
                case 5:
                    radGrp.check(R.id.radViewAnswerKeyEditE);
                    break;
                default:
                    radGrp.clearCheck();
            }

            final int _position = position;

            radBtnA.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    answerKeyList.set(_position, dbManager.new AnswerKey(_position + 1, 1));
                }
            });

            radBtnB.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    answerKeyList.set(_position, dbManager.new AnswerKey(_position + 1, 2));
                }
            });

            radBtnC.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    answerKeyList.set(_position, dbManager.new AnswerKey(_position + 1, 3));
                }
            });

            radBtnD.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    answerKeyList.set(_position, dbManager.new AnswerKey(_position + 1, 4));
                }
            });

            radBtnE.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    answerKeyList.set(_position, dbManager.new AnswerKey(_position + 1, 5));
                }
            });

            return listItem;
        }
    }
}

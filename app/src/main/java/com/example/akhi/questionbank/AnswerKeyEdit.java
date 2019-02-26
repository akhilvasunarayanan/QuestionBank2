package com.example.akhi.questionbank;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Answer Key Edit");
        setContentView(R.layout.activity_answer_key_edit);

        BtnSave = (Button) findViewById(R.id.btnAnswerKeyEditSave);

        BtnSave.setOnClickListener(this);

        Intent intent = getIntent();
        examId = Long.parseLong(intent.getStringExtra("ExamId"));
        answerSheetId = Integer.parseInt(intent.getStringExtra("AnswerSheetId"));

        fillAnswerKey();
    }

    private void fillAnswerKey()
    {
        dbManager = new myDbAdapter(this.getApplicationContext());
        listView = (ListView) findViewById(R.id.listViewAnswerKeyEditKey);

        ArrayList<myDbAdapter.AnswerKey> dbAnswerKeyList = dbManager.GetAnswerKeys(examId);
        ArrayList<myDbAdapter.AnswerKey> answerKeyList = new ArrayList<myDbAdapter.AnswerKey>();

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

        aAdapter = new AnswerKeyAdapter(this,answerKeyList);
        listView.setAdapter(aAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAnswerKeyEditSave:
                //final String ExamName = examNameText.getText().toString();
                //final String ExamDateStr = examDateText.getText().toString();


                break;
        }
    }

    public class AnswerKeyAdapter extends ArrayAdapter<myDbAdapter.AnswerKey>
    {
        private Context mContext;
        private List<myDbAdapter.AnswerKey> answerKeyList = new ArrayList<>();

        public AnswerKeyAdapter(@NonNull Context context, @LayoutRes ArrayList<myDbAdapter.AnswerKey> list)
        {
            super(context, 0 , list);
            mContext = context;
            answerKeyList = list;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            View listItem = convertView;

            if(listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_view_answer_key_edit,parent,false);

            myDbAdapter.AnswerKey currentAnswerKey = answerKeyList.get(position);

            Button btnAnswerKeyNo = (Button) listItem.findViewById(R.id.btnViewAnswerKeyEditNo);
            btnAnswerKeyNo.setText(Integer.toString(currentAnswerKey.QuestionNo));

            switch (currentAnswerKey.Option) {
                case 1:
                    RadioButton radBtnA = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditA);
                    radBtnA.setChecked(true);
                    break;
                case 2:
                    RadioButton radBtnB = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditB);
                    radBtnB.setChecked(true);
                    break;
                case 3:
                    RadioButton radBtnC = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditC);
                    radBtnC.setChecked(true);
                    break;
                case 4:
                    RadioButton radBtnD = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditD);
                    radBtnD.setChecked(true);
                    break;
                case 5:
                    RadioButton radBtnE = (RadioButton) listItem.findViewById(R.id.radViewAnswerKeyEditE);
                    radBtnE.setChecked(true);
                    break;
            }

            return listItem;
        }
    }
}

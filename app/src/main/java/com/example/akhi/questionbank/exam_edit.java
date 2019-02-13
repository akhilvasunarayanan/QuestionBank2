package com.example.akhi.questionbank;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnClickListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class exam_edit extends AppCompatActivity implements OnClickListener {

    private EditText examNameText;
    private EditText examDateText;
    private Spinner answerSheetTypeSpnr;
    private Button saveExamBtn;

    private myDbAdapter dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Examination");
        setContentView(R.layout.activity_exam_edit);

        examNameText = (EditText) findViewById(R.id.editTextExamName);
        examDateText = (EditText) findViewById(R.id.editTextExamDate);
        answerSheetTypeSpnr = (Spinner) findViewById(R.id.spnrAnswerSheetType);
        saveExamBtn = (Button) findViewById(R.id.btnExamSave);

        dbManager = new myDbAdapter(getBaseContext());

        saveExamBtn.setOnClickListener(this);

        ArrayAdapter<Global.AnswerSheetType> adapter =
                new ArrayAdapter<Global.AnswerSheetType>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, Global.answerSheetType);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        answerSheetTypeSpnr.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExamSave:
                final String ExamName = examNameText.getText().toString();
                final String ExamDateStr = examDateText.getText().toString();
                final int AnserSheetType = ((Global.AnswerSheetType)answerSheetTypeSpnr.getSelectedItem()).Id;

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date ExamDate = format.parse(ExamDateStr);
                    dbManager.insertExam(ExamName, ExamDate, AnserSheetType);
                    finish();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

}

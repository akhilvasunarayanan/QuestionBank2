package com.example.akhi.questionbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayExam extends AppCompatActivity {

    private TextView examName, examDate, answerSheetType;
    private myDbAdapter dbManager;
    private long examId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Examination Details");
        setContentView(R.layout.activity_display_exam);

        dbManager = new myDbAdapter(getBaseContext());

        examName = (TextView) findViewById(R.id.textViewExDispName);
        examDate = (TextView) findViewById(R.id.textViewExDispDate);
        answerSheetType = (TextView) findViewById((R.id.textViewExDispAnswerSheetType));

        Intent intent = getIntent();
        String id = intent.getStringExtra("ExamId");
        examId = Long.parseLong(id);
        displayExamDetails(examId);
    }

    private void displayExamDetails(long id)
    {
        myDbAdapter.ExamDetails examDetails = dbManager.GetExamDetails(id);

        examName.setText(examDetails.examName);
        examDate.setText(examDetails.examDate.toString());
        answerSheetType.setText(examDetails.answerSheetType);
    }
}

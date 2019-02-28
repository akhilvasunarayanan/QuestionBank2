package com.example.akhi.questionbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayExam extends AppCompatActivity implements View.OnClickListener {

    private TextView examName, examDate, answerSheetType;
    private myDbAdapter dbManager;
    private long examId;
    private Button btnAnswerKey, btnEvaluate;
    private int answerSheetId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Examination Details");
        setContentView(R.layout.activity_display_exam);

        dbManager = new myDbAdapter(getBaseContext());

        examName = (TextView) findViewById(R.id.textViewExDispName);
        examDate = (TextView) findViewById(R.id.textViewExDispDate);
        answerSheetType = (TextView) findViewById((R.id.textViewExDispAnswerSheetType));
        btnAnswerKey = (Button) findViewById(R.id.btnExDispAnswerKey);
        btnEvaluate = (Button) findViewById(R.id.btnExDispEvaluate);

        btnAnswerKey.setOnClickListener(this);
        btnEvaluate.setOnClickListener(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("ExamId");
        examId = Long.parseLong(id);
        displayExamDetails(examId);
    }

    private void displayExamDetails(long id)
    {
        myDbAdapter.ExamDetails examDetails = dbManager.GetExamDetails(id);

        examName.setText(examDetails.examName);
        examDate.setText( android.text.format.DateFormat.format("dd/MMM/yyyy",examDetails.examDate).toString());
        answerSheetType.setText(Global.GetAnswerSheet(examDetails.answerSheetType).Name);
        answerSheetId = examDetails.answerSheetType;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExDispAnswerKey:
                Intent intentAnswerKey = new Intent(getApplicationContext(), AnswerKeyEdit.class);
                intentAnswerKey.putExtra("ExamId", Long.toString(examId));
                intentAnswerKey.putExtra("AnswerSheetId", Integer.toString(answerSheetId));
                startActivity(intentAnswerKey);
                break;
            case  R.id.btnExDispEvaluate:
                Intent intentEvaluate = new Intent(getApplicationContext(), Evaluate.class);
                intentEvaluate.putExtra("ExamId", Long.toString(examId));
                intentEvaluate.putExtra("AnswerSheetId", Integer.toString(answerSheetId));
                startActivity(intentEvaluate);
                break;
        }
    }
}

package com.example.akhi.questionbank;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class exam_edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Examination");
        setContentView(R.layout.activity_exam_edit);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<Global.AnswerSheetType> adapter =
                new ArrayAdapter<Global.AnswerSheetType>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, Global.answerSheetType);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }


}

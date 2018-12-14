package com.example.akhi.questionbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class add_record extends AppCompatActivity implements OnClickListener {

    private Button addTodoBtn;
    private EditText rollnoEditText;
    private EditText nameEditText;

    private myDbAdapter dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Record");
        setContentView(R.layout.activity_add_record);
        rollnoEditText = (EditText) findViewById(R.id.rollno_edittext);
        nameEditText = (EditText) findViewById(R.id.name_edittext);

        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new myDbAdapter(getBaseContext());
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:
                final String name = rollnoEditText.getText().toString();
                final String desc = nameEditText.getText().toString();

                dbManager.insertStudent(name, desc);

/*                Intent main = new Intent(add_record.this, view_students.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);*/
                finish();
                break;
        }
    }
}

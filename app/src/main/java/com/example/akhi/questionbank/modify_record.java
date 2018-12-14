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

public class modify_record extends AppCompatActivity implements OnClickListener{

    private EditText rollnoText;
    private Button updateBtn, deleteBtn;
    private EditText nameText;

    private long _id;

    private myDbAdapter dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_modify_record);

        dbManager = new myDbAdapter(getBaseContext());

        rollnoText = (EditText) findViewById(R.id.rollno_edittext);
        nameText = (EditText) findViewById(R.id.name_edittext);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String rollno = intent.getStringExtra("rollno");

        _id = Long.parseLong(id);
        rollnoText.setText(rollno);
        nameText.setText(name);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                String rollno = rollnoText.getText().toString();
                String name = nameText.getText().toString();

                dbManager.updateStudent(_id, rollno, name);
                this.returnHome();
                break;

            case R.id.btn_delete:
                dbManager.deleteStudent(_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {
        finish();
    }
}

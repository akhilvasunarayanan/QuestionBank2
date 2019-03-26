package com.example.akhi.questionbank;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class Evaluate extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private long examId;
    private int answerSheetId;
    private Class_Ans_Check ClsAns = new Class_Ans_Check();
    private Class_OMR ClsOMR = new Class_OMR();
    ImageView imageView;
    private myDbAdapter dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        imageView = (ImageView) this.findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.btnCapture);

        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        Intent intent = getIntent();
        examId = Long.parseLong(intent.getStringExtra("ExamId"));
        answerSheetId = Integer.parseInt(intent.getStringExtra("AnswerSheetId"));

        ClsAns.Tot_Question = Global.GetAnswerSheet(answerSheetId).Questions;
        fillAnswerKey();

        ClsAns.Right_Ans_Mark = 4;
        ClsAns.Wrong_Ans_Mark = -1;
    }

    private void fillAnswerKey()
    {
        dbManager = new myDbAdapter(this.getApplicationContext());
        ArrayList<myDbAdapter.AnswerKey> answerKeyList;

        ArrayList<myDbAdapter.AnswerKey> dbAnswerKeyList = dbManager.GetAnswerKeys(examId);
        ClsAns.Ans_Key = new int[ClsAns.Tot_Question + 1];

        for (int qNo = 1; qNo <= Global.GetAnswerSheet(answerSheetId).Questions; qNo++)
        {
            boolean found = false;

            for (myDbAdapter.AnswerKey aKey: dbAnswerKeyList)
            {
                if(aKey.QuestionNo == qNo) {
                    ClsAns.Ans_Key[qNo] = aKey.Option;
                    found = true;
                    break;
                }
            }

            if(!found)
            {
                ClsAns.Ans_Key[qNo] = 0;
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    private void EvaluateAnswerSheet(Bitmap BmOmr)
    {
        int[] Reg_Last_Digits = new int[1];
        int[] Attented_Qu = new int[1];

        ClsAns.Get_Ans_Sheet_Result(BmOmr, ClsOMR, Reg_Last_Digits, Attented_Qu, );
    }
}

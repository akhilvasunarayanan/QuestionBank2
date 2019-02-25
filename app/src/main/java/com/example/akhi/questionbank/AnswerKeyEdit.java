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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnswerKeyEdit extends AppCompatActivity {

    private long examId;
    private int answerSheetId;
    private ListView listView;
    private AnswerKeyAdapter aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Answer Key Edit");
        setContentView(R.layout.activity_answer_key_edit);

        Intent intent = getIntent();
        intent.getLongExtra("ExamId", examId);
        intent.getIntExtra("AnswerSheetId", answerSheetId);

        fillAnswerKey();
    }

    private void fillAnswerKey()
    {
        listView = (ListView) findViewById(R.id.listViewAnswerKeyEditKey);

        ArrayList<AnswerKey> answerKeyList = new ArrayList<>();
        answerKeyList.add(new AnswerKey(1,2));
        answerKeyList.add(new AnswerKey(2,1));
        answerKeyList.add(new AnswerKey(3,3));
        answerKeyList.add(new AnswerKey(4,2));
        answerKeyList.add(new AnswerKey(5,4));

        aAdapter = new AnswerKeyAdapter(this,answerKeyList);
        listView.setAdapter(aAdapter);
    }

    public class AnswerKey
    {
        private int questionNo;
        private int option;

        public AnswerKey(int QuestionNo, int Option)
        {
            this.questionNo = QuestionNo;
            this.option = Option;
        }

        public String GetQuestionNo()
        {
            return Integer.toString(questionNo);
        }

        public int GetOption()
        {
            return option;
        }

        public void SetQuestionNo(int QuestionNo)
        {
            this.questionNo = QuestionNo;
        }

        public void SetOption(int Option)
        {
            this.option = Option;
        }
    }

    public class AnswerKeyAdapter extends ArrayAdapter<AnswerKey>
    {
        private Context mContext;
        private List<AnswerKey> answerKeyList = new ArrayList<>();

        public AnswerKeyAdapter(@NonNull Context context, @LayoutRes ArrayList<AnswerKey> list)
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

            AnswerKey currentAnswerKey = answerKeyList.get(position);

            Button btnAnswerKeyNo = (Button) listItem.findViewById(R.id.btnViewAnswerKeyEditNo);
            btnAnswerKeyNo.setText(currentAnswerKey.GetQuestionNo());

            return listItem;
        }

    }


}

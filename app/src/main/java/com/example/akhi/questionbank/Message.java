package com.example.akhi.questionbank;

//package com.example.sqliteoperations;

import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}

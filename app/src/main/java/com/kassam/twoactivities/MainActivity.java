package com.kassam.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "MY KEY";
    private static String CLICKER = MainActivity.class.getSimpleName();

    private EditText messageEditText;
    private TextView replyText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = findViewById(R.id.messageInput);
        replyText = findViewById(R.id.textDisplayMain);

        Intent i = getIntent();
        String replyMessage = i.getStringExtra(SecondActivity.REPLY);
        replyText.setText(replyMessage);
    }

    public void launchSecondActivity(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        Log.d(CLICKER, "button clicked");
        String message = messageEditText.getText().toString();
        i.putExtra(EXTRA_MESSAGE, message);//passes the message to the next intent
        startActivity(i);
    }



}
package com.kassam.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static String REPLY = "Reply";
    private TextView title, messageDisplay;
    private EditText sendText;
    private Button sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        title = findViewById(R.id.title);
        messageDisplay = findViewById(R.id.messageDisplay);
        sendText = findViewById(R.id.sendText);
        sendMessage = findViewById(R.id.button);



        Intent i = getIntent();
        String message = i.getStringExtra(MainActivity.EXTRA_MESSAGE);
        messageDisplay.setText(message);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                String replyMessage = sendText.getText().toString();

                i.putExtra(REPLY, replyMessage);

                startActivity(i);
            }
        });


//        implement a reply functionality on this activity to show message on the main activity. -> HomeWork
    }
}
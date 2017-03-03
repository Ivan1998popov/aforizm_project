package ru.inostudio.aforizm.activity.activity.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.inostudio.aforizm.R;

public class StartActivity extends BasicActivity {
    private Button sendButton;
    private Button sendButton2;
    private Button sendButton3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_main);
        Log.d("ttt67", "check_point_3");

        rootLayout = (ViewGroup) findViewById(R.id.activity_main);
        sendButton = (Button) findViewById(R.id.button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, CategoryAphorisms.class);
                startActivity(intent);
            }
        });
        sendButton2=(Button)findViewById(R.id.button2);
        sendButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, AlarmActivity.class);
                startActivity(intent);
            }
        });
        sendButton3 = (Button) findViewById(R.id.button3);
        sendButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, Settings.class);
                startActivity(intent);
            }
        });

    }
}




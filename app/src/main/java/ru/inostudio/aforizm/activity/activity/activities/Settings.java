package ru.inostudio.aforizm.activity.activity.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import ru.inostudio.aforizm.R;

/**
 * Created by Admin on 10.05.2016.
 */
public class Settings extends BasicActivity {
    private Button sendButton2;
    private Switch customSwitch;
    private Button password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);
        rootLayout = (ViewGroup) findViewById(R.id.activity_main3);
        customSwitch=(Switch)findViewById(R.id.switch1);
        sendButton2 = (Button) findViewById(R.id.background);
        password=(Button) findViewById(R.id.password);
        sendButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, ColorActivity.class);
                startActivity(intent);
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Password.class);
                startActivity(intent);
            }
        });

        customSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PreferenceManager.getDefaultSharedPreferences(Settings.this)
                        .edit()
                        .putBoolean("1234",isChecked)
                        .commit();
                if (isChecked) {
                    Toast.makeText(Settings.this, "ON", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Settings.this, "OFF", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

package ru.inostudio.aforizm.activity.activity.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.inostudio.aforizm.R;

/**
 * Created by Admin on 19.05.2016.
 */
public class Enter_password extends BasicActivity {
    private Button enter;
    private EditText enter_password;
    private EditText password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_password);
        rootLayout = (ViewGroup) findViewById(R.id.enter_password);
        enter = (Button) findViewById(R.id.enter);
        enter_password = (EditText) findViewById(R.id.enter_password1);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = PreferenceManager.getDefaultSharedPreferences(Enter_password.this).getString("password", "");
                if (enter_password.getText().toString().equals(password) ) {
                    Intent intent = new Intent(Enter_password.this, StartActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Enter_password.this, "Неправильный пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String password = PreferenceManager.getDefaultSharedPreferences(Enter_password.this).getString("password", "");
        if (password.equals("")) {
            // переходим на Main Activity
            Intent intent = new Intent(Enter_password.this, StartActivity.class);
            startActivity(intent);
        }
    }
}


package ru.inostudio.aforizm.activity.activity.activities;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import ru.inostudio.aforizm.R;

/**
 * Created by Admin on 19.05.2016.
 */
public class Password extends BasicActivity {
    private EditText password1;
    private EditText password2;
    private Button saveNameButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);
        rootLayout = (ViewGroup) findViewById(R.id.password);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        saveNameButton = (Button) findViewById(R.id.save_name_button);
        saveNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password1.getText().toString().equals(password2.getText().toString())) {

                    PreferenceManager.getDefaultSharedPreferences(Password.this)
                            .edit()
                            .putString("password", password1.getText().toString())
                            .commit();
                    onBackPressed();
                } else {
                    Toast.makeText(Password.this, "Пароли не совпадают!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        password1.setText(PreferenceManager.getDefaultSharedPreferences(Password.this)
                .getString("password", ""));


    }
}

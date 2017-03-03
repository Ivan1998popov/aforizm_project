package ru.inostudio.aforizm.activity.activity.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ru.inostudio.aforizm.R;

public class Aphorism extends BasicActivity implements View.OnClickListener {
    TextView my_aforizm;
    Button btninstalling;
    public static final String AFORIZM = "my_aforizm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_aforizm);
        btninstalling=(Button)findViewById(R.id.installing);
        btninstalling.setOnClickListener(this);
       // ContextCompat.getDrawable()
        rootLayout = (ViewGroup) findViewById(R.id.activity_my_aforizm);
        my_aforizm=(TextView)findViewById(R.id.my_aforizms);

        String aforizmText = getIntent().getStringExtra(AFORIZM);
        my_aforizm.setText(aforizmText);

        String fd= getIntent().getStringExtra("my_aforizm");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.installing:
                Intent intent=new Intent(Aphorism.this,AlarmActivity.class);
                intent.putExtra(AFORIZM, my_aforizm.getText());
                startActivity(intent);
                break;
        }

    }
}

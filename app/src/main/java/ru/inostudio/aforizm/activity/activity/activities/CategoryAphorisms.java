package ru.inostudio.aforizm.activity.activity.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.inostudio.aforizm.R;

/**
 * Created by Admin on 10.05.2016.
 */
public class CategoryAphorisms extends BasicActivity implements View.OnClickListener {

    Button btnLife;
    Button btnFriends;
    Button btnPeoples;
    Button btnFunny;
    Button btnLove;
    Button btnMotivation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categoryaphorisms_main);
        rootLayout = (ViewGroup) findViewById(R.id.activity_main2);
        btnLife=(Button)findViewById(R.id.life);
        btnFriends=(Button)findViewById(R.id.friends);
        btnPeoples=(Button)findViewById(R.id.peoples);
        btnFunny=(Button)findViewById(R.id.funny);
        btnMotivation=(Button)findViewById(R.id.motivation);
        btnLove=(Button)findViewById(R.id.love);
        btnLife.setOnClickListener(this);
        btnFriends.setOnClickListener(this);
        btnPeoples.setOnClickListener(this);
        btnFunny.setOnClickListener(this);
        btnMotivation.setOnClickListener(this);
        btnLove.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CategoryAphorisms.this, List_Aphorisms.class);
        switch (v.getId()){
            case R.id.life:
                intent.putExtra(List_Aphorisms.EXTRA_PARAM_AFORIZM_GROUP, "life");
                startActivity(intent);
                break;
            case R.id.friends:
                    intent.putExtra(List_Aphorisms.EXTRA_PARAM_AFORIZM_GROUP, "friends");
                    startActivity(intent);
                break;
            case R.id.peoples:
                    intent.putExtra(List_Aphorisms.EXTRA_PARAM_AFORIZM_GROUP, "people");
                    startActivity(intent);
            break;
            case R.id.funny:
                    intent.putExtra(List_Aphorisms.EXTRA_PARAM_AFORIZM_GROUP, "funny");
                    startActivity(intent);
            break;
            case R.id.motivation:
                    intent.putExtra(List_Aphorisms.EXTRA_PARAM_AFORIZM_GROUP, "motivation");
                    startActivity(intent);
            break;
            case R.id.love:
                    intent.putExtra(List_Aphorisms.EXTRA_PARAM_AFORIZM_GROUP, "love");
                    startActivity(intent);
                break;
        }
    }
}
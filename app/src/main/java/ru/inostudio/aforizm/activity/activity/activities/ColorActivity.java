package ru.inostudio.aforizm.activity.activity.activities;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.inostudio.aforizm.R;
import ru.inostudio.aforizm.activity.activity.adapter.ColorAdapter;
import ru.inostudio.aforizm.activity.activity.adapter.OnClickListener;

/**
 * Created by Admin on 17.05.2016.
 */
public class ColorActivity extends AppCompatActivity {
    private LinearLayout mainLayout;
    private ListView colorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background);
        colorsList = (ListView) findViewById(R.id.colors_list);

        TypedArray colors = getResources().obtainTypedArray(R.array.colors);
        List<Integer> colorsArray = new ArrayList<>();
        for (int i = 0; i < colors.length(); i++) {
            colorsArray.add(colors.getInteger(i, 0));
        }
        ColorAdapter colorAdapter = new ColorAdapter(this, R.layout.row_color, colorsArray);
        colorAdapter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(Integer position) {
                PreferenceManager.getDefaultSharedPreferences(ColorActivity.this)
                        .edit()
                        .putInt("my_color", position)
                        .commit();

                onBackPressed();
            }
        });
        colorsList.setAdapter(colorAdapter);

    }
}

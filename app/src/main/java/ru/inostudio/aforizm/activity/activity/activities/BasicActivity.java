package ru.inostudio.aforizm.activity.activity.activities;

import android.content.res.TypedArray;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.inostudio.aforizm.R;

/**
 * Created by Admin on 17.05.2016.
 */
public class BasicActivity extends AppCompatActivity {
    protected ViewGroup rootLayout;
    @Override
    protected void onResume() {
        super.onResume();
        TypedArray colors = getResources().obtainTypedArray(R.array.colors);
        int colorPosition = PreferenceManager.getDefaultSharedPreferences(BasicActivity.this)
                .getInt("my_color", 0);
        rootLayout.setBackgroundColor(colors.getColor(colorPosition, 0));
    }
}

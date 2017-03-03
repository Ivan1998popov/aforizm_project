package ru.inostudio.aforizm.activity.activity.activities;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import ru.inostudio.aforizm.R;
import ru.inostudio.aforizm.activity.activity.adapter.AlarmReciever;

/**
 * Created by Admin on 17.05.2016.
 */
public class AlarmActivity extends BasicActivity {

    private Button setAlarmDialog;
    private TextView alarmInfoText;
    public  EditText editText;

    private TimePickerDialog timePickerDialog;
    private String mAforizm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity);
        rootLayout = (ViewGroup) findViewById(R.id.alarm_activity);
        alarmInfoText = (TextView) findViewById(R.id.alarm_prompt);
        setAlarmDialog = (Button) findViewById(R.id.start_alarm_button);
       // editText = (EditText) findViewById(R.id.text1234);
        mAforizm = getIntent().getStringExtra(Aphorism.AFORIZM);

        setAlarmDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmInfoText.setText("");
                openTimePickerDialog();

            }
        });
    }

    private void openTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(AlarmActivity.this,
                onTimeSetlistener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), true);
        timePickerDialog.setTitle("Будильник установлен на ");
        timePickerDialog.show();

    }

    private TimePickerDialog.OnTimeSetListener onTimeSetlistener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar calendarNow = Calendar.getInstance();
            Calendar calendarClone = (Calendar) calendarNow.clone();

            calendarClone.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calendarClone.set(Calendar.MINUTE, minute);
            calendarClone.set(Calendar.SECOND, 0);
            calendarClone.set(Calendar.MILLISECOND, 0);

            if (calendarClone.compareTo(calendarNow) <= 0) {
                calendarClone.add(Calendar.DATE, 1);
            }
            setAlarm(calendarClone);
        }
    };

    private final Integer REQUEST_CODE =1234;
    private void setAlarm(Calendar calendar) {
        Intent intent = new Intent(getBaseContext(), AlarmReciever.class);
//        if(mAforizm == null) {
//            String my = editText.getText().toString();
//            intent.putExtra(Aphorism.AFORIZM, my);
//        }else
        intent.putExtra(Aphorism.AFORIZM, mAforizm);


        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), REQUEST_CODE, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        alarmInfoText.setText("\n\n***\n" + "Будильник установлен на  " + calendar.getTime() + "\n" + "***\n");
    }
}



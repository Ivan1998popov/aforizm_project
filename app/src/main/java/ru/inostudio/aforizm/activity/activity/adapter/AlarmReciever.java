package ru.inostudio.aforizm.activity.activity.adapter;

        import android.app.NotificationManager;
        import android.app.PendingIntent;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.support.v4.app.NotificationCompat;
        import android.widget.Toast;
        import ru.inostudio.aforizm.R;
        import ru.inostudio.aforizm.activity.activity.activities.Aphorism;



/**
 * Created by Kirill on 16.05.2016.
 */
public class AlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isDoNotDisturb = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("1234", false);
        if (!isDoNotDisturb) {


            String aforizm = intent.getExtras().getString(Aphorism.AFORIZM);
            Uri sound = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.my_music);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Афоризм :)")
                    .setContentText(aforizm)
                    .setSound(sound);

            Bundle bundle = new Bundle();
            bundle.putString("my_aforizm",aforizm);

            intent = new Intent(context, Aphorism.class);
            Toast.makeText(context,aforizm , Toast.LENGTH_LONG).show();
            intent.putExtras(bundle);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager)
                    context.getSystemService(context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());
        }
    }
}

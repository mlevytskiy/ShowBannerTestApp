package showbanner.mlevytskiy.com.showbannertestapp.core;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.*;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import showbanner.mlevytskiy.com.showbannertestapp.MainActivity;
import showbanner.mlevytskiy.com.showbannertestapp.R;

/**
 * Created by max on 03.08.15.
 */
public abstract class SurvivableForegroundService extends Service {

    private static final int NOTIFICATION_ID = 524;
    private static final int REQUEST_CODE = 321;

    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(NOTIFICATION_ID, getCompatNotification());
        doCommand();
        return START_STICKY;
    }

    protected abstract void doCommand();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private Notification getCompatNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis());

        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(this,
                REQUEST_CODE, mainActivity, 0);

        builder.setContentIntent(contentIntent);

        return builder.build();
    }
}

package showbanner.mlevytskiy.com.showbannertestapp;

import android.content.*;

import showbanner.mlevytskiy.com.showbannertestapp.core.SurvivableForegroundService;

/**
 * Created by max on 03.08.15.
 */
public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startIntent = new Intent(context, ImplSFService.class);
        context.startService(startIntent);
    }

}

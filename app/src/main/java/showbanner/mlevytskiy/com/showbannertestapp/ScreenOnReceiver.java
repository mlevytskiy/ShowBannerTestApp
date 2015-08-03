package showbanner.mlevytskiy.com.showbannertestapp;

import android.content.*;
import android.os.Handler;

import java.util.concurrent.TimeUnit;

/**
 * Created by max on 03.08.15.
 */
public class ScreenOnReceiver extends BroadcastReceiver {

    private final static int DELAY_AFTER_SCREEN_ON = 1;
    private final static int DELAY_WHEN_OUR_APP_ACTIVE = 5;
    private Handler handler = new Handler();

    @Override
    public void onReceive(final Context context, Intent intent) {
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showBanner(context);
            }
        }, TimeUnit.MINUTES.toMillis(DELAY_AFTER_SCREEN_ON));
    }

    private void showBanner(final Context context) {
        if (App.instance.isActive) {
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showBanner(context);
                }
            }, TimeUnit.MINUTES.toMillis(DELAY_WHEN_OUR_APP_ACTIVE));
        } else {
            ShowBannerDailyLimitChecker limitChecker = new ShowBannerDailyLimitChecker(context);
            if (limitChecker.canShow()) {
                limitChecker.incrementTimesCount();
                Intent intent = new Intent(context, BannerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            } else {
                //doNothing
            }

        }
    }

    public Intent registration(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        return context.registerReceiver(this, intentFilter);
    }

    public static class Builder {

        private Context context;
        private static ScreenOnReceiver lastInstance = null;

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public ScreenOnReceiver build() {
            if (lastInstance != null) {
                context.unregisterReceiver(lastInstance);
            }
            lastInstance = new ScreenOnReceiver();
            return lastInstance;
        }
    }

}

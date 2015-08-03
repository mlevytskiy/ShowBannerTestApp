package showbanner.mlevytskiy.com.showbannertestapp;

import android.content.*;
import android.os.Handler;

/**
 * Created by max on 03.08.15.
 */
public class ScreenOnReceiver extends BroadcastReceiver {

    private final static int DELAY = 1000;

    @Override
    public void onReceive(final Context context, Intent intent) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showBanner(context);
            }
        }, DELAY);
    }

    private void showBanner(Context context) {
        if (App.instance.isActive) {

        } else {
            Intent intent = new Intent(context, BannerActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
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

package showbanner.mlevytskiy.com.showbannertestapp;

import java.util.TimerTask;

/**
 * Created by max on 03.08.15.
 */
public class ResetDailyLimitTimerTask extends TimerTask {

    @Override
    public void run() {
        new ShowBannerDailyLimitChecker(App.instance).reset();
    }

}

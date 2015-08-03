package showbanner.mlevytskiy.com.showbannertestapp;

import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import showbanner.mlevytskiy.com.showbannertestapp.core.SurvivableForegroundService;

/**
 * Created by max on 03.08.15.
 */
public class ImplSFService extends SurvivableForegroundService {

    private ResetDailyLimitTimerTask timerTask = null;

    @Override
    protected void doCommand() {
        ScreenOnReceiver screenOnReceiver = new ScreenOnReceiver.Builder().context(getApplicationContext()).build();
        screenOnReceiver.registration(getApplicationContext());

        if (timerTask == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.add(Calendar.DATE, 1);
            timerTask = new ResetDailyLimitTimerTask();
            new Timer().schedule(timerTask, Calendar.getInstance().getTime(),
                    TimeUnit.DAYS.toMillis(1));
        }

    }

}

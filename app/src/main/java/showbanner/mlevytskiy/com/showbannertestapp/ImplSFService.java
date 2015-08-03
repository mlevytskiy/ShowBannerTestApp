package showbanner.mlevytskiy.com.showbannertestapp;

import showbanner.mlevytskiy.com.showbannertestapp.core.SurvivableForegroundService;

/**
 * Created by max on 03.08.15.
 */
public class ImplSFService extends SurvivableForegroundService {

    @Override
    protected void doCommand() {
        ScreenOnReceiver screenOnReceiver = new ScreenOnReceiver.Builder().context(getApplicationContext()).build();
        screenOnReceiver.registration(getApplicationContext());
    }

}

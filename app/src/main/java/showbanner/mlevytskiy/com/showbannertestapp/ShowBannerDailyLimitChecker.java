package showbanner.mlevytskiy.com.showbannertestapp;

import android.content.*;

import showbanner.mlevytskiy.com.showbannertestapp.memory.MemoryCommunicator;

/**
 * Created by max on 03.08.15.
 */
public class ShowBannerDailyLimitChecker {

    private static final int LIMIT = 3;
    private MemoryCommunicator memory;

    public ShowBannerDailyLimitChecker(Context context) {
        memory = new MemoryCommunicator(context);
    }

    public void incrementTimesCount() {
        int count = memory.getShowBannerTimesCount() + 1;
        memory.setShowBannerTimesCount(count);
    }

    public boolean canShow() {
        return memory.getShowBannerTimesCount() <= LIMIT;
    }

    public void reset() {
        memory.setShowBannerTimesCount(0);
    }
}

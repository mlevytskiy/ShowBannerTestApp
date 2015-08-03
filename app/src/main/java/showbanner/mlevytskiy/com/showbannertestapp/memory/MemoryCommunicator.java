package showbanner.mlevytskiy.com.showbannertestapp.memory;

import android.content.*;
import android.preference.PreferenceManager;

/**
 * Created by max on 03.08.15.
 */
public class MemoryCommunicator {

    private SharedPreferences sharedPreferences;
    private static final String TIME_COUNT = "timeCount";

    public MemoryCommunicator(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setShowBannerTimesCount(int value) {
        sharedPreferences.edit().putInt(TIME_COUNT, value).commit();
    }

    public int getShowBannerTimesCount() {
        return sharedPreferences.getInt(TIME_COUNT, 0);
    }

}

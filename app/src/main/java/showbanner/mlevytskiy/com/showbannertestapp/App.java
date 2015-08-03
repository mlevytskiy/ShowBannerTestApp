package showbanner.mlevytskiy.com.showbannertestapp;

import android.app.Application;

/**
 * Created by max on 03.08.15.
 */
public class App extends Application {

    public static App instance;
    public boolean isActive;

    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}

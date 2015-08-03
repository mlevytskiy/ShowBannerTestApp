package showbanner.mlevytskiy.com.showbannertestapp.core;

import android.app.Activity;
import android.view.View;

import showbanner.mlevytskiy.com.showbannertestapp.App;

/**
 * Created by max on 03.08.15.
 */
public class AnyActivity extends Activity {

    public void onStart() {
        getApp().isActive = true;
        super.onStart();
    }

    public void onStop() {
        super.onStop();
        getApp().isActive = false;
    }

    public void onClickClose(View view) {
        this.finish();
    }

    private App getApp() {
        return (App) this.getApplication();
    }
}

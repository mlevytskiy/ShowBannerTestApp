package showbanner.mlevytskiy.com.showbannertestapp;

import android.content.*;
import android.os.Bundle;

import showbanner.mlevytskiy.com.showbannertestapp.core.AnyActivity;


public class MainActivity extends AnyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent startIntent = new Intent(getApplicationContext(), ImplSFService.class);
        startService(startIntent);
    }
}

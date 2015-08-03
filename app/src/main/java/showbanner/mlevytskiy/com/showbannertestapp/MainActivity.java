package showbanner.mlevytskiy.com.showbannertestapp;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import showbanner.mlevytskiy.com.showbannertestapp.core.AnyActivity;
import showbanner.mlevytskiy.com.showbannertestapp.memory.MemoryCommunicator;

public class MainActivity extends AnyActivity {

    private TextView textView;
    private MemoryCommunicator memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent startIntent = new Intent(getApplicationContext(), ImplSFService.class);
        startService(startIntent);

    }

    public void onStart() {
        super.onStart();
        textView = (TextView) findViewById(R.id.text_view);
        memory = new MemoryCommunicator(getApplicationContext());
        textView.setText(String.valueOf(memory.getShowBannerTimesCount()));
    }

    public void onClickReset(View view) {
        textView.setText(String.valueOf(0));
        memory.setShowBannerTimesCount(0);
    }

}

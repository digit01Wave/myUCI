package com.example.jessica.myuci;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.Map;

import io.krumbs.sdk.KrumbsSDK;
import io.krumbs.sdk.krumbscapture.KCaptureCompleteListener;

public class NavigatorActivity extends BaseActivity {
    private View cameraView;
    private View startCaptureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(FeedReaderContract.UserInfo.USER_ID == null){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        Log.d("Krumbs", "load current image");
        new RetrieveImageLinkTask(getApplicationContext()).execute();


    }


    public void goEventListActivity(View view){
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }

    public void goCalendarActivity(View view){
        Intent intent = new Intent(this, PersonalListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("table_name", FeedReaderContract.CalendarEntry.TABLE_NAME);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goKrumbsActivity(View view){
        Intent intent = new Intent(this, KrumbsActivity.class);
        startActivity(intent);
    }

    public void goWatchLaterListActivity(View view){
        Intent intent = new Intent(this, PersonalListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("table_name", FeedReaderContract.WLEntry.TABLE_NAME);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToCurrentListActivity(View view){
        Intent intent = new Intent(this, CurrentEventsActivity.class);
        startActivity(intent);
    }


}

package com.g7.gibaa007.g.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.g7.gibaa007.g.utils.AppConfig;
import com.g7.gibaa007.g.utils.CommonActions;

/**
 * Created by newagesmb on 19/7/16.
 */
public class BaseMainActivity extends AppCompatActivity {

    public static boolean locked = false;
    public static Activity mActivity;
    //    LocalBroadcastManager mLocalBroadcastManager;
//    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent.getAction().equals("logout")) {
//                Intent i = new Intent(
//                        BaseMainActivity.this,
//                        LoginActivity.class);
//                startActivity(i);
//                finish();
//            } else if (intent.getAction().equals("check_push_notification")) {
//                Intent i = new Intent(
//                        BaseMainActivity.this,
//                        ShowPopUp.class);
//                i.putExtra("message", intent.getStringExtra("message").toString());
//                startActivity(i);
//            }
//        }
//    };
    private SharedPreferences prefs;
    private String password;
    //    private IntentFilter mIntentFilter;
    private Handler handler;
    private Runnable r;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        prefs = getSharedPreferences(AppConfig.SHARED_VALUE,
                Context.MODE_PRIVATE);
//        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
//        mIntentFilter = new IntentFilter();
//        mIntentFilter.addAction("logout");
//        mIntentFilter.addAction("check_push_notification");
        super.onCreate(savedInstanceState);
        handler = new Handler();
        r = new Runnable() {

            @Override
            public void run() {
                BaseMainActivity.locked = true;
                if (mActivity != null) {
//                   BaseMainActivity.locked = true;
//                    typeWriterDialog = new TypeWriterDialog(BaseMainActivity.this);
//                    typeWriterDialog.show();

                    new CommonActions(BaseMainActivity.this).showToast("Locking Down G7");
                }
            }
        };
        startHandler();
    }

    @Override
    public void onUserInteraction() {
        // TODO Auto-generated method stub
        super.onUserInteraction();
        stopHandler();//stop first and then start
        startHandler();
    }

    public void stopHandler() {
        handler.removeCallbacks(r);
    }

    public void startHandler() {
//        handler.postDelayed(r, 1800000);
        handler.postDelayed(r, 10000);
    }

    @Override
    protected void onResume() {
        if (locked) {
//            Intent lockScreen = new Intent(this, LockActivity.class);
//            startActivity(lockScreen);

            new CommonActions(BaseMainActivity.this).showToast("Locking Down");
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        mActivity = null;
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        locked = false;
        super.onDestroy();
    }

}

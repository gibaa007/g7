package com.g7.gibaa007.g.activity;

import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.g7.gibaa007.g.R;
import com.g7.gibaa007.g.customViews.VerticalTextView;
import com.g7.gibaa007.g.dialog.TypeWriterDialog;
import com.g7.gibaa007.g.encryption.EncryptionActivity;
import com.g7.gibaa007.g.utils.CommonActions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseMainActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    CommonActions commonActions;
    FloatingActionButton fab;
    FloatingActionButton fab1;
    FloatingActionButton fab2;
    FloatingActionButton fab3;
    //Animations
    Animation show_fab_1;
    Animation hide_fab_1;
    Animation show_fab_2;
    Animation hide_fab_2;
    Animation show_fab_3;
    Animation hide_fab_3;
    //Save the FAB's active status
    //false -> fab = close
    //true -> fab = open
    private boolean FAB_Status = false;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private VerticalTextView tv_vertical;
    private TextView tv_github;
    private String seed;
    private TypeWriterDialog typeWriterDialog;
    private String userChoosenTask;
    private int SELECT_FILE, REQUEST_CAMERA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        initialise();
        settingValues();
        settingListeners();
        super.onCreate(savedInstanceState);
    }


    private void initialise() {
        seed = "";
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        commonActions = new CommonActions(getApplication());
        fab = (FloatingActionButton) findViewById(R.id.fab);
        tv_vertical = (VerticalTextView) findViewById(R.id.tv_vertical);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        tv_github = (TextView) findViewById(R.id.tv_github);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab_1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab_2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab_3);
    }

    private void settingValues() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        tv_vertical.setText("Pull For Drawer");
        tv_vertical.setTextColor(Color.parseColor("#FF0000"));
        //Animations
        show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
        show_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        hide_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
        show_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        hide_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);


        //Initialize an empty list of 50 elements
        List list = new ArrayList();
        for (int i = 0; i < 50; i++) {
            list.add(new Object());
        }


    }

    private void settingListeners() {
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        tv_github.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            seed = "";
            Intent encryption = new Intent(this,
                    ImageBlurActivity.class);
            startActivity(encryption);
        } else if (id == R.id.nav_slideshow) {
            seed = "";
            commonActions.snackBarSuccess(drawer, "SlideShow");
        } else if (id == R.id.nav_manage) {
            seed = "";
            commonActions.snackBarSuccess(drawer, "manage");
        } else if (id == R.id.nav_gp) {
            seed = "";
            commonActions.snackBarFailure(drawer, "gp");
        } else if (id == R.id.nav_fb) {
            seed = "";
            Intent encryption = new Intent(this,
                    TypeWritingActivity.class);
            startActivity(encryption);
        } else if (id == R.id.nav_ig) {
            if (seed.equals("g"))
                seed = "g7";
            Intent encryption = new Intent(this,
                    EncryptionActivity.class);
            startActivity(encryption);
        } else if (id == R.id.nav_call) {
            seed = "";

            Intent encryption = new Intent(this,
                    FlashLightActivity.class);
            startActivity(encryption);
        } else if (id == R.id.gradientText) {
            seed = "";
            Intent gradientTextActivity = new Intent(this,
                    GradientTextActivity.class);
            startActivity(gradientTextActivity);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(Gravity.RIGHT);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.fab) {
            if (seed.equals("g7")) {
                seed = "";
                typeWriterDialog = new TypeWriterDialog(this);
                typeWriterDialog.show();
            } else {
                seed = "";
                expandFAB();
            }
        }
        if (id == R.id.fab_1) {
            hideFAB();
            new CommonActions(this).snackBarSuccessTop(toolbar, "Top");
        }
        if (id == R.id.fab_2) {

            hideFAB();
            commonActions.snackBarCustom(toolbar,"custom",getApplicationContext());

        }
        if (id == R.id.fab_3) {
            new CommonActions(this).snackBarSuccessTop(toolbar, "Top");
            hideFAB();

        }
        if (id == R.id.tv_github) {
            seed = "g";
            commonActions.customWebView("GitHub", "https://github.com/gibaa007", this);
            drawer.closeDrawer(Gravity.RIGHT);
        }


    }

    private void expandFAB() {

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParams.rightMargin += (int) (fab1.getWidth() * 1.7);
        layoutParams.bottomMargin += (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParams);
        fab1.startAnimation(show_fab_1);
        fab1.setClickable(true);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParams2.rightMargin += (int) (fab2.getWidth() * 1.5);
        layoutParams2.bottomMargin += (int) (fab2.getHeight() * 1.5);
        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(show_fab_2);
        fab2.setClickable(true);

        //Floating Action Button 3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
        layoutParams3.rightMargin += (int) (fab3.getWidth() * 0.25);
        layoutParams3.bottomMargin += (int) (fab3.getHeight() * 1.7);
        fab3.setLayoutParams(layoutParams3);
        fab3.startAnimation(show_fab_3);
        fab3.setClickable(true);
    }


    private void hideFAB() {

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParams.rightMargin -= (int) (fab1.getWidth() * 1.7);
        layoutParams.bottomMargin -= (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParams);
        fab1.startAnimation(hide_fab_1);
        fab1.setClickable(false);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParams2.rightMargin -= (int) (fab2.getWidth() * 1.5);
        layoutParams2.bottomMargin -= (int) (fab2.getHeight() * 1.5);
        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(hide_fab_2);
        fab2.setClickable(false);

        //Floating Action Button 3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
        layoutParams3.rightMargin -= (int) (fab3.getWidth() * 0.25);
        layoutParams3.bottomMargin -= (int) (fab3.getHeight() * 1.7);
        fab3.setLayoutParams(layoutParams3);
        fab3.startAnimation(hide_fab_3);
        fab3.setClickable(false);
    }

    private void selectImage() {
        final CharSequence[] items = {"Turn On Bluetooth", "Visible for 120 sec",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Bluetooth!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = commonActions.checkPermissionReadExternal(MainActivity.this);
                if (items[item].equals("Turn On Bluetooth")) {
                    userChoosenTask = "Turn On Bluetooth";
                    if (result) {
//                        Intent enableIntent = new Intent(
//                                BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                        startActivityForResult(enableIntent, REQUEST_BLUETOOTH);
                    }
                } else if (items[item].equals("Visible for 120 sec")) {
                    userChoosenTask = "Visible for 120 sec";
                    if (result) {
                        Intent discoverableIntent = new Intent(
                                BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                        discoverableIntent.putExtra(
                                BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 120);
                        startActivity(discoverableIntent);

                    }
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
}

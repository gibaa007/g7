package com.g7.gibaa007.g.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.g7.gibaa007.g.R;
import com.g7.gibaa007.g.encryption.EncryptionActivity;

/**
 * Created by newagesmb on 22/7/16.
 */
public class TypeWriterDialog extends Dialog implements View.OnClickListener {

    public Activity activity;
    private ImageView iv_close_popup;

    public TypeWriterDialog(Activity activity) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_lock);
        iv_close_popup = (ImageView) findViewById(R.id.iv_close_popup);
        iv_close_popup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close_popup:
                Intent encryption = new Intent(activity,
                        EncryptionActivity.class);
                activity.startActivity(encryption);
                dismiss();
                break;
        }
    }
}
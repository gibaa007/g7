package com.g7.gibaa007.g.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.g7.gibaa007.g.serverconnection.AsyncCallBack;
import com.g7.gibaa007.g.serverconnection.HttpConnection;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;

import org.json.JSONObject;

/**
 * Created by gibaa007 on 2/11/2016.
 */
public class WebServices {

    static String user_id = "";
    static String access_token = "";
    static String mem_type = "";
    static String timezone = "";
    Context con;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public WebServices(Context context) {
        con = context;
        prefs = con.getSharedPreferences(AppConfig.SHARED_VALUE, con.MODE_PRIVATE);
        editor = prefs.edit();
        user_id = prefs.getString(AppConfig.USER_ID, "");
        access_token = prefs.getString(AppConfig.USER_ACCESS_TOKEN, "");
        mem_type = prefs.getString(AppConfig.USER_MEM_TYPE, "");
        timezone = prefs.getString(AppConfig.USER_TIME_ZONE, "");
    }


    /**
     * Api for registration
     *
     * @param con
     * @param callbackInterface
     * @param serviceCode
     * @param email
     * @param password
     * @param first_name
     * @param last_name
     * @param timezone
     */
    public static void register(Activity con,
                                AsyncCallBack callbackInterface, int serviceCode, String email,
                                String password, String first_name, String last_name, String timezone, String gcm_id, String state) {
        RequestBody requestBody = new MultipartBuilder()
                .type(MultipartBuilder.FORM)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .addFormDataPart("first_name", first_name)
                .addFormDataPart("last_name", last_name)
                .addFormDataPart("latitude", timezone)
                .addFormDataPart("gcm_id", gcm_id)
                .addFormDataPart("longitude", state)

                .build();
        new HttpConnection(con, callbackInterface, serviceCode,
                AppConfig.APP_URL + "/register", requestBody, null, AppConfig.POST_WITH_DATA);
    }

    /**
     * api for login
     *
     * @param con
     * @param callbackInterface
     * @param serviceCode
     * @param email
     * @param password
     * @param gcm_id
     */
    public static void login(Activity con,
                             AsyncCallBack callbackInterface,
                             int serviceCode, String email, String password, String gcm_id, String latitude, String longitude) {
        JSONObject jsonMain = new JSONObject();
        try {
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("email", email);

            jsonParams.put("password", password);
            jsonParams.put("platform", "ANDROID");
            jsonParams.put("latitude", latitude);
            jsonParams.put("longitude", longitude);
            jsonParams.put("gcm_id", gcm_id);
            jsonMain.put("function", "login");
            jsonMain.put("parameters", jsonParams);
            jsonMain.put("token", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("Login", jsonMain.toString());

        new HttpConnection(con, callbackInterface, serviceCode,
                AppConfig.APP_URL, null, jsonMain, AppConfig.POST_WITH_JSON);

    }

}
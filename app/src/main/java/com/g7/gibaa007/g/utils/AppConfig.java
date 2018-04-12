//  Created by Livin Lawrence on 14/09/2015.
//  Copyright (c) 2015 NewageSmb. All rights reserved.
package com.g7.gibaa007.g.utils;

/**
 * Created by gibaa007 on 12/7/16.
 */


public class AppConfig {

    public static final String INTENTDATA="_data";
    //LOCAL URLS
    //public static final String APP_URL = "http://192.168.1.254/welivate_new/client";

    // STAGING URLS
    public static final String BASE_URL = "http://newagesme.com/welivate_new/";
    public static final String APP_URL = "http://newagesme.com/welivate_new/client";
    public static final String PRIVACY_URL = "http://newagesme.com/welivate_new/legal?device=app";
    public static final String TERMS_URL = "http://newagesme.com/welivate_new/tac?device=app";


    // LIVE URLS
    //public static final String APP_URL = "";
    //PERMISSION CONSTANTS
    public final static int MY_PERMISSIONS_REQUEST_CAMERA = 80;
    public final static int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 81;
    public static final int REQUEST_CODE_GALLERY = 0x1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 0x2;
    public static final int REQUEST_CODE_CROP_IMAGE = 0x3;
    //GCM CONSTANTS
    public static final String PROPERTY_REG_ID = "registration_id";
    public static final String PROPERTY_APP_VERSION = "appVersion";
    public static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    //Splash
    public final static int SPLASH_TIME_OUT = 5000;
    //INTENT CONSTANTS
    public final static String WHICH_URL = "which_url";
    // *** Fill the following variables using your own Project info from the OpenTok dashboard  ***
    // ***                      https://dashboard.tokbox.com/projects                           ***
    // Replace with a generated Session ID
    public static final String SESSION_ID = "tokbox_session_id";
    // Replace with a generated token (from the dashboard or using an OpenTok server SDK)
    public static final String TOKEN = "tokbox_token";
    // Replace with your OpenTok API key
    public static final String API_KEY = "tokbox_api_key";
    // Subscribe to a stream published by this client. Set to false to subscribe
    // to other clients' streams only.
    public static final boolean SUBSCRIBE_TO_SELF = false;
    // For internal use only. Please do not modify or remove this code.
    public static final String LOGGING_BASE_URL = "https://hlg.tokbox.com/prod/logging/ClientEvent";
    public static final String LOG_ACTION = "one-to-one-sample-app";
    public static final String LOG_VARIATION = "";
    public static final String LOG_CLIENT_VERSION = "android-vsol-1.0.0";
    //SHARED PREFERENCE
    public static String SHARED_VALUE = "welivate_preferences";
    // USER CREDENTIALS
    //API CONSTANTS
    public static int GET = 0;
    public static int POST_WITH_DATA = 1;//Files
    public static int POST_WITH_JSON = 2;//JSON

    public static String TEMP_PROFILE_PHOTO_FILE_NAME = "temp_profile_photo.jpg";
//    public static String GOOGLE_GCM_SENDER_ID = "422809697938";
    public static String GOOGLE_GCM_SENDER_ID = "743794562567";
    //USER
    public static String USER_ID = "user_id";
    public static String USER_NAME = "user_name";
    public static String USER_ACCESS_TOKEN = "user_acess_token";
    public static String USER_SESSION_STATUS = "session_status";
    public static String USER_EMAIL = "user_email";
    public static String USER_PASSWORD = "password";
    public static String USER_REMBER = "user_remember_login";
    public static String USER_FULL_NAME = "user_full_name";
    public static String USER_PROFILE_PIC = "user_image";
    public static String USER_MEM_TYPE = "user_mem_type";
    public static String USER_TIME_ZONE = "user_time_zone";
    public static String LOGIN_TIME = "login_time";
    //Webservice status
    public static int FAIL = 0;
    public static int SUCCESS = 1;
    public static int FAILURE_INTERNET = 2;
    public static int SESSION_EXPIRED = 3;
    public static int FAILURE_OTHER = 4;
    //WEB SERVICE METHOD CONSTANTS
    public static int LOGIN = 100;
    public static int REGISTER = 101;
    //IMAGE CHANGE
    public static int NO_CHANGE = 0;
    public static int DEFAULT_PIC_ADDED = 1;
    public static int NEW_PIC_ADDED = 2;
    //APPOINTMENTS STATUS
    public static String ACCEPTED = "accepted";
    public static String NOT_COMPLETED = "not_completed";
    public static String COMPLETED = "completed";
    //Call
    public static final String CALLACCEPTED="_call_acepted";
    public static final String CALLREJECTED="_call_rejected";
    public static final String CALLMISSED="_call_missed";

}

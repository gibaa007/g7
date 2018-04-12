package com.g7.gibaa007.g.serverconnection;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by livin on 10/2/2015.
 */
public class OkHTTPPost {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

   /**
    * Simple post method with json data
    * @param url
    * @param json
    * @return
    * @throws IOException
    */
    public String run(String url, String json) throws IOException {
        Log.e("url",url);
        Log.e("TO SERVER",json);
        client.setConnectTimeout(30, TimeUnit.SECONDS);
        client.setReadTimeout(30, TimeUnit.SECONDS);
        client.setWriteTimeout(30, TimeUnit.SECONDS);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


   /**
    * POST method with data(FILES)
    * @param url
    * @param requestBody
    * @return
    * @throws Exception
    */
    public String run(String url, RequestBody requestBody) throws Exception {
       Log.e("url",url);
        client.setConnectTimeout(30, TimeUnit.SECONDS);
        client.setReadTimeout(30, TimeUnit.SECONDS);
        client.setWriteTimeout(30, TimeUnit.SECONDS);
        Request request = new Request.Builder()
               /* .header("Accept-Encoding", "gzip")*/
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
           return response.body().string();
    }
}

package com.example.omniguardai;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostUtil extends AsyncTask<Void, Void, Void> {
    public static String result;

    private static final String TAG = "HttpPostUtil";

    private String url;
    private JSONObject json;

    public HttpPostUtil(String url, JSONObject json) {
        this.url = url;
        this.json = json;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            result = "";
            URL url = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(json.toString().getBytes());
            outputStream.flush();

            int responseCode = conn.getResponseCode();
            Log.d(TAG, "Response Code: " + responseCode);

            StringBuffer resultb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
// 每次读取一行
            String line;
            while ((line = br.readLine()) != null) {
                resultb.append(line);
            }
            System.out.println(resultb);
            result = resultb.toString();

            conn.disconnect();
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }

        return null;
    }
}
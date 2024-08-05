package com.example.omniguardai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.tag.InitiateMultipartUpload;
import com.tencent.cos.xml.transfer.COSXMLDownloadTask;
import com.tencent.cos.xml.transfer.COSXMLUploadTask;
import com.tencent.cos.xml.transfer.InitMultipleUploadListener;
import com.tencent.cos.xml.transfer.TransferConfig;
import com.tencent.cos.xml.transfer.TransferManager;
import com.tencent.cos.xml.transfer.TransferState;
import com.tencent.cos.xml.transfer.TransferStateListener;
import com.tencent.qcloud.core.auth.SessionQCloudCredentials;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "http://platform.blue16.cn:8090/api/v1/detector/risk/text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MsgButton msgButton1 = findViewById(R.id.msgButton1);
        msgButton1.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
        MsgButton msgButton2 = findViewById(R.id.msgButton2);
        msgButton2.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, MainActivity4.class);
            startActivity(intent);
        });
        TextView tv = findViewById(R.id.textView4);
        tv.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, SetupActivity.class);
            startActivity(intent);
        });
        TextView tv2 = findViewById(R.id.tvMsgIntercept);
        tv2.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, MsgInterceptActivity.class);
            startActivity(intent);
        });
        ImageView imr = findViewById(R.id.image_right);
        imr.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, MsgInterceptActivity.class);
            startActivity(intent);
        });
        TextView tv3 = findViewById(R.id.tvCallIntercept);
        tv3.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, CallInterceptActivity.class);
            startActivity(intent);
        });
        ImageView imr2 = findViewById(R.id.image_right2);
        imr2.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, CallInterceptActivity.class);
            startActivity(intent);
        });
        TextView tv4 = findViewById(R.id.tvTakeOver);
        tv4.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, TakeOverActivity.class);
            startActivity(intent);
        });
        ImageView imr3 = findViewById(R.id.image_right3);
        imr3.setOnClickListener(e -> {
            Intent intent = new Intent(MainActivity.this, TakeOverActivity.class);
            startActivity(intent);
        });

//        {
//            "multimodal": ["关注学生心理健康，指导教师识别和应对学生常见心理问题和心理危机，引导教师通过共情等方式建立良好的师生关系、在教学中渗透学生积极心态建设，提升教师心理健康教育能力；"],
//            "phoneNum": "13800138000",
//                "date": "2023-12-25",
//                "province": "广东省",
//                "area": "深圳市"
//        }

        JSONObject json = new JSONObject();
//        List<String> multimodal = new ArrayList<>();
//        multimodal.add("关注学生心理健康");
        try {
            json.put("content", "【枪决通知】因您信贷诈骗，缺席出庭，已通过天网定位具体位置，已通知当地政");
            json.put("phoneNum", "13800138000");
            json.put("date", "2023-12-25");
            json.put("province", "广东省");
            json.put("area", "深圳市");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(json.toString());

        new HttpPostUtil(URL, json).execute();

    }
}
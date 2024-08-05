package com.example.omniguardai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tv_level = findViewById(R.id.tv_level);
        TextView tv_suggest = findViewById(R.id.tv_suggest);
        TextView tv_explain = findViewById(R.id.tv_explain);
//        Button bt = findViewById(R.id.bt_refresh);
//        bt.setOnClickListener(e -> {
//            String result = HttpPostUtil.result;
//            if (result.equals(""))
//                return;
//            int k1 = result.indexOf("riskLevel");
//            int k2 = result.indexOf("riskPercentage");
//            int k3 = result.indexOf("briefSuggestion");
//            int k4 = result.indexOf("comprehensiveAnalysis");
//            int k5 = result.indexOf("adviceList");
//            tv_level.setText("风险等级：" + result.substring(k1 + 12, k2 - 3));
//            tv_suggest.setText("建议：" + result.substring(k3 + 18, k4 - 3));
//            tv_explain.setText("说明：" + result.substring(k4 + 25, k5 - 3));
//
//        });
        Button bt2 = findViewById(R.id.bt_goback);
        bt2.setOnClickListener(e -> {
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView tv_level = findViewById(R.id.tv_level);
        TextView tv_suggest = findViewById(R.id.tv_suggest);
        TextView tv_explain = findViewById(R.id.tv_explain);
        while (HttpPostUtil.result.equals("")) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String result = HttpPostUtil.result;
        int k1 = result.indexOf("riskLevel");
        int k2 = result.indexOf("riskPercentage");
        int k3 = result.indexOf("briefSuggestion");
        int k4 = result.indexOf("comprehensiveAnalysis");
        int k5 = result.indexOf("adviceList");
        tv_level.setText("风险等级：" + result.substring(k1 + 12, k2 - 3));
        tv_suggest.setText("建议：" + result.substring(k3 + 18, k4 - 3));
        tv_explain.setText("说明：" + result.substring(k4 + 25, k5 - 3));
    }
}
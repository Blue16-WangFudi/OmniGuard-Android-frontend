package com.example.omniguardai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MsgInterceptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg_intercept);
        ImageView iv = findViewById(R.id.ivGoBack);
        iv.setOnClickListener(e -> {
            finish();
        });
    }
}
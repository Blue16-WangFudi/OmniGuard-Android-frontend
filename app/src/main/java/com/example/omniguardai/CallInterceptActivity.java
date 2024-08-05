package com.example.omniguardai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class CallInterceptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_intercept);
        ImageView iv = findViewById(R.id.ivGoBack);
        iv.setOnClickListener(e -> {
            finish();
        });
    }
}
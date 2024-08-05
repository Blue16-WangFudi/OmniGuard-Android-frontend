package com.example.omniguardai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        TextView tv = findViewById(R.id.textView2);
        tv.setOnClickListener(e -> {
            finish();
        });
    }
}
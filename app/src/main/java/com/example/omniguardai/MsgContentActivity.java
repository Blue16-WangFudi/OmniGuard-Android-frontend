package com.example.omniguardai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MsgContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg_content);
        ImageView imr3 = findViewById(R.id.img_close);
        imr3.setOnClickListener(e -> {
            finish();
        });
    }
}
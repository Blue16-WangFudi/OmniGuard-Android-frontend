package com.example.omniguardai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TakeOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_over);
        ImageView img = findViewById(R.id.img_take_over);
        img.setOnClickListener(e -> {
            Intent intent = new Intent(TakeOverActivity.this, MsgContentActivity.class);
            startActivity(intent);
        });
        ImageView igb = findViewById(R.id.ivGoBack);
        igb.setOnClickListener(e -> {
            finish();
        });
    }
}
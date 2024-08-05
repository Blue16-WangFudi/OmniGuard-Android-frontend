package com.example.omniguardai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button bt = findViewById(R.id.button2);
        bt.setOnClickListener(e -> {
            if (bt.getText().equals("开始录音"))
                bt.setText("结束录音");
            else {
                bt.setText("开始录音");
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        TextView tv = findViewById(R.id.textView2);
        tv.setOnClickListener(e -> {
            finish();
        });
    }
}
package com.example.omniguardai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    private static final String URL = "http://platform.blue16.cn:8090/api/v1/detector/risk/text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button bt = findViewById(R.id.bt_submit);
        EditText et = findViewById(R.id.et_content);
        bt.setOnClickListener(e -> {
            bt.setEnabled(false);
            JSONObject json = new JSONObject();
            try {
                json.put("content", et.getText());
                json.put("phoneNum", "13800138000");
                json.put("date", "2023-12-25");
                json.put("province", "广东省");
                json.put("area", "深圳市");
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
            new HttpPostUtil(URL, json).execute();
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });
        Button bt1 = findViewById(R.id.bt_exp1);
        bt1.setOnClickListener(e -> {
            et.setText("【枪决通知】 因您信贷诈骗，缺席出庭，已通过‘天网’定位具体位置，现已通知当地执法部门和司法人员（魏军，王琳，郭文祯）携带枪支带队，执行上门强制击毙，详情抖音搜索《执行风暴》或关注‘中国法院网’了解详情，14点前自行app结清全部欠款可撤销执行。");
        });
        Button bt2 = findViewById(R.id.bt_exp2);
        bt2.setOnClickListener(e -> {
            et.setText("【中奖通知】 尊敬的狄先生，您好!恭喜您!您在淘宝网购物时被抽选为《淘宝预618活动》幸运用户。您将获得淘宝网梦想创业基金160000元现金及苹果笔记本电脑一台。请立即登录填写资料领取，您的验证码为【9918】。本次活动已通过浙江省杭州市互联网公证处公证审批请您放心领取。本消息由系统后台自动发出，请勿回复!注:如将个人信息泄露给他人造成冒名领取，本公司概不负责!");
        });
        Button bt3 = findViewById(R.id.bt_exp3);
        bt3.setOnClickListener(e -> {
            et.setText("【到账通知】 支付宝到账一百万元整，请注意查收！");
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button bt = findViewById(R.id.bt_submit);
        bt.setEnabled(true);
    }
}
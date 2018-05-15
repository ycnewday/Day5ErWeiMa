package com.example.lenovo.day6_kaoshi0515;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.day6_kaoshi0515.qrcode.CaptureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView resultTv;
    private Button scanBth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        resultTv = (TextView)findViewById(R.id.resultTv);
        scanBth = (Button)findViewById(R.id.scanBth);
        scanBth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scanBth:
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent,2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2 && resultCode == 1){
             if(data!=null){
                 String stringExtra = data.getStringExtra("data");
                 resultTv.setText("解码结果:"+stringExtra);
               }
        }
    }
}

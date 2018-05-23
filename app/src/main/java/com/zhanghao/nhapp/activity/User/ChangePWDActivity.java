package com.zhanghao.nhapp.activity.User;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhanghao.nhapp.Entity.MesObject;
import com.zhanghao.nhapp.Entity.User.JsonRootBean;
import com.zhanghao.nhapp.Kingdee.InvokeHelper;
import com.zhanghao.nhapp.MainActivity;
import com.zhanghao.nhapp.R;

import java.util.ArrayList;

import static com.zhanghao.nhapp.Tools.Json.JsonHelper.getEntityFromJson;

public class ChangePWDActivity extends AppCompatActivity implements View.OnClickListener{
    EditText dt_phone;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        ActionBar actionBar=getSupportActionBar();//去掉顶部标题栏方法
        actionBar.hide();//去掉顶部标题栏方法
        button = (Button)findViewById(R.id.Confirm);
        initClickEvent();
//        Intent intent = getIntent();
//        String phone = intent.getStringExtra("phoneNumber");
//        dt_phone.setText(phone);
    }
    public void initClickEvent(){
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.Confirm:
//                Toast.makeText(ChangePWDActivity.this,"修改成功",Toast.LENGTH_SHORT);
                Intent intent = new Intent();
                intent.setClass(ChangePWDActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}

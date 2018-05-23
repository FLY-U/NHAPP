package com.zhanghao.nhapp.activity.User;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhanghao.nhapp.Entity.User.JsonRootBean;
import com.zhanghao.nhapp.Entity.MesObject;
import com.zhanghao.nhapp.Kingdee.InvokeHelper;
import com.zhanghao.nhapp.MainActivity;
import com.zhanghao.nhapp.R;

import java.util.ArrayList;

import static com.zhanghao.nhapp.Tools.Json.JsonHelper.getEntityFromJson;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private ImageView loginImage;
    private TextView topText;
    private TextPaint tp;
    private Button loginbtn;
    private Button changepwdbtn;
    private EditText username;
    private EditText password;
    private Drawable mIconPerson;
    private Drawable mIconLock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar=getSupportActionBar();//去掉顶部标题栏方法
        actionBar.hide();//去掉顶部标题栏方法
        loginbtn = findViewById(R.id.loginbtn);
        initClickEvent(); //初始化点击事件
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.login,menu);
        return true;
    }
    public void initClickEvent(){
        loginbtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginbtn:
                Intent intent = new Intent();
                intent.setClass(Login.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.changepwdbtn:

                EditText dt;
                dt = (EditText) findViewById(R.id.username);
                final String phone = dt.getText().toString();
                intent = new Intent(Login.this,ChangePWDActivity.class);
                intent.putExtra("phoneNumber",phone);
                startActivity(intent);
                break;
        }
    }
}


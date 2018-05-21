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
import com.zhanghao.nhapp.R;

import java.util.ArrayList;

import static com.zhanghao.nhapp.Tools.Json.JsonHelper.getEntityFromJson;

public class ChangePWDActivity extends AppCompatActivity {
    InvokeHelper invoke = new InvokeHelper();
    EditText dt_phone;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        ActionBar actionBar=getSupportActionBar();//去掉顶部标题栏方法
        actionBar.hide();//去掉顶部标题栏方法
        dt_phone = (EditText)findViewById(R.id.changepwd_phone);
        Intent intent = getIntent();
        String phone = intent.getStringExtra("phoneNumber");
        dt_phone.setText(phone);
        final Handler handler=new Handler(){
            public void handleMessage(Message msg) {
                MesObject obj =(MesObject) msg.obj;
                String mg = obj.Message;
                Toast.makeText(ChangePWDActivity.this,mg, Toast.LENGTH_LONG).show();
            };
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run(){
                        invoke.POST_K3CloudURL = "http://localhost/K3Cloud/";//金蝶K3Cloudwebapi接口访问地址
                        String dbId = "1";//账套ID
                        String uid = "zhangh";//登录名
                        String pwd = "";//密码
                        int lang = 2052;//语言代码，2052为中文
                        try{
                            if (InvokeHelper.Login(dbId, uid, pwd, lang)) {//验证登录
                                String ret = InvokeHelper.changepwd("","{\"phoneNumber\": \"136......\",\"passWord\": \"1\"}");
                                ArrayList<JsonRootBean> arrayList = getEntityFromJson(ret,JsonRootBean.class);
                                int result=0;
                                for (int i=0;i<arrayList.size();i++) {
                                    result = arrayList.get(i).getResult();
                                }
                                if(result==2){
                                    Message msg=new Message();
                                    MesObject obj = new MesObject();
                                    obj.Message = "修改成功";
                                    msg.obj = obj;
                                    handler.sendMessage(msg);
                                    Intent intent = new Intent();
                                    intent.setClass(ChangePWDActivity.this, Login.class);
                                    startActivity(intent);
                                }
                            }else {
                                Message msg=new Message();
                                MesObject obj = new MesObject();
                                obj.Message = "登陆失败";
                                msg.obj = obj;
                                handler.sendMessage(msg);
                            }
                        }catch (Exception e){
                            Message msg=new Message();
                            MesObject obj = new MesObject();
                            obj.Message = "登陆异常";
                            msg.obj = obj;
                            handler.sendMessage(msg);
                        }
                    }
                }.start();
            }
        });

    }
}

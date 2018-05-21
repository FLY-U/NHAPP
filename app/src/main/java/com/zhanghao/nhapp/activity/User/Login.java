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

public class Login extends AppCompatActivity {
    private ImageView loginImage;
    private TextView topText;
    private TextPaint tp;
    private Button loginbtn;
    private Button changepwdbtn;
    private EditText username;
    private EditText password;
    private Drawable mIconPerson;
    private Drawable mIconLock;
    InvokeHelper invoke = new InvokeHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar=getSupportActionBar();//去掉顶部标题栏方法
        actionBar.hide();//去掉顶部标题栏方法
        username = (EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        changepwdbtn=(Button)findViewById(R.id.changepwdbtn);
        loginbtn = (Button)findViewById(R.id.loginbtn);
        final Handler handler=new Handler(){
            public void handleMessage(Message msg) {
                MesObject obj =(MesObject) msg.obj;
                String mg = obj.Message;
                Toast.makeText(Login.this,mg, Toast.LENGTH_LONG).show();
            };
        };
        changepwdbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText dt;
                dt = (EditText) findViewById(R.id.username);
                final String phone = dt.getText().toString();
                Intent intent = new Intent(Login.this,ChangePWDActivity.class);
                intent.putExtra("phoneNumber",phone);
                startActivity(intent);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run(){
                        super.run();
                        invoke.POST_K3CloudURL = "http://localhost/K3Cloud/";//金蝶K3Cloudwebapi接口访问地址
                        String dbId = "5a41bbac3d52f7";//账套ID
                        String uid = "zhangh";//登录名
                        String pwd = "";//密码
                        int lang = 2052;//语言代码，2052为中文
                        try{
                            if (InvokeHelper.Login(dbId, uid, pwd, lang)) {//验证登录
                                String ret = InvokeHelper.login("","{\"phoneNumber\": \"136........\",\"passWord\": \"1\"}");
                                ArrayList<JsonRootBean> arrayList = getEntityFromJson(ret,JsonRootBean.class);
                                int result=0;
                                for (int i=0;i<arrayList.size();i++) {
                                    result = arrayList.get(i).getResult();
                                }
                                if(result==2){
                                    Message msg=new Message();
                                    MesObject obj = new MesObject();
                                    obj.Message = "登陆成功";
                                    msg.obj = obj;
                                    handler.sendMessage(msg);
                                    Intent intent = new Intent();
                                    intent.setClass(Login.this, MainActivity.class);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.login,menu);
        return true;
    }

}


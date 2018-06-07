package com.zhanghao.nhapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.zhanghao.nhapp.Base.BaseActivity;
import com.zhanghao.nhapp.activity.Date.SelectDate2Activity;
import com.zhanghao.nhapp.activity.FragmentActivity;
import com.zhanghao.nhapp.activity.RightTopPopWindow.RightTopPopActivity;
import com.zhanghao.nhapp.activity.contactlist.ContactListActivity;
import com.zhanghao.nhapp.activity.User.ListView.SwipeRefresh;
import com.zhanghao.nhapp.activity.erweima.ErWeiMaActivity;
import com.zhanghao.nhapp.activity.progressbar.ProgressBarActivity;
import com.zhanghao.nhapp.activity.ratingbar.ratingbar;
import com.zhanghao.nhapp.dialog.MySimpleDialog;
import com.zhanghao.nhapp.utils.MoveUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends BaseActivity{

    //定义图标数组
    private int[] imageRes = {
            R.drawable.refresh,
            R.drawable.contacts,
            R.drawable.calendarclock,
            R.mipmap.reindeer,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.mipmap.popup_3d,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher

            };

    //定义图标下方的名称数组
    private String[] name = {
            "上拉加载下拉刷新",
            "联系人列表",
            "日期选择器",
            "Fragment",
            "加载框样例",
            "功能框样例",
            "仿微信右上角弹框",
            "系统自带进度条",
            "ratingbar",
            "二维码",
            "水电煤",
            "违章代缴",
            "快递查询",
            "更多"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        int length = imageRes.length;

        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", imageRes[i]);//添加图像资源的ID
            map.put("ItemText", name[i]);//按序号做ItemText
            lstImageItem.add(map);
        }
        //生成适配器的ImageItem 与动态数组的元素相对应
        SimpleAdapter saImageItems = new SimpleAdapter(this,
                lstImageItem,//数据来源
                R.layout.item,//item的XML实现

                //动态数组与ImageItem对应的子项
                new String[]{"ItemImage", "ItemText"},

                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.img_shoukuan, R.id.txt_shoukuan});
        //添加并且显示
        gridview.setAdapter(saImageItems);
        //添加消息处理
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,name[position],Toast.LENGTH_LONG).show();
                if(name[position]=="上拉加载下拉刷新"){
                    MoveUtils.go(MainActivity.this, SwipeRefresh.class);
                }else if(name[position]=="联系人列表"){
                    MoveUtils.go(MainActivity.this, ContactListActivity.class);
                }else if(name[position]=="日期选择器"){
                    MoveUtils.go(MainActivity.this, SelectDate2Activity.class);
                }else if(name[position]=="Fragment"){
                    MoveUtils.go(MainActivity.this, FragmentActivity.class);
                }else if(name[position]=="加载框样例"){
                    dialogShow();
//                dialogShow("正在获取数据...");
                    progressDialog.setCancelable(true);
                }else if(name[position]=="功能框样例"){
                    new MySimpleDialog(MainActivity.this).show();
                }else if(name[position]=="仿微信右上角弹框"){
                    MoveUtils.go(MainActivity.this, RightTopPopActivity.class);
                }else if(name[position]=="系统自带进度条"){
                    MoveUtils.go(MainActivity.this, ProgressBarActivity.class);
                }else if(name[position]=="ratingbar"){
                    MoveUtils.go(MainActivity.this, ratingbar.class);
                }else if(name[position]=="二维码"){
                    MoveUtils.go(MainActivity.this, ErWeiMaActivity.class);
                }
            }
        });
    }
}

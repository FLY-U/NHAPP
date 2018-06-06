package com.zhanghao.nhapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.zhanghao.nhapp.Base.BaseActivity;
import com.zhanghao.nhapp.Fragment.FirstFragment;
import com.zhanghao.nhapp.Fragment.SecondFragment;
import com.zhanghao.nhapp.activity.User.ListView.SwipeRefresh;
import com.zhanghao.nhapp.adapter.QFragmentPagerAdapter;
import com.zhanghao.nhapp.utils.MoveUtils;
import com.zhanghao.nhapp.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    //定义图标数组
    private int[] imageRes = {
            R.drawable.refresh,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
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
            "订单查询",
            "转账",
            "手机充值",
            "信用卡还款",
            "水电煤",
            "违章代缴",
            "快递查询",
            "更多",
            "信用卡还款",
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
                }
            }
        });
    }
}

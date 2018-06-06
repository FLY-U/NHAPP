package com.zhanghao.nhapp.activity.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhanghao.nhapp.Base.BaseActivity;
import com.zhanghao.nhapp.R;
import com.zhanghao.nhapp.activity.contactlist.contact.ChineseToEnglish;
import com.zhanghao.nhapp.activity.contactlist.contact.CompareSort;
import com.zhanghao.nhapp.activity.contactlist.contact.SideBarView;
import com.zhanghao.nhapp.activity.contactlist.contact.User;
import com.zhanghao.nhapp.activity.contactlist.contact.UserAdapter;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactListActivity extends BaseActivity implements SideBarView.LetterSelectListener {

    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.sidebarview)
    SideBarView sidebarview;
    @BindView(R.id.tip)
    TextView tip;
    @BindView(R.id.activity_contact_list)
    RelativeLayout activityContactList;
    UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);
        init();
    }
    private void init() {
        String[] contactsArray = getResources().getStringArray(R.array.data1);
        String[] headArray = getResources().getStringArray(R.array.head);

        //模拟添加数据到Arraylist
        int length = contactsArray.length;
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            User user = new User();
            user.setName(contactsArray[i]);
            String firstSpell = ChineseToEnglish.getFirstSpell(contactsArray[i]);
            String substring = firstSpell.substring(0, 1).toUpperCase();
            if (substring.matches("[A-Z]")) {
                user.setLetter(substring);
            } else {
                user.setLetter("#");
            }
            users.add(user);
        }

        for (int i = 0; i < headArray.length; i++) {
            User user = new User();
            user.setName(headArray[i]);
            user.setLetter("@");
            users.add(user);
        }

        //排序
        Collections.sort(users, new CompareSort());

        //设置数据
        mAdapter = new UserAdapter(this);
        mAdapter.setData(users);
        listview.setAdapter(mAdapter);

        //设置回调
        sidebarview.setOnLetterSelectListen(this);

    }


    @Override
    public void onLetterSelected(String letter) {
        setListviewPosition(letter);
        tip.setText(letter);
        tip.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLetterChanged(String letter) {
        setListviewPosition(letter);
        tip.setText(letter);
    }

    @Override
    public void onLetterReleased(String letter) {
        tip.setVisibility(View.GONE);
    }

    private void setListviewPosition(String letter) {
        if (letter.equals("↑")){
            listview.setSelection(0);
        }else if (letter.equals("☆")){
            setListviewPosition("A");
        }else {
            int firstLetterPosition = mAdapter.getFirstLetterPosition(letter);
            if (firstLetterPosition != -1) {
                listview.setSelection(firstLetterPosition);
            }
        }

    }
}

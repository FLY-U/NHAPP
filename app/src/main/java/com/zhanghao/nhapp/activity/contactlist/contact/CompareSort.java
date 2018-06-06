package com.zhanghao.nhapp.activity.contactlist.contact;

import java.util.Comparator;

public class CompareSort implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        if(user1.getLetter().equals("@") || user2.getLetter().equals("@")){
            //通讯录前面的ｉｔｅｍ(公众号，标签......)
            return user1.getLetter().equals("@") ? -1:1;
        }
        //user1属于#标签，放到后面
        else if(!user1.getLetter().matches("[A-z]+")){
            return 1;
            //user2属于#标签，放到后面
        }else if(!user2.getLetter().matches("[A-z]+")){
            return -1;
        }else {
            return user1.getLetter().compareTo(user2.getLetter());
        }
    }
}
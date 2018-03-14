package com.example.crystal.contact.model;

import com.example.crystal.contact.Bean.BaseIndexPinyinBean;


public class FriendsBean extends BaseIndexPinyinBean {

    private String name;//名字
    private boolean isTop;//是否是最上面的 不需要被转化成拼音的

    public FriendsBean() {
    }

    public FriendsBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FriendsBean AddFriends(String name) {
        this.name = name;
        return this;
    }

    public boolean isTop() {
        return isTop;
    }

    public FriendsBean setTop(boolean top) {
        isTop = top;
        return this;
    }

    @Override
    public String getTarget() {
        return name;
    }

    @Override
    public boolean isNeedToPinyin() {
        return !isTop;
    }


    @Override
    public boolean isShowSuspension() {
        return !isTop;
    }
}

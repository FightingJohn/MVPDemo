package com.tianlanse.mvpdemo.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by 木木 on 2016/6/12.
 * 用户信息
 */
public class UserBean extends DataSupport{

    @Column(unique = true,nullable = false)
    private int mId;
    @Column(nullable = false)
    private String mName;
    @Column(nullable = false)
    private String mAge;

    //setter和getter
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }
}

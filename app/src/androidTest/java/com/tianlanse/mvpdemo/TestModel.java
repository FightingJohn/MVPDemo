package com.tianlanse.mvpdemo;

import android.test.InstrumentationTestCase;

import com.tianlanse.mvpdemo.bean.UserBean;

import org.litepal.crud.DataSupport;

/**
 * Created by 木木 on 2016/6/14.
 */
public class TestModel extends InstrumentationTestCase{


    public void testGetUser(){
        UserBean userBean = DataSupport.find(UserBean.class, 2);
        assertEquals("李四", userBean.getmName());
//        System.out.print("--------"+userBean.getmName());
    }
}

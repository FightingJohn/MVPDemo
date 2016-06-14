package com.tianlanse.mvpdemo.view;

import com.tianlanse.mvpdemo.bean.UserBean;

/**
 * Created by 木木 on 2016/6/14.
 * 操作ui显示内容的方法接口
 */
public interface IUserView {

    //获得用户ID文本框的内容
    int getUserId();

    //获取输入的用户信息
    UserBean getUserInf();

    //设置用户信息
    void setUserInf(UserBean userBean);

/*    //设置用户id
    void setUserInf(int id);

    //设置用户姓名
    void setUserName(String name);

    //设置用户年龄
    void setUserAge(String age);*/
}

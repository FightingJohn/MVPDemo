package com.tianlanse.mvpdemo.model;

import com.tianlanse.mvpdemo.bean.UserBean;

/**
 * Created by 木木 on 2016/6/14.
 * 对用户信息进行添删改查操作的接口
 */
public interface IUserModel {

    //判断改用户是否已经存在
    boolean isExist(int id);

    //通过用户ID获取用户信息
    UserBean getUser(int id);

    //通过用户ID删除用户信息
    boolean deleteUser(int id);

    //通过用户ID修改用户信息
    boolean updateUser(UserBean userBean);

    //保存用户信息
    boolean addUser(UserBean userBean);
}

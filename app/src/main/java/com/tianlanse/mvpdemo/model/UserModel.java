package com.tianlanse.mvpdemo.model;

import android.util.Log;

import com.tianlanse.mvpdemo.bean.UserBean;

import org.litepal.crud.DataSupport;

/**
 * Created by 木木 on 2016/6/14.
 * 用户添删改查操作的实现
 */
public class UserModel implements IUserModel {

    @Override
    public boolean isExist(int id) {
        /*
         *UserBean.class相当于定义在那个表中查询，“mid=?” 和 String.valueOf(id)是
         *查询的条件，例如 form userbean where mid=2；返回类型为boolean
         */
        boolean flag = DataSupport.isExist(UserBean.class, "mid=?", String.valueOf(id));

        return flag;
    }

    @Override
    public UserBean getUser(int id) {

        /*
         *这是查询某条用户信息，还可以查询所有的用户信息，如：
         * List<UserBean> users = DataSupport.findAll(UserBean.class);
         * 或者进行一些复杂的查询，如：
         * List<UserBean> userBeans = DataSupport.where("mname like ?", "张%").order("mid").find(UserBean.class);
         */
        UserBean userBean = DataSupport.find(UserBean.class, id);
        Log.e("l阿拉拉啊拉啦啦啦", userBean.getmName());
        return userBean;
    }

    @Override
    public boolean deleteUser(int id) {

        /*
         *返回值是int类型，表示受影响的行数.当然删除操作也可以像查询操作一样，
         * 进行全部删除或者复杂删除。
         */
        int delete = DataSupport.delete(UserBean.class, id);
        if(delete > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateUser(UserBean userBean) {

        /*
         *这个是更新某条指定的数据，返回值表示收到影响的行数,也可以更新多条数据，如：
         * userBean.updateAll("mname=?","张三");返回值也是int类型，表示受影响的行数
         */
        int update = userBean.update(userBean.getmId());
        if(update > 0)
            return true;
        return false;
    }

    @Override
    public boolean addUser(UserBean userBean) {

        /*
         *新建一个用户信息实体类，保存用户信息
         */
        UserBean user = new UserBean();
        user.setmId(userBean.getmId());
        user.setmName(userBean.getmName());
        user.setmAge(userBean.getmAge());
        boolean flag = user.save();

        return flag;
    }
}

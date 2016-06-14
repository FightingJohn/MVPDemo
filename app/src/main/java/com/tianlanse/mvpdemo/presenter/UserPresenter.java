package com.tianlanse.mvpdemo.presenter;

import android.content.Context;

import com.tianlanse.mvpdemo.bean.UserBean;
import com.tianlanse.mvpdemo.model.IUserModel;
import com.tianlanse.mvpdemo.model.UserModel;
import com.tianlanse.mvpdemo.utils.ToastUtil;
import com.tianlanse.mvpdemo.view.IUserView;

/**
 * Created by 木木 on 2016/6/14.
 * 主导者，操作model和view层，处理逻辑问题(例如：添删改查)
 */
public class UserPresenter {

    private IUserModel mUserModel;
    private IUserView mUserView;

    public UserPresenter(IUserView userView){

        mUserView = userView;
        mUserModel = new UserModel();
    }

    //保存用户信息
    public void saveUser(Context context){
        if(mUserModel.isExist(mUserView.getUserId())){
            ToastUtil.shortToast(context, "该用户id已存在");
        }else {
            if(mUserModel.addUser(mUserView.getUserInf())){
                ToastUtil.shortToast(context, "添加成功");
            }else{
                ToastUtil.shortToast(context, "添加失败");
            }
        }
    }

    //删除用户信息
    public void deleteUser(Context context){
        if(!mUserModel.isExist(mUserView.getUserId())){
            ToastUtil.shortToast(context, "该用户不存在存在");
        }else {
            if(mUserModel.deleteUser(mUserView.getUserId())){
                ToastUtil.shortToast(context, "删除成功");
            }else{
                ToastUtil.shortToast(context, "删除失败");
            }
        }
    }

    //修改用户信息
    public void updateUser(Context context){
        if(!mUserModel.isExist(mUserView.getUserId())){
            ToastUtil.shortToast(context, "该用户不存在存在");
        }else {
            if(mUserModel.updateUser(mUserView.getUserInf())){
                ToastUtil.shortToast(context, "修改成功");
            }else{
                ToastUtil.shortToast(context, "修改失败");
            }
        }
    }

    //查找用户信息
    public void seacherUser(Context context){
        if(!mUserModel.isExist(mUserView.getUserId())){
            ToastUtil.shortToast(context, "该用户不存在存在");
        }else {
            UserBean user = mUserModel.getUser(mUserView.getUserId());
            mUserView.setUserInf(user);
        }
    }
}

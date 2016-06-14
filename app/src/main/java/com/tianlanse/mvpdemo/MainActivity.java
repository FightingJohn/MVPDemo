package com.tianlanse.mvpdemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tianlanse.mvpdemo.bean.UserBean;
import com.tianlanse.mvpdemo.presenter.UserPresenter;
import com.tianlanse.mvpdemo.view.IUserView;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity implements IUserView, View.OnClickListener {

    UserPresenter presenter;
    EditText etId, etName, etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //生成数据库
        SQLiteDatabase db = Connector.getDatabase();
        //给按钮注册点击事件
        findViewById(R.id.bt_add).setOnClickListener(this);
        findViewById(R.id.bt_delete).setOnClickListener(this);
        findViewById(R.id.bt_charge).setOnClickListener(this);
        findViewById(R.id.bt_search).setOnClickListener(this);

        etId = (EditText) findViewById(R.id.et_id);
        etName = (EditText) findViewById(R.id.et_name);
        etAge = (EditText) findViewById(R.id.et_age);

        //实例化UserPresenter对象，因为MainActivity实现了接口IUserView，所以可以传入this
        presenter = new UserPresenter(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_add:
                presenter.saveUser(this);
                break;
            case R.id.bt_delete:
                presenter.deleteUser(this);
                break;
            case R.id.bt_charge:
                presenter.updateUser(this);
                break;
            case R.id.bt_search:
                presenter.seacherUser(this);
                break;
        }
    }

    @Override
    public int getUserId() {
        return Integer.parseInt(etId.getText().toString().trim());
    }

    @Override
    public UserBean getUserInf() {
        UserBean bean = new UserBean();
        bean.setmId(Integer.parseInt(etId.getText().toString().trim()));
        bean.setmName(etName.getText().toString().trim());
        bean.setmAge(etAge.getText().toString().trim());
        return bean;
    }

    @Override
    public void setUserInf(UserBean userBean) {
//        etId.setText(userBean.getmId());
        etName.setText(userBean.getmName());
        etAge.setText(userBean.getmAge());
    }
}

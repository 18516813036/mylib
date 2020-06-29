package com.example.usercenter.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.common.utils.LogUtils;
import com.example.common.utils.MsgUtils;
import com.example.core.view.BaseActivity;
import com.example.net.common.Config;
import com.example.usercenter.R;
import com.example.usercenter.databinding.ActivityLoginBinding;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.repository.BaseRespEntity;
import com.example.usercenter.viewmodel.UserViewModel;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, UserViewModel> {

    @Override
    protected void initBinding() {
        binding.setVm(vm);
        binding.setCommand(this);
    }

    @Override
    protected UserViewModel createVM() {
        return new UserViewModel();
    }

    @Override
    protected int bandLayout() {
        return R.layout.activity_login;
    }

    public void loginClick(View view){
        String username = vm.userEntity.getUsername();
        String pwd = vm.userEntity.getPwd();
        if (TextUtils.isEmpty(username)){
            showMsg("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            showMsg("请输入密码");
            return;
        }

        Observable<BaseRespEntity<UserEntity>> observable = vm.login();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new io.reactivex.Observer<BaseRespEntity<UserEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseRespEntity<UserEntity> userEntityBaseRespEntity) {
                        showMsg("登录成功");
                        LogUtils.i(""+userEntityBaseRespEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i(""+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtils.i("end");
                    }
                });

    }

    public void showMsg(String msg){
        MsgUtils.showToast(this,msg);
    }

    /**
     * 获取资源文件字符串
     * @param rId
     * @return
     */
    public String getResourceString(int rId){
        return getResources().getString(rId);
    }
}

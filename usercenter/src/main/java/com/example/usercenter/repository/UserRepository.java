package com.example.usercenter.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.common.utils.LogUtils;
import com.example.core.model.IModel;
import com.example.core.repository.Repository;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.model.UserModel;

import io.reactivex.Observable;

public class UserRepository extends Repository<UserModel> {
    @Override
    protected UserModel createModel() {
        return new UserModel();
    }

    public Observable<BaseRespEntity<UserEntity>> login(UserEntity userEntity){
        /**
         * 无网络时 可以选择加载本地数据（sqlite sp file lrucache）
         */
        return mModel.login(userEntity);
    }
}

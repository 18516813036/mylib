package com.example.usercenter.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.request.BaseRequestOptions;
import com.example.common.utils.LogUtils;
import com.example.core.repository.Repository;
import com.example.core.viewmodel.BaseViewModel;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.repository.BaseRespEntity;
import com.example.usercenter.repository.UserRepository;

import io.reactivex.Observable;

public class UserViewModel extends BaseViewModel {

    public UserEntity userEntity = new UserEntity();

    public UserViewModel(){
        registerRepository(UserRepository.class.getSimpleName(),new UserRepository());
    }

    public Observable<BaseRespEntity<UserEntity>> login(){
        UserRepository userRepository = getRepository(UserRepository.class.getSimpleName());
        return userRepository.login(userEntity);
    }
}

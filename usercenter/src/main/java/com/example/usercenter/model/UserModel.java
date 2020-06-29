package com.example.usercenter.model;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.common.utils.LogUtils;
import com.example.core.model.IModel;
import com.example.net.RetrofitFactory;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.model.api.UserApi;
import com.example.usercenter.repository.BaseRespEntity;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserModel implements IModel {

    private Disposable disposable = null;

    /**
     * 登录方法
     *
     * @param userEntity
     * @return
     */
    public Observable<BaseRespEntity<UserEntity>> login(final UserEntity userEntity) {

//        final MutableLiveData<BaseRespEntity<UserEntity>> result = new MutableLiveData<>();

        //---------------------
//        if (Looper.getMainLooper().getThread() == Thread.currentThread()){
//            result.setValue(true);
//        }else {
//            result.postValue(true);
//        }

        //---------------------
//        UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);
//        Call<BaseRespEntity<UserEntity>> call = userApi.login(userEntity);
//        call.enqueue(new Callback<BaseRespEntity<UserEntity>>() {
//            @Override
//            public void onResponse(Call<BaseRespEntity<UserEntity>> call, Response<BaseRespEntity<UserEntity>> response) {
//                result.postValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<BaseRespEntity<UserEntity>> call, Throwable t) {
//
//            }
//        });

        //----------------------
//        Observable.create(new ObservableOnSubscribe<BaseRespEntity<UserEntity>>() {
//            @Override
//            public void subscribe(final ObservableEmitter<BaseRespEntity<UserEntity>> emitter) throws Exception {
//                UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);
//                Call<BaseRespEntity<UserEntity>> call = userApi.login(userEntity);
//                call.enqueue(new Callback<BaseRespEntity<UserEntity>>() {
//                    @Override
//                    public void onResponse(Call<BaseRespEntity<UserEntity>> call, Response<BaseRespEntity<UserEntity>> response) {
//                        emitter.onNext(response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<BaseRespEntity<UserEntity>> call, Throwable t) {
//                        emitter.onError(t);
//                    }
//                });
//                emitter.onComplete();
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<BaseRespEntity<UserEntity>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        //loading 开始
//                    }
//
//                    @Override
//                    public void onNext(BaseRespEntity<UserEntity> userEntityBaseRespEntity) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        //loading 结束
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        //loading 结束
//                    }
//                });

//        Flowable.create(new FlowableOnSubscribe<BaseRespEntity<UserEntity>>() {
//            @Override
//            public void subscribe(final FlowableEmitter<BaseRespEntity<UserEntity>> emitter) throws Exception {
//                UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);
//                Call<BaseRespEntity<UserEntity>> call = userApi.login(userEntity);
//                call.enqueue(new Callback<BaseRespEntity<UserEntity>>() {
//                    @Override
//                    public void onResponse(Call<BaseRespEntity<UserEntity>> call, Response<BaseRespEntity<UserEntity>> response) {
//                        if (response.body().getCode() == -1) {
//                            emitter.onError(new RuntimeException("用户登录失败"));
//                            return;
//                        }
//
//                        emitter.onNext(response.body());
//                        emitter.onComplete();
//                    }
//
//                    @Override
//                    public void onFailure(Call<BaseRespEntity<UserEntity>> call, Throwable t) {
//                        emitter.onError(t);
//                    }
//                });
//            }
//        }, BackpressureStrategy.LATEST).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BaseRespEntity<UserEntity>>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        s.request(Long.MAX_VALUE);
//                    }
//                    @Override
//                    public void onNext(BaseRespEntity<UserEntity> userEntityBaseRespEntity) {
//                        result.postValue(userEntityBaseRespEntity);
//                    }
//                    @Override
//                    public void onError(Throwable t) {
//                        result.postValue(null);
//                    }
//                    @Override
//                    public void onComplete() {
//                    }
//                });

        final UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);
        Observable<BaseRespEntity<UserEntity>> result = userApi.login(userEntity);
        return result;
    }
}

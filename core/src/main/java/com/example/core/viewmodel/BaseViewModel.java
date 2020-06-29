package com.example.core.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.core.repository.Repository;

import java.util.HashMap;
import java.util.Map;

public class BaseViewModel extends ViewModel {
    protected Map<String, Repository> repositoryMap;

    public BaseViewModel() {
        this.repositoryMap = new HashMap<>();
    }

    /**
     * 注册数据仓库
     * @param key 数据仓库的标识
     * @param repository 数据仓库的实例
     */
    protected void registerRepository(String key, Repository repository){
        if (repositoryMap.containsKey(key)){
            return;
        }
        repositoryMap.put(key,repository);
    }

    /**
     * 注销数据仓库
     * @param key 数据仓库的标识
     */
    protected void unRegisterRepository(String key){
        if (repositoryMap.containsKey(key)){
            repositoryMap.remove(key);
        }
    }

    /**
     * 获取key具体的数据仓库
     * @param key 数据仓库的标识
     * @param <SubRepository> 具体的数据仓库
     * @return
     */
    protected <SubRepository extends Repository> SubRepository getRepository(String key){
        if (repositoryMap.containsKey(key)){
            return (SubRepository) repositoryMap.get(key);
        }
        return null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disConnectOwner(){
        repositoryMap.clear();
        repositoryMap = null;
    }
}

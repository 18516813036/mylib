package com.example.storage.core;

import com.example.common.app.BaseAppcation;
import com.example.storage.utils.SharePreferenceUtils;

public class SPStorage implements IStorage {
    @Override
    public <T> boolean save(String key, T value) {
        SharePreferenceUtils.put(BaseAppcation.getAppContext(),key,value);
        return true;
    }

    @Override
    public <T> T get(String key) {
        SharePreferenceUtils.get(BaseAppcation.getAppContext(),key);
        return null;
    }
}

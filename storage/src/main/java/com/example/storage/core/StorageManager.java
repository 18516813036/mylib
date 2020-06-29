package com.example.storage.core;

public class StorageManager {
    private static StorageManager instance = new StorageManager();
    private IStorage storage;

    private StorageManager() {
        init(StorageType.SP);
    }

    public static StorageManager getInstance() {
        return instance;
    }

    public void init(int storageType){
        if (storageType == StorageType.SP){
            this.storage = new SPStorage();
        }else if (storageType == StorageType.FILE){
            this.storage = new FileStorage();
        }
    }

    public <T> boolean save(String key, T value) {
        return storage.save(key,value);
    }

    public <T> T get(String key) {
        return storage.get(key);
    }
}

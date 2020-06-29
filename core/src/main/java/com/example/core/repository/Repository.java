package com.example.core.repository;

import com.example.core.model.IModel;

/**
 * 数据仓库的基类
 * @param <M>
 */
public abstract class Repository<M extends IModel> {
    /**
     * 业务Model
     */
    protected M mModel;

    public Repository() {
        this.mModel = createModel();
    }

    /**
     * 创建业务Model
     * @return
     */
    protected abstract M createModel();
}

package com.example.core.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.core.viewmodel.BaseViewModel;

/**
 * 基础的Activity
 * @param <Binding>
 * @param <VM>
 */
public abstract class BaseActivity<Binding extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity {

    protected Binding binding;
    protected VM vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, bandLayout());
        vm = createVM();
        initBinding();
    }

    /**
     * 初始化绑定
     */
    protected abstract void initBinding();

    /**
     * 创建VM
     * @return
     */
    protected abstract VM createVM();

    /**
     * 设置布局Id
     * @return
     */
    protected abstract int bandLayout();
}

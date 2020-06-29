package com.example.core.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.core.viewmodel.BaseViewModel;

/**
 * 基础的Fragment
 * @param <Binding>
 * @param <VM>
 */
public abstract class BaseFragment<Binding extends ViewDataBinding, VM extends BaseViewModel> extends Fragment {

    protected Binding binding;
    protected VM vm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, bandLayout(), container, false);
        vm = createVM();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

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

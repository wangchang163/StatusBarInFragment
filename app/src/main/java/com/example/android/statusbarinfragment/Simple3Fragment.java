package com.example.android.statusbarinfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者    wangchang
 * 时间    2019/5/5 17:00
 * 文件    StatusBarInFragment
 * 描述
 */
public class Simple3Fragment extends Fragment{


    public static Simple3Fragment newInstance() {

        Bundle args = new Bundle();

        Simple3Fragment fragment = new Simple3Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragement_simple3, container, false);
    }
}

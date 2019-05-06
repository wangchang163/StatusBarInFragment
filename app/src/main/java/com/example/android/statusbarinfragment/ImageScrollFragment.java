package com.example.android.statusbarinfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 作者    wangchang
 * 时间    2019/5/6 15:13
 * 文件    StatusBarInFragment
 * 描述
 */
public class ImageScrollFragment extends Fragment {
    private LinearLayout tvTitle;
    private NestedScrollView nestedScrollView;
    private View rootview;
    private float toolbarHeight;

    public static ImageScrollFragment newInstance() {
        Bundle args = new Bundle();
        ImageScrollFragment fragment = new ImageScrollFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragement_image2, container, false);
        tvTitle = rootview.findViewById(R.id.tvTitle);
        nestedScrollView = rootview.findViewById(R.id.scroll);
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvTitle.post(new Runnable() {
            @Override
            public void run() {
                toolbarHeight = tvTitle.getMeasuredHeight();
            }
        });
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == 0) {
                    tvTitle.getBackground().setAlpha(0);
                    StatusBarUtil.setDarkMode(getActivity());
                }
                if (scrollY <= toolbarHeight) {
                    float scale = (float) scrollY / toolbarHeight;
                    int alpha = (int) (scale * 255);
                    tvTitle.getBackground().setAlpha(alpha);
                    StatusBarUtil.setDarkMode(getActivity());
                } else {
                    tvTitle.getBackground().setAlpha(255);
                    StatusBarUtil.setLightMode(getActivity());
                }

            }
        });
    }
}

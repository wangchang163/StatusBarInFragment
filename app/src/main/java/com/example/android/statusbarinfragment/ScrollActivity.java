package com.example.android.statusbarinfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 作者    wangchang
 * 时间    2019/5/6 11:16
 * 文件    StatusBarInFragment
 * 描述
 */
public class ScrollActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayout relativeLayout;
    private int height;
    private int distance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        StatusBarUtil.setLightMode(this);
        recyclerView = findViewById(R.id.recyclerView);
        relativeLayout = findViewById(R.id.rela);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyAdapter());
        relativeLayout.post(new Runnable() {
            @Override
            public void run() {
                height = relativeLayout.getMeasuredHeight();
            }
        });

        //监听渐变状态
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                distance += dy;
                if (distance <= 0) {
                    relativeLayout.getBackground().setAlpha((int) 0f);
                    StatusBarUtil.setLightMode(ScrollActivity.this);
                } else if (distance > 0 && distance <= height) {
                    relativeLayout.getBackground().setAlpha(distance * 255 / height);
                    if (distance >= height / 2) {
                        StatusBarUtil.setDarkMode(ScrollActivity.this);
                    }
                } else {
                    relativeLayout.getBackground().setAlpha(255);
                    StatusBarUtil.setDarkMode(ScrollActivity.this);
                }

            }
        });
    }

    private class MyAdapter extends RecyclerView.Adapter {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View item = LayoutInflater.from(ScrollActivity.this).inflate(R.layout.item, viewGroup, false);
            return new ViewHolder(item);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}

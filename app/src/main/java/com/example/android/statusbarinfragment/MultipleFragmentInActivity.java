package com.example.android.statusbarinfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者    wangchang
 * 时间    2019/5/6 11:11
 * 文件    StatusBarInFragment
 * 描述
 */
public class MultipleFragmentInActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulity);
        StatusBarUtil.setTransparentForImageViewInFragment(this,null);
        viewPager=findViewById(R.id.viewpager);
        list.add(ImageFragment.newInstance());
        list.add(ImageScrollFragment.newInstance());
        list.add(SimpleFragment.newInstance());
        list.add(Simple2Fragment.newInstance());
        list.add(Simple3Fragment.newInstance());
        viewPager.setAdapter(new MultipleFragmentInActivity.MyPager(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i!=2){
                    StatusBarUtil.setDarkMode(MultipleFragmentInActivity.this);
                }else {
                    StatusBarUtil.setLightMode(MultipleFragmentInActivity.this);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    public class MyPager extends FragmentPagerAdapter {

        public MyPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}

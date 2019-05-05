package com.example.android.statusbarinfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTransparentForImageViewInFragment(this,null);
        viewPager=findViewById(R.id.viewpager);
        list.add(ImageFragment.newInstance());
        list.add(SimpleFragment.newInstance());
        list.add(Simple2Fragment.newInstance());
        list.add(Simple3Fragment.newInstance());
        viewPager.setAdapter(new MyPager(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i!=1){
                    StatusBarUtil.setDarkMode(MainActivity.this);
                }else {
                    StatusBarUtil.setLightMode(MainActivity.this);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    public class MyPager extends FragmentPagerAdapter{

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

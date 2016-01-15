package com.dycloud.designpractice;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mTabPager;
    private List<View> list = new ArrayList<View>();
    private int imgs[] = {R.drawable.guide01, R.drawable.guide02, R.drawable.guide03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_tab_layout);

        initViews();
    }

    private void initViews() {
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mTabPager = (ViewPager) findViewById(R.id.tab_pager);

        for(int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(imgs[i]);
            list.add(iv);
        }
        MyPagerDapter adapter = new MyPagerDapter(list);
        mTabPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mTabPager);

    }

    public class MyPagerDapter extends PagerAdapter {
        List<View> list;
        public MyPagerDapter(List<View> list) {
            this.list = list;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title;
            switch (position) {
                case 0:
                    title = "Home";
                    break;
                case 1:
                    title = "Pics";
                    break;
                case 2:
                    title = "Music";
                    break;
                default:
                    return "Tab " + super.getPageTitle(position);
            }
            return title;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(list.get(position));
        }
    }
}

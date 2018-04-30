package com.example.android.matsumotoguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.category_tabs) TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        CategoryAdapter pageAdapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }
}

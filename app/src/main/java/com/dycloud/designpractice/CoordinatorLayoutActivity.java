package com.dycloud.designpractice;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    private Toolbar clToolbar;
    private RecyclerView clRecyclerView;
    private MyRVAdapter mAdapter;
    private CollapsingToolbarLayout clCTLayout;
    private String datas[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        initView();
    }

    private void initView() {
        clCTLayout = (CollapsingToolbarLayout) findViewById(R.id.cl_collapsinglayout);

        clToolbar = (Toolbar) findViewById(R.id.cl_toolbar);
        clToolbar.setTitle("CollapsingLayout");
        setSupportActionBar(clToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        clRecyclerView = (RecyclerView) findViewById(R.id.cl_recyclerview);
        initRecylerView();

    }

    private void initRecylerView() {
        mAdapter = new MyRVAdapter(datas);
        clRecyclerView.setAdapter(mAdapter);
        clRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        clRecyclerView.setHasFixedSize(true);


    }

}

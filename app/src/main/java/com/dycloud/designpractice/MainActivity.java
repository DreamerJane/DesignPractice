package com.dycloud.designpractice;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStartTextInput;
    private Button btnStartFAB;
    private Button btnStartSnackbar;
    private Button btnStartTabLayout;
    private Button btnStartNaviView;
    private Button btnStartCoorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvent();
    }

    private void initEvent() {
        btnStartTextInput.setOnClickListener(this);
        btnStartFAB.setOnClickListener(this);
        btnStartSnackbar.setOnClickListener(this);
        btnStartTabLayout.setOnClickListener(this);
        btnStartNaviView.setOnClickListener(this);
        btnStartCoorLayout.setOnClickListener(this);
    }

    private void initViews() {
        btnStartTextInput = (Button) findViewById(R.id.start_textinputlayout);
        btnStartFAB = (Button) findViewById(R.id.start_fab);
        btnStartSnackbar = (Button) findViewById(R.id.start_snackbar);
        btnStartTabLayout = (Button) findViewById(R.id.start_tablayout);
        btnStartNaviView = (Button) findViewById(R.id.start_navigationview);
        btnStartCoorLayout = (Button) findViewById(R.id.start_coordinatorlayout);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_textinputlayout:
                startActivity(new Intent(MainActivity.this, TextInputLayoutActivity.class));
                break;
            case R.id.start_fab:
                startActivity(new Intent(MainActivity.this, FloatingABActivity.class));
                break;
            case R.id.start_snackbar:
                startActivity(new Intent(MainActivity.this, SnackBarActivity.class));
                break;
            case R.id.start_tablayout:
                startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
                break;
        case R.id.start_navigationview:
                startActivity(new Intent(MainActivity.this, NaviViewActivity.class));
                break;
        case R.id.start_coordinatorlayout:
                startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
                break;

            default:
                break;
        }
    }
}

package com.dycloud.designpractice;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FloatingABActivity extends AppCompatActivity {

    private FloatingActionButton mFAButton;
    private CoordinatorLayout mCoordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_ab);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        mFAButton = (FloatingActionButton) findViewById(R.id.fabuton);
        mFAButton.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = true;
            @Override
            public void onClick(View v) {
                if(isClicked) {
                    mFAButton.setImageResource(R.drawable.icon_right);
                    isClicked = false;
                }else {
                    mFAButton.setImageResource(R.drawable.location);
                    isClicked = true;
                }
                Snackbar.make(mCoordinatorLayout,"FloatingActionButton Clicked", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
                //Toast.makeText(FloatingABActivity.this, "FloatingActionButton Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

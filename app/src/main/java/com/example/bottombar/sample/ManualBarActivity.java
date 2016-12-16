package com.example.bottombar.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;

/**
 * Created by d.gureev on 15.12.2016.
 */

public class ManualBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_tabs);
        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setClickHandler(new BottomBar.ClickHandler() {
            @Override
            public boolean handleClick(BottomBarTab tab) {
                return (tab.getId() == R.id.tab_recents) || tab.getId() == R.id.tab_food;
            }
        });
    }
}

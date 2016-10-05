package com.example.bottombar.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;

import java.util.ArrayList;
import java.util.List;

public class TabsAddedProgrammaticallyActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tabs_added_programmatically);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        BottomBarTab tab1 = new BottomBarTab(this);
        tab1.setTitle("One");
        tab1.setIconResId(R.drawable.ic_favorites);
        tab1.setId(R.id.tab_favorites);

        BottomBarTab tab2 = new BottomBarTab(this);
        tab2.setTitle("Two");
        tab2.setIconResId(R.drawable.ic_friends);
        tab2.setId(R.id.tab_friends);

        BottomBarTab tab3 = new BottomBarTab(this);
        tab3.setTitle("Three");
        tab3.setIconResId(R.drawable.ic_nearby);
        tab3.setId(R.id.tab_nearby);

        BottomBarTab tab4 = new BottomBarTab(this);
        tab4.setTitle("Four");
        tab4.setIconResId(R.drawable.ic_recents);
        tab4.setId(R.id.tab_recents);

        List<BottomBarTab> tabList = new ArrayList<>();
        tabList.add(tab1);
        tabList.add(tab2);
        tabList.add(tab3);
        tabList.add(tab4);

        bottomBar.setItems(tabList);
    }
}

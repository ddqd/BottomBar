package com.example.bottombar.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;

import java.util.ArrayList;
import java.util.List;

public class TabsAddedProgrammaticallyActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tabs_added_programmatically);

        Button updateBar = (Button) findViewById(R.id.button);

        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        BottomBarTab tab1 = new BottomBarTab(this);
        tab1.setTitle("One");
        tab1.setIconResId(R.drawable.ic_closed_group_24dp);
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
        tab4.setIconResId(R.drawable.ic_feed_24dp);
        tab4.setId(R.id.tab_recents);

        BottomBarTab tab5 = new BottomBarTab(this, "Five", R.drawable.ic_restaurants, R.id.tab_food);

        final List<BottomBarTab> tabList = new ArrayList<>();
        tabList.add(tab1);
        tabList.add(tab2);
        tabList.add(tab3);
        tabList.add(tab4);
        tabList.add(tab5);

        bottomBar.setItems(tabList);
        bottomBar.setTag(tabList);

        final List<BottomBarTab> tabList1 = new ArrayList<>();
        tabList1.add(tab5);
        tabList1.add(tab4);
        tabList1.add(tab3);
        tabList1.add(tab2);
        tabList1.add(tab1);

        updateBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomBar.getTag().equals(tabList)) {
                    bottomBar.setItems(tabList1);
                    bottomBar.setTag(tabList1);
                } else {
                    bottomBar.setItems(tabList);
                    bottomBar.setTag(tabList);
                }
            }
        });
    }
}

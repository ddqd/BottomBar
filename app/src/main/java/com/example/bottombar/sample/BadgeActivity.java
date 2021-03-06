package com.example.bottombar.sample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by iiro on 7.6.2016.
 */
public class BadgeActivity extends AppCompatActivity {
    private TextView messageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_tabs);

        messageView = (TextView) findViewById(R.id.messageView);

        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                BottomBarTab tab = bottomBar.getTabWithId(tabId);
                int count = 0;
                if (tab.getTag() != null) {
                    count = (int) tab.getTag();
                }
                count+=1;
                tab.setTag(count);
                tab.setBadgeCount(count);
                messageView.setText(TabMessage.get(tabId, false));
            }
        });


        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });

        messageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Unselect tab", Toast.LENGTH_LONG).show();
                bottomBar.unselect();
            }
        });

        BottomBarTab nearby = bottomBar.getTabWithId(R.id.tab_nearby);
        nearby.setBadgeCount(5);
        nearby.setTag(5);
    }
}

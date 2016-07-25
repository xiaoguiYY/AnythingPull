package com.tk.anythingpull.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.tk.anythingpull.R;
import com.tk.anythingpull.adapter.RecyclerViewAdapter;
import com.tk.anythingpull.view.FootTestView;
import com.tk.library.view.AnythingPullLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by TK on 2016/7/23.
 */
public class NLRecyclerViewActivity extends AppCompatActivity {
    @Bind(R.id.recyclerview)
    NYRecyclerview recyclerview;
    @Bind(R.id.pull_layout)
    AnythingPullLayout pullLayout;
    @Bind(R.id.footview)
    FootTestView footview;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_nl);
        ButterKnife.bind(this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new RecyclerViewAdapter(this));
        pullLayout.setOnStatusChangeListener(new AnythingPullLayout.OnStatusChangeListener() {
            @Override
            public void onChange(int status, int direction, float distance) {
                if (direction == AnythingPullLayout.DIRECTION_UP) {
                    footview.refreshView(status, distance);
                }
                if (status == AnythingPullLayout.LOADING) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pullLayout.setLoadResult();
                        }
                    }, 2000);
                }
            }
        });
    }
}
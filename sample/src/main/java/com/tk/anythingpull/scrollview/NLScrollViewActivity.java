package com.tk.anythingpull.scrollview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.tk.anythingpull.R;
import com.tk.anythingpull.view.FootTestView;
import com.tk.library.view.AnythingPullLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by TK on 2016/7/23.
 */
public class NLScrollViewActivity extends AppCompatActivity {
    @Bind(R.id.footview)
    FootTestView footview;
    @Bind(R.id.pull_layout)
    AnythingPullLayout pullLayout;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_nl);
        ButterKnife.bind(this);
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
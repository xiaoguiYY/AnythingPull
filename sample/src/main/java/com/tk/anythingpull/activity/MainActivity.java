package com.tk.anythingpull.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tk.anythingpull.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ScrollView(View v) {
        startActivity(new Intent(this, ScrollViewActivity.class));
    }

    public void ListView(View v) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void RecyclerView(View v) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void LinearLayout(View v) {
        startActivity(new Intent(this, LinearLayoutActivity.class));
    }

    public void RelativeLayout(View v) {
        startActivity(new Intent(this, RelativeLayoutActivity.class));
    }
}
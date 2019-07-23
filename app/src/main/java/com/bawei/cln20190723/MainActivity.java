package com.bawei.cln20190723;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bawei.cln20190723.weight.DotRandomView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        DotRandomView dotRandomView  = findViewById(R.id.randomView);
        dotRandomView.addDot();
    }

    public void delete(View view) {
        DotRandomView dotRandomView  = findViewById(R.id.randomView);
        dotRandomView.deleteDot();
    }
}
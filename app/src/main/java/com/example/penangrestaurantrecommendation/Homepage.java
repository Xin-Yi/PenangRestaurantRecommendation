package com.example.penangrestaurantrecommendation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity implements View.OnClickListener {

    private TextView mSearchBar;
    private Button mSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
//
//        mSearchBar = findViewById(R.id.searchBar);
//        mSearch = findViewById(R.id.btnSearch);
//
//        mSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}

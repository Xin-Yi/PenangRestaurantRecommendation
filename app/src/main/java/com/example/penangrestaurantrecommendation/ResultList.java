//package com.example.penangrestaurantrecommendation;
//
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class ResultList extends AppCompatActivity {
//
//    private RecyclerView rvSearch;
//    private SearchAdapter adapter;
//    private ArrayList<Restaurant> restaurants;
//    private ArrayList<Object> restaurant;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.search_list);
//
//        rvSearch = (RecyclerView) findViewById(R.id.rvResult);
//
//        restaurants = new ArrayList<>();
//        adapter = new SearchAdapter(this, restaurants);
//        rvSearch.setAdapter(adapter);
//        rvSearch.setLayoutManager(new LinearLayoutManager(this));
//
//    }
//}

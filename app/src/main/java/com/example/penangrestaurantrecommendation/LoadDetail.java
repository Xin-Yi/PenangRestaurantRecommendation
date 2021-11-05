package com.example.penangrestaurantrecommendation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class LoadDetail extends AppCompatActivity implements View.OnClickListener {

    private TextView mName, mAddress, mContact, mPrice, mCity, mCuisine;
    private TextView mMonHours, mTuesHours, mWedHours, mThursHours, mFriHours, mSatHours, mSunHours;
    private Button btnReview;
    private static DatabaseReference ref;
    private Restaurant restaurant;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        mName = findViewById(R.id.name);
        mAddress = findViewById(R.id.address);
        mContact = findViewById(R.id.contact);
        mPrice = findViewById(R.id.price);

        mMonHours = findViewById(R.id.monHours);
        mTuesHours = findViewById(R.id.tuesHours);
        mWedHours = findViewById(R.id.wedHours);
        mThursHours = findViewById(R.id.thursHours);
        mFriHours = findViewById(R.id.friHours);
        mSatHours = findViewById(R.id.satHours);
        mSunHours = findViewById(R.id.sunHours);

        mCity = findViewById(R.id.city);
        mCuisine = findViewById(R.id.cuisine);

        btnReview = findViewById(R.id.review);

        btnReview.setOnClickListener(this);

        ref = FirebaseDatabase.getInstance().getReference("Restaurant");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Restaurant restaurant = snapshot.getValue(Restaurant.class);
                mName.setText(restaurant.getName());
                mAddress.setText(restaurant.getAddress());
                mContact.setText(restaurant.getContact());
                mMonHours.setText(restaurant.getMonHours());
                mTuesHours.setText(restaurant.getTuesHours());
                mWedHours.setText(restaurant.getWedHours());
                mThursHours.setText(restaurant.getThursHours());
                mFriHours.setText(restaurant.getFriHours());
                mSatHours.setText(restaurant.getSatHours());
                mSunHours.setText(restaurant.getSunHours());
                mPrice.setText(restaurant.getPrice());
                mCity.setText(restaurant.getCity());
                mCuisine.setText(restaurant.getCuisine());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Failed to read: " + error.getCode());
            }
        });



        //ref = FirebaseDatabase.getInstance().getReference("Restaurant");

//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Restaurant restaurant = snapshot.getValue(Restaurant.class);
//
//                mName.setText(restaurant.getName());
//                mAddress.setText(restaurant.getAddress());
//                mTime.setText(restaurant.getTime());
//                mContact.setText(restaurant.getContact());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                Restaurant restaurant = dataSnapshot.getValue(Restaurant.class);
//                // ..
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//            }
//        };
        //ref.addValueEventListener(postListener);



//        Intent edit = getIntent();
//        String id = edit.getStringExtra(MainActivity.EXTRA_ID);
//        restaurant = Restaurant.searchRecordById(id);
//
//        if (restaurant == null) {
//            finish();
//        }



    }

    @Override
    public void onClick(View view) {

    }
}

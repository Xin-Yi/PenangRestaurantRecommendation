package com.example.penangrestaurantrecommendation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import com.google.firebase.database.DatabaseReference;

public class CreateRestaurant extends AppCompatActivity implements android.view.View.OnClickListener{

    private EditText mName, mAddress, mContact, mPrice;
    private EditText mMonHours, mTuesHours, mWedHours, mThursHours, mFriHours, mSatHours, mSunHours;
    private RadioButton mBM, mButterworth;
    private CheckBox mChinese, mWestern, mJapanese, mKorean, mThai, mIndian;
    private Button mSave;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_restaurant);

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

        mBM = findViewById(R.id.rbBM);
        mButterworth = findViewById(R.id.rbButterworth);

        mChinese = findViewById(R.id.chinese);
        mWestern = findViewById(R.id.western);
        mJapanese = findViewById(R.id.japanese);
        mKorean = findViewById(R.id.korean);
        mThai = findViewById(R.id.thai);
        mIndian = findViewById(R.id.indian);

        mSave = findViewById(R.id.save);

        mSave.setOnClickListener(this);

    }

    @Override
    public void onClick(android.view.View view) {
        //Get restaurant details
        String name = mName.getText().toString();
        String address = mAddress.getText().toString();
        String contact = mContact.getText().toString();
        String monHours = mMonHours.getText().toString();
        String tuesHours = mTuesHours.getText().toString();
        String wedHours = mWedHours.getText().toString();
        String thursHours = mThursHours.getText().toString();
        String friHours = mFriHours.getText().toString();
        String satHours = mSatHours.getText().toString();
        String sunHours = mSunHours.getText().toString();
        String price = mPrice.getText().toString();
        String city = "";
        String cuisine = "";

        if(mBM.isChecked()){
            city = city + " Bukit Mertajam ";
        }

        if(mButterworth.isChecked()){
            city = city + " Butterworth ";
        }

        if (mChinese.isChecked()){
            cuisine = cuisine + " Chinese ";
        }

        if (mChinese.isChecked()){
            cuisine = cuisine + " Chinese ";
        }

        if (mWestern.isChecked()){
            cuisine = cuisine + " Western ";
        }

        if (mJapanese.isChecked()){
            cuisine = cuisine + " Japanese ";
        }

        if (mKorean.isChecked()){
            cuisine = cuisine + " Korean ";
        }

        if (mThai.isChecked()){
            cuisine = cuisine + " Thai ";
        }

        if (mIndian.isChecked()){
            cuisine = cuisine + " Indian ";
        }

        //Push new restaurant to database
        Restaurant restaurant = new Restaurant("", name, address, contact,monHours, tuesHours,
                wedHours, thursHours, friHours, satHours, sunHours, price, city, cuisine);
        ref = FirebaseDatabase.getInstance().getReference("Restaurant");
        ref.push().setValue(restaurant);
        //Restaurant.restaurant.clear();
        finish();
    }
}
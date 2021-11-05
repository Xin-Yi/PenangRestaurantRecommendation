package com.example.penangrestaurantrecommendation;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Restaurant {
    public static ArrayList<Restaurant> restaurant = new ArrayList<>();
    private static DatabaseReference ref;
    private String id;
    private String name, address, contact, price, city, cuisine;
    private String monHours, tuesHours, wedHours, thursHours, friHours, satHours, sunHours;

    public Restaurant(String id, String name, String address, String contact, String monHours, String tuesHours,
                      String wedHours, String thursHours, String friHours, String satHours, String sunHours, String price, String city, String cuisine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.monHours = monHours;
        this.tuesHours = tuesHours;
        this.wedHours = wedHours;
        this.thursHours = thursHours;
        this.friHours = friHours;
        this.satHours = satHours;
        this.sunHours = sunHours;
        this.price = price;
        this.city = city;
        this.cuisine = cuisine;
    }

    public Restaurant() {
    }

    public static ArrayList<Restaurant> getRestaurant() {
        return restaurant;
    }

    public static void setRestaurant(ArrayList<Restaurant> restaurant) {
        Restaurant.restaurant = restaurant;
    }

//    //Search the selected note by ID
//    public static Restaurant searchRecordById(String id) {
//        for (Restaurant r : restaurant) {
//            if (r.getId().equals(id))
//                return r;
//        }
//        return null;
//    }
//
//    //Load the data for recycler view
//    public static void loadRestaurant(final ArrayList<Restaurant> re) {
//        restaurant.clear();
//        ref = FirebaseDatabase.getInstance().getReference("Restaurant");
//
//        ref.orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                //Get all records, and set the unique key as ID
//                restaurant.clear();
//                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
//                    Restaurant r = dsp.getValue(Restaurant.class);
//                    r.setId(dsp.getKey());
//
//                    restaurant.add(r);
//                }
//
//                for (Restaurant restaurants : restaurant) {
//                    re.add(restaurants);
//                }
//
////                if (na != null)
////                    na.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getMonHours() {
        return monHours;
    }

    public void setMonHours(String monHours) {
        this.monHours = monHours;
    }

    public String getTuesHours() {
        return tuesHours;
    }

    public void setTuesHours(String tuesHours) {
        this.tuesHours = tuesHours;
    }

    public String getWedHours() {
        return wedHours;
    }

    public void setWedHours(String wedHours) {
        this.wedHours = wedHours;
    }

    public String getThursHours() {
        return thursHours;
    }

    public void setThursHours(String thursHours) {
        this.thursHours = thursHours;
    }

    public String getFriHours() {
        return friHours;
    }

    public void setFriHours(String friHours) {
        this.friHours = friHours;
    }

    public String getSatHours() {
        return satHours;
    }

    public void setSatHours(String satHours) {
        this.satHours = satHours;
    }

    public String getSunHours() {
        return sunHours;
    }

    public void setSunHours(String sunHours) {
        this.sunHours = sunHours;
    }
}

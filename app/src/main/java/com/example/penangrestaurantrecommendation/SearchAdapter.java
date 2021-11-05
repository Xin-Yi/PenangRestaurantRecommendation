//package com.example.penangrestaurantrecommendation;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import org.w3c.dom.Text;
//
//import java.util.ArrayList;
//
//public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
//
//    private LayoutInflater mInflater;
//    private ArrayList <Restaurant> restaurant;
//    private Context context;
//
//    SearchAdapter(Context context, ArrayList<Restaurant> restaurant){
//        mInflater = LayoutInflater.from(context);
//        this.context = context;
//        this.restaurant = restaurant;
//    }
//
//    // Create new views //to inflate the item layout and create the holder,
//    @NonNull
//    @Override
//    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ViewHolder(mInflater.inflate(R.layout.search_list, parent, false));
//    }
//
//    //to set the view attributes based on the data
//    @Override
//    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
//        holder.setData(restaurant.get(position)); //set data for each holder
//    }
//
//    // Returns the total count of items in the list
//    @Override
//    public int getItemCount() {
//        return restaurant.size(); // must know how many restaurant in the arraylist
//    }
//
//    //Provide a reference to the type of views using
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        private final TextView listName;
//        private final TextView listCuisine;
//        private final View itemView;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.itemView = itemView;
//            itemView.setOnClickListener(this);
//            listName = itemView.findViewById(R.id.name);
//            listCuisine = itemView.findViewById(R.id.cuisine);
//        }
//
//        @Override
//        public void onClick(View view) {
//
//        }
//
//        public void setData(Restaurant restaurant){
//            listName.setText(restaurant.getName());
//            listCuisine.setText(restaurant.getCuisine());
//        }
//    }
//
//}

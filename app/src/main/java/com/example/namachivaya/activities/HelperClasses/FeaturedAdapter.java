package com.example.namachivaya.activities.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.namachivaya.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocations;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_card_design,parent, false);
        FeaturedViewHolder featuredViewHolder=new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
         FeaturedHelperClass featuredHelperClass=featuredLocations.get(position);
         holder.name.setText(featuredHelperClass.getName());
         holder.age.setText(featuredHelperClass.getAge());
         holder.problem.setText(featuredHelperClass.getProblem());
         holder.desc.setText(featuredHelperClass.getDesc());
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }



    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{
        TextView name, age, problem, desc;
        public FeaturedViewHolder(@NonNull View itemView){
            super(itemView);
            //Hooks
            name=itemView.findViewById(R.id.featured_name);
            age=itemView.findViewById(R.id.featured_age);
            problem=itemView.findViewById(R.id.featured_problem);
            desc=itemView.findViewById(R.id.featured_desc);
        }
    }
}

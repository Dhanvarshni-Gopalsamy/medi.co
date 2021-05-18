package com.example.namachivaya.activities.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.namachivaya.R;
import java.util.ArrayList;

public class DateslotAdapter extends RecyclerView.Adapter<DateslotAdapter.DateslotViewHolder> {

    ArrayList<DateslotHelperClass> dateslotLocations;

    public DateslotAdapter(ArrayList<DateslotHelperClass> dateslotLocations) {
        this.dateslotLocations = dateslotLocations;
    }

    @NonNull
    @Override
    public DateslotAdapter.DateslotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_slot,parent, false);
        DateslotAdapter.DateslotViewHolder dateslotViewHolder=new DateslotAdapter.DateslotViewHolder(view);
        return dateslotViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DateslotAdapter.DateslotViewHolder holder, int position) {
        DateslotHelperClass dateslotHelperClass = dateslotLocations.get(position);
        holder.date.setText(dateslotHelperClass.getDate());
        holder.slot.setText(dateslotHelperClass.getSlot());

    }

    @Override
    public int getItemCount() {
        return dateslotLocations.size();
    }

    public static class DateslotViewHolder extends RecyclerView.ViewHolder{
        TextView date, slot;
        public DateslotViewHolder(@NonNull View itemView){
            super(itemView);
            //Hooks
            date=itemView.findViewById(R.id.date_slot);
            slot=itemView.findViewById(R.id.date_noslot);
        }
    }
}

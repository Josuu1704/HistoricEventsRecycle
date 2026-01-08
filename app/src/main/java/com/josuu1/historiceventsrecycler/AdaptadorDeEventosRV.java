package com.josuu1.historiceventsrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class AdaptadorDeEventosRV extends RecyclerView.Adapter<AdaptadorDeEventosRV.SostenDeVisitas> {
    public AdaptadorDeEventosRV(Context context, ArrayList<EventModel> events) {
        this.context = context;
        this.events = events;
    }

    Context context;
    ArrayList<EventModel> events;


    @NonNull
    @Override
    public AdaptadorDeEventosRV.SostenDeVisitas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cv_row, parent, false);
        return new AdaptadorDeEventosRV.SostenDeVisitas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDeEventosRV.SostenDeVisitas sosten, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class SostenDeVisitas extends RecyclerView.ViewHolder{
        TextView tvName, tvDate, tvLocation;
        public SostenDeVisitas(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvLocation = itemView.findViewById(R.id.tvLocation);
        }
    }
}

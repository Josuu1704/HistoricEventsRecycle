package com.josuu1.historiceventsrecycler;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class AdaptadorDeEventosRV extends RecyclerView.Adapter<AdaptadorDeEventosRV.SostenDeVisitas> {
    Context context;
    ArrayList<EventModel> events;

    public AdaptadorDeEventosRV(Context context, ArrayList<EventModel> events) {
        this.context = context;
        this.events = events;
    }


    @NonNull
    @Override
    public AdaptadorDeEventosRV.SostenDeVisitas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cv_row, parent, false);
        return new AdaptadorDeEventosRV.SostenDeVisitas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDeEventosRV.SostenDeVisitas sosten, int position) {
        EventModel event = events.get(position);

        sosten.tvName.setText(event.getEventName());
        sosten.tvDate.setText(event.getEventDate());
        sosten.tvLocation.setText(event.getEventLocation());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class SostenDeVisitas extends RecyclerView.ViewHolder{
        TextView tvName, tvDate, tvLocation;
        CardView card;
        public SostenDeVisitas(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            card = itemView.findViewById(R.id.eventCard);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                    LayoutInflater inflater = LayoutInflater.from(itemView.getContext());
                    View alertPopUpView = inflater.inflate(R.layout.event_popup, null);
                    builder.setTitle(tvName.getText())
                            .setView(alertPopUpView)
                            .setPositiveButton("Adelante", (dialog, which) -> {})
                            .setNegativeButton("Volver", (dialog, which) -> {
                                card.setCardBackgroundColor(itemView.getResources().getColor(R.color.cafe_oscuro)
                                );
                            })
                            .show();
                    //Toast.makeText(itemView.getContext(), tvName.getText(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

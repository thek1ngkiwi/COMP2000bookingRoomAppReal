package com.example.comp2000bookingroomapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class calendarMaker extends RecyclerView.Adapter<calendarMaker.CalendarViewHolder> {

    private final ArrayList<String> days;

    public calendarMaker(ArrayList<String> days) {
        this.days = days;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendarcell, parent, false);
        return new CalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        String dayText = days.get(position);
        holder.cellForDay.setText(dayText);

        if (!dayText.isEmpty()) {
            holder.itemView.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Selected Day: " + dayText, Toast.LENGTH_SHORT).show()
            );
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView cellForDay;

        public CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            cellForDay = itemView.findViewById(R.id.cellForDay);
        }
    }
}

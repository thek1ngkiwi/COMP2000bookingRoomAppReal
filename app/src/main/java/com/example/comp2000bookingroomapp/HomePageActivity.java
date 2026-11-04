package com.example.comp2000bookingroomapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private RecyclerView calendarGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        calendarGrid = findViewById(R.id.calendarGrid);
        calendarGrid.setLayoutManager(new GridLayoutManager(this, 7));
        ArrayList<String> days = new ArrayList<>();

        days.add("");
        days.add("");
        days.add("");
        days.add("");
        days.add("");
        days.add("");

        for (int i = 1; i <= 31; i++) {
            days.add(String.valueOf(i));
        }

        calendarMaker adapter = new calendarMaker(days);
        calendarGrid.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView places_category = findViewById(R.id.places_category);
        places_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent placesIntent = new Intent(MainActivity.this, PlacesActivity.class);
                startActivity(placesIntent);
            }
        });

        TextView restaurants_category = findViewById(R.id.restaurants_category);
        restaurants_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurantIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(restaurantIntent);
            }
        });

        TextView events_category = findViewById(R.id.events_category);
        events_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eventsIntent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(eventsIntent);
            }
        });

        TextView miscellaneous_category = findViewById(R.id.miscellaneous_category);
        miscellaneous_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miscellaneousActivity = new Intent(MainActivity.this, MiscellaneousActivity.class);
                startActivity(miscellaneousActivity);
            }
        });
    }
}

package com.example.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_category);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Detail> details = new ArrayList<Detail>();

        details.add(new Detail("Sunburn 2019", "27 Dec-29 Dec | 18:00-23:00",
                "Vagator, Goa", "Music" ));

        details.add(new Detail("Hip Hop Samachar Featuring DJ Ryan Nogar 2020",
                "9 Jan | 21:00-23:59","Baga, Goa", "Dance"));

        details.add(new Detail("Goa Ecstatic Dance Festival 2020",
                "10 Jan-15 Jan | 14:00 onwards", "Arambol, Goa","Dance"));

        details.add(new Detail("International Conference on Science Engineering & Technology 2020",
                "12 Jan | 10:00-18:00", "Panjim, Goa", "Informative"));

        details.add(new Detail("I-RUN GOA MARATHON 3rd Edition 2020","12 Jan | 5:00-10:00",
                "Taleigao, Goa", "Physical"));

        details.add(new Detail("Bicycle Parade 2020", "26 Jan | 9:00-12:00",
                "Ponda, Panjim", "Cycling"));

        details.add(new Detail("Goa Yoga Festival 2020", "27 Jan-31 Jan | 8:00-22:00",
                "Arambol, Goa", "Physical"));

        details.add(new Detail("Goa Carnival 2020", "22 Feb-25 Feb",
                "Panjim, Vasco, Margao, Benaulim","Entertainment"));

        ListView lvParent =  findViewById(R.id.lvParent);

        DetailAdapter myAdapter = new DetailAdapter(EventsActivity.this, details,
                R.color.events_category);

        lvParent.setAdapter(myAdapter);

        lvParent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" + details.get(position).getAddress()));

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }
}

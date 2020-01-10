package com.example.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_category);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Detail> details = new ArrayList<Detail>();

        details.add(new Detail("Spice Traders", "11:00-15:30 | 18:00-23:00",
                "Vagator, Goa", R.drawable.restaurant1));
        details.add(new Detail("Chef Cantando", "11:00-15:00 | 18:30-22:30",
                "Anjuna, Goa", R.drawable.restaurant2));
        details.add(new Detail("Zest", "11:30-15:30 | 18:00-23:00",
                "Palolem, Goa", R.drawable.restaurant3));
        details.add(new Detail("Go With The Flow", "11:00-14:30 | 18:00-23:30",
                "Baga, Goa", R.drawable.restaurant4));
        details.add(new Detail("Yaki Zushi", "12:00-16:00 | 19:00-23:30",
                "Sangolda, Goa", R.drawable.restaurant5));
        details.add(new Detail("The CornorStone Grill", "11:00-15:00 | 17:00-23:00",
                "Utorda, Goa", R.drawable.restaurant6));
        details.add(new Detail("Ourem 88","11:00-15:00 | 18:00-23:00",
                "Palolem, Goa", R.drawable.restaurant7));
        details.add(new Detail("Jardin d'Ulysse","11:00-15:00 | 19:00-23:30",
                "Morjim, Goa", R.drawable.restaurant8));

        ListView lvParent =  findViewById(R.id.lvParent);

        DetailAdapter myAdapter = new DetailAdapter(RestaurantsActivity.this, details,
                R.color.restaurant_category);

        lvParent.setAdapter(myAdapter);

        lvParent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" + details.get(position).getAddress()));
                startActivity(mapIntent);
            }
        });
    }
}

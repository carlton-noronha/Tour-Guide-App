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

public class PlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_category);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Detail> details = new ArrayList<Detail>();

        details.add(new Detail("Aguada Fort", "8:30-17:30", "Candolim, Goa",
                R.drawable.places1));
        details.add(new Detail("Basilica of Bom Jesus", "8:00-21:00",
                "Old Goa, Goa", R.drawable.places2));
        details.add(new Detail("Dudhsagar Falls", "N/A", "Sonaulim, Goa",
                R.drawable.places3));
        details.add(new Detail("Anjuna Beach", "10:00-19:00", "Anjuna, Goa",
                R.drawable.places4));
        details.add(new Detail("Fontainhas Heritage", "8:00-18:00",
                "Panjim, Goa", R.drawable.places5));
        details.add(new Detail("Bondla Wildlife Sanctuary", "10:00-17:00",
                "Usgao-Ganjem VP, Goa", R.drawable.places6));
        details.add(new Detail("Salim Ali Bird Sanctuary","10:00-18:00",
                "Chorao Island, Ilhas, Ribandar, Goa", R.drawable.places7));
        details.add(new Detail("Se Cathedral","8:00-20:00","Velha, Goa",
                R.drawable.places8));
        details.add(new Detail("Goa State Museum", "9:00-18:00","Panaji, Goa",
                R.drawable.places9));

        ListView lvParent =  findViewById(R.id.lvParent);

        DetailAdapter myAdapter = new DetailAdapter(PlacesActivity.this, details,
                R.color.places_category);

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

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

public class MiscellaneousActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_category);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Detail> details = new ArrayList<Detail>();

        details.add(new Detail("Vishal Mega Mart", "9:00-22:30",
                "Panjim, Margao, Dabolim", R.drawable.miscellaneous1));
        details.add(new Detail("Vaz Enterprises Liquor Store", "10:00-23:00",
                "Colva, Margao", R.drawable.miscellaneous2));
        details.add(new Detail("Mall De Goa", "9:30-22:30", "Porvorim, Goa",
                R.drawable.miscellaneous3));
        details.add(new Detail("Caculo Mall", "10:00-22:00", "Panjim, Goa",
                R.drawable.miscellaneous4));
        details.add(new Detail("Aline's Beauty Care & Spa Miramar", "10:00-22:00",
                "Panjim, Goa", R.drawable.miscellaneous5));
        details.add(new Detail("Fitness Five", "6:00-21:00",
                "Miramar, Goa", R.drawable.miscellaneous6));

        ListView lvParent =  findViewById(R.id.lvParent);

        DetailAdapter myAdapter = new DetailAdapter(MiscellaneousActivity.this, details,
                R.color.miscellaneous_category);

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

package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class DetailAdapter extends ArrayAdapter<Detail> {

    private int backgroundColorResourceId;

    public DetailAdapter(Context context, ArrayList<Detail> detail, int backgroundColorResourceId){
        super(context,0,detail);
        this.backgroundColorResourceId = backgroundColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_items,parent,
                    false);
        }

        Detail detail = getItem(position);

        LinearLayout colorLinearLayout = listView.findViewById(R.id.details_linear_layout);
        colorLinearLayout.setBackgroundColor(ContextCompat.getColor(getContext(),
                backgroundColorResourceId));

        TextView name = listView.findViewById(R.id.name_text_view);
        name.setText(detail.getName());

        TextView address = listView.findViewById(R.id.address_text_view);
        address.setText(detail.getAddress());

        TextView type = listView.findViewById(R.id.type_text_view);

        TextView timings = listView.findViewById(R.id.timings_text_view);
        timings.setText(detail.getTimings());

        ImageView icon = listView.findViewById(R.id.icon);

        if(!(detail.hasImage())){
            type.setVisibility(View.GONE);
            icon.setImageResource(detail.getImageResourceId());
            icon.setVisibility(View.VISIBLE);
        }
        else{
            icon.setVisibility(View.GONE);
            type.setText(detail.getType());
            type.setVisibility(View.VISIBLE);
        }

        return listView;
    }
}

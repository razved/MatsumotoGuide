package com.example.android.matsumotoguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.android.matsumotoguide.Place;
//import com.example.android.matsumotoguide.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaceAdapter extends ArrayAdapter<Place> {


    public PlaceAdapter(Activity context, ArrayList<com.example.android.matsumotoguide.Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.place_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        com.example.android.matsumotoguide.Place currentPlace = getItem(position);
        holder.name.setText(currentPlace.getName());
        holder.description.setText(currentPlace.getShortDescription());
        holder.image.setImageResource(currentPlace.getImage());

        return convertView;
    }

    /**
     * The ViewHolder class handle our Views (in place_item.xml)
     */
    static class ViewHolder{
        //make link with views
        @BindView(R.id.name) TextView name;
        @BindView(R.id.description) TextView description;
        @BindView(R.id.image) ImageView image;
        //constructor
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

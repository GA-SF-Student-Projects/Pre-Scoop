package com.example.anthony.prescoop.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anthony.prescoop.R;
import com.example.anthony.prescoop.models.PreSchool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 3/12/16.
 */

//TODO can now delete this file
//this has been replaced with the cursor adapter
public class SchoolListAdapter extends ArrayAdapter<PreSchool> {
    List<PreSchool> schools;


    public SchoolListAdapter(Context context, ArrayList<PreSchool> objects) {
        super(context, -1, objects);
        this.schools = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);

        rowItem.setBackgroundColor(Color.WHITE);
        TextView schoolNameTextView = (TextView) rowItem.findViewById(R.id.name_text_list_items);
        TextView schoolAddressTextView = (TextView) rowItem.findViewById(R.id.address_text_list_items);
        ImageView schoolRatingImageView = (ImageView) rowItem.findViewById(R.id.rating_image_list_items);

        PreSchool preschool = schools.get(position);

        schoolNameTextView.setText(preschool.getName());
        schoolAddressTextView.setText(preschool.getStreetAddress());

        if (preschool.getRating() == 5) {
            schoolRatingImageView.setImageResource(R.drawable.five_stars);
        } else if (preschool.getRating() == 4) {
            schoolRatingImageView.setImageResource(R.drawable.four_stars);
        } else if (preschool.getRating() == 3) {
            schoolRatingImageView.setImageResource(R.drawable.three_stars);
        } else if (preschool.getRating() == 2) {
            schoolRatingImageView.setImageResource(R.drawable.two_stars);
        }else if (preschool.getRating() == 1) {
            schoolRatingImageView.setImageResource(R.drawable.one_star);
        }

        return rowItem;
    }
}
package com.example.centrereservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class List_Adapter_centre extends ArrayAdapter<center> {
    public List_Adapter_centre(Context context,ArrayList<center> center_ArrayList)
    {
        super(context,R.layout.list_des_centeres,center_ArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        center center1=getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_des_centeres,parent,false);
        }
        ImageView image_centre1=convertView.findViewById(R.id.img_center);
        TextView nom_centre=convertView.findViewById(R.id.name_center);
        TextView des_centre=convertView.findViewById(R.id.desc_center);
        image_centre1.setImageResource(center.image_centre);
        nom_centre.setText(center.name_center);
        des_centre.setText(center.descre_centre);


        return super.getView(position, convertView, parent);
    }
}

package com.example.digdig.creategriedviewexemple.model;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digdig.creategriedviewexemple.R;

import java.util.ArrayList;

/**
 * Created by digdig on 17-05-18.
 */

public class CustomNumberAdapter extends BaseAdapter {
private Context context;
private ArrayList<Numbers> listOfNumbers;

    public CustomNumberAdapter(Context context, ArrayList<Numbers> listOfNumbers) {
        this.context = context;
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public int getCount() {
        return listOfNumbers.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfNumbers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position!=2)
        {
            TextView textView =  new TextView(context);
            textView.setTextColor(Color.RED);
            Numbers numberObj = (Numbers)getItem(position);
            textView.setText(numberObj.toString());
            textView.setTextColor(numberObj.getTextColor());
            textView.setTextSize(30);
            textView.setGravity(Gravity.CENTER);
            return  textView;

        }
        else
        {
            ImageView imageView = new ImageView(context);
            //imageView.setImageResource(R.drawable.car0);
            imageView.setImageResource(R.mipmap.ic_launcher);
            return imageView;

        }

    }
}

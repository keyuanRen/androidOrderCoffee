package com.example.kyousukeg.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class ProductsAdapter extends ArrayAdapter<productsInfo> {

    public ProductsAdapter(Context context, ArrayList<productsInfo> product)
    {
        super(context, R.layout.row_listview_product, R.id.nameText, product);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View view = layoutInflater.inflate(R.layout.row_listview_product, parent,false);

        TextView nameText = (TextView)view.findViewById(R.id.nameText);
        TextView priceText = (TextView)view.findViewById(R.id.priceText);

        productsInfo product = getItem(position);

        nameText.setText(product.getName());
        priceText.setText(String.format("$%.2f",product.getPrice()));

        return view;
    }

}

package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class shoppingCartFragment extends Fragment {

    ListView listView;
    ProductsAdapter adapter;
    ArrayList<productsInfo> products = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_shopping_cart,container,false);

        products.add(new productsInfo("Long Black",3.5));

        listView = (ListView)view.findViewById(R.id.orderProductList);

        adapter = new ProductsAdapter(getActivity(),products);

        listView.setAdapter(adapter);

        Button buttonOrderConfirm =(Button)view.findViewById(R.id.confirmOrder);
        buttonOrderConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), orderConfirmActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }
}

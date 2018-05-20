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

public class homepageFragment extends Fragment {
    //later design
    //Button editButtonSearchMap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =  inflater.inflate(R.layout.fragment_homepage,container,false);

        Button buttonSearchName =(Button)view.findViewById(R.id.buttonSearchName);

        buttonSearchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), shopListActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class useraccountFragment extends Fragment {

    DatabaseBasic db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_useraccount,container,false);

        db = new DatabaseBasic(getActivity());

        if(db.userLogin == true) {
            TextView username = (TextView) v.findViewById(R.id.accountUsername);
            String currentUsername = getActivity().getIntent().getExtras().getString("Username");
            username.setText("Hi "+currentUsername);
        }

        return v;
    }
}

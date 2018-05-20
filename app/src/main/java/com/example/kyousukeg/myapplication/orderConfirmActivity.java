package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class orderConfirmActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        button = (Button)findViewById(R.id.backToHomePage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backHomeIntent = new Intent(orderConfirmActivity.this , MainActivity.class);
                orderConfirmActivity.this.startActivity(backHomeIntent);
            }
        });
    }
}

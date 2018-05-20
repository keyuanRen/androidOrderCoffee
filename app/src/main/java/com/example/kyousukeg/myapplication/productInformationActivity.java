package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class productInformationActivity extends AppCompatActivity {

    Button buttonAddTOFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_information);

        buttonAddTOFavorite = (Button)findViewById(R.id.saveProductToOrderList);
        buttonAddTOFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFavoriteIntent = new Intent(productInformationActivity.this, shoppingCartFragment.class);
                productInformationActivity.this.startActivity(toFavoriteIntent);
            }
        });
    }
}

package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class productInformationActivity extends AppCompatActivity {

    Button buttonAddTOShoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_information);


    }

    public void ConfirmOrder(View view) {
        try
        {
            TextView productName = (TextView)findViewById(R.id.productName);
            TextView productPrice = (TextView)findViewById(R.id.productPrice);

            String name = productName.getText().toString();
            double price =Double.parseDouble(productPrice.getText().toString());

            productsInfo newProducts = new productsInfo(name, price);

            Intent databack = new Intent();

            databack.putExtra("newProducts",newProducts);

            setResult(RESULT_OK,databack);

            finish();

        }
        catch(Exception ex)
        {
            Toast.makeText(this,"Add TO Cart Success!!",Toast.LENGTH_LONG).show();
        }

        buttonAddTOShoppingCart = (Button)findViewById(R.id.saveProductToOrderList);
        buttonAddTOShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFavoriteIntent = new Intent(productInformationActivity.this, MainActivity.class);
                productInformationActivity.this.startActivity(toFavoriteIntent);
            }
        });
    }
}

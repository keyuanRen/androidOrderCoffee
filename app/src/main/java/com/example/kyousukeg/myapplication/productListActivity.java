package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class productListActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        ActionBar actionBar = getSupportActionBar();
        TextView mDetailTv = findViewById(R.id.shopName);

        //get data from previous activity when item of listView is clicked using intent
        Intent intent = getIntent();
        String mActionBatTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentTv");

        //set actionbar title
        actionBar.setTitle(mActionBatTitle);
        //set text in textView
        mDetailTv.setText(mContent);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);

        //set Event
        setSingleEvent(mainGrid);

    }

    private void setSingleEvent(GridLayout mainGrid)
    {
        //loop all child item of Main Grid
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(productListActivity.this,"Clicked at index"+finalI,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(productListActivity.this, productInformationActivity.class);
                    productListActivity.this.startActivity(intent);
                }
            });
        }
    }

}

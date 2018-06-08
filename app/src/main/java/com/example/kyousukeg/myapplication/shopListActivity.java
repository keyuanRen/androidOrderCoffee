package com.example.kyousukeg.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

public class shopListActivity extends AppCompatActivity {

    ListView listView;
    listViewShopAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<model_shopList> arrayList = new ArrayList<model_shopList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Shop List");

        title = new String[]{"Coffee1","Coffee2","Coffee3","Coffee4","Coffee5"};
        description = new String[]{"Coffee1 details","Coffee2 details","Coffee3 details","Coffee4 details","Coffee5 details"};
        icon = new int[]{R.drawable.icon1,R.drawable.icon2,R.drawable.icon3,R.drawable.icon4,R.drawable.icon5};

        listView = findViewById(R.id.shopList);

        for(int i = 0; i<title.length; i++)
        {
            model_shopList model = new model_shopList(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewShopAdapter class
        adapter = new listViewShopAdapter(this,arrayList);

        //bind the adapter to the listView
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_search_shop_bar,menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText))
                {
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else
                {
                    adapter.filter(newText);
                }
                return true ;
            }
        });

        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_setting)
        {
            //do functionality here
            Intent intent = new Intent(shopListActivity.this, productListActivity.class);
            shopListActivity.this.startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/
}

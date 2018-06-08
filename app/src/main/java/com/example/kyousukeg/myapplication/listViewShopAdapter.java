package com.example.kyousukeg.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class listViewShopAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<model_shopList> modellist;
    ArrayList<model_shopList> arrayList;

    //constructor
    public listViewShopAdapter(Context context, List<model_shopList> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<model_shopList>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }


    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_listview_shop,null);

            //locate the views in shop_row.xml
            holder.mTitleTv = convertView.findViewById(R.id.mainTitle);
            holder.mDescTv = convertView.findViewById(R.id.mainDescription);
            holder.mIconIv = convertView.findViewById(R.id.mainIcon);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        //set the results into textView
        holder.mTitleTv.setText(modellist.get(position).getTitle());
        holder.mDescTv.setText(modellist.get(position).getTitle());
        //set the result in imageView
        holder.mIconIv.setImageResource(modellist.get(position).getIcon());

        //listView item clicks
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modellist.get(position).getTitle().equals("Coffee1"))
                {
                    //start NewActivity with title for actionbar and text for textView
                    Intent intent = new Intent(mContext, productListActivity.class);
                    intent.putExtra("actionBarTitle", "Coffee1");
                    //intent.putExtra("contentTV","Price: $5.00");
                    mContext.startActivity(intent);

                }
                if (modellist.get(position).getTitle().equals("Coffee2"))
                {
                    //start NewActivity with title for actionbar and text for textView
                    Intent intent = new Intent(mContext, productListActivity.class);
                    intent.putExtra("actionBarTitle", "Coffee2");
                    //intent.putExtra("contentTV","Price: $5.00");
                    mContext.startActivity(intent);

                }
                if (modellist.get(position).getTitle().equals("Coffee3"))
                {
                    //start NewActivity with title for actionbar and text for textView
                    Intent intent = new Intent(mContext, productListActivity.class);
                    intent.putExtra("actionBarTitle", "Coffee3");
                    //intent.putExtra("contentTV","Price: $5.00");
                    mContext.startActivity(intent);

                }if (modellist.get(position).getTitle().equals("Coffee4"))
                {
                    //start NewActivity with title for actionbar and text for textView
                    Intent intent = new Intent(mContext, productListActivity.class);
                    intent.putExtra("actionBarTitle", "Coffee4");
                    //intent.putExtra("contentTV","Price: $5.00");
                    mContext.startActivity(intent);

                }if (modellist.get(position).getTitle().equals("Coffee5"))
                {
                    //start NewActivity with title for actionbar and text for textView
                    Intent intent = new Intent(mContext, productListActivity.class);
                    intent.putExtra("actionBarTitle", "Coffee5");
                    //intent.putExtra("contentTV","Price: $5.00");
                    mContext.startActivity(intent);

                }


            }
        });

        return convertView;
    }

    //filter
    public void filter(String charText)
    {
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if(charText.length() == 0)
        {
            modellist.addAll(arrayList);
        }
        else
        {
            for (model_shopList model_shop : arrayList)
            {
                if (model_shop.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText))
                {
                    modellist.add(model_shop);
                }
            }
        }
        notifyDataSetChanged();
    }

}

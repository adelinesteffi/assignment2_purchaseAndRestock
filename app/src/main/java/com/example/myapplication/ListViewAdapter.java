package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {


     List<StockItem> AvailableitemList;
            //= ((MyApp) context.getApplicationContext()).getAppStockList();
     Context activityContext;





    public ListViewAdapter(List<StockItem> itemList, Context context) {
        this.AvailableitemList = itemList;
        activityContext = context;
    }

    @Override
    public int getCount() {
        return AvailableitemList.size();
    }

    @Override
    public Object getItem(int position) {
        return  AvailableitemList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //if (convertView == null) {
            View availableRowView = LayoutInflater.from(activityContext).inflate(R.layout.list_view_items, parent, false);
        //}

        StockItem currentItem = AvailableitemList.get(position);

        TextView itemNameTextView = availableRowView.findViewById(R.id.intemTextView);
        itemNameTextView.setText(currentItem.getItemName());

        TextView AvlQntyTextView = availableRowView.findViewById(R.id.qntyAvailTextView);
        AvlQntyTextView.setText(String.valueOf(currentItem.getQtyInStock()));

        TextView CostTextView = availableRowView.findViewById(R.id.costTextView);
        String stringValue = String.valueOf(currentItem.getUnitPrice());
        CostTextView.setText(stringValue);
        return availableRowView;
    }
}

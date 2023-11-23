package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

//((MyApp) getApplication()).appHistoryList
public class HistoryListActivity extends AppCompatActivity implements HistoryRecyclerAdapter.HistoryClickListener {
    ArrayList<HistoryListItem> HistoryData;
    HistoryRecyclerAdapter adapter;
    RecyclerView historyRecyclerView;
Button historyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);


        HistoryData =  ((MyApp)getApplication()).appHistoryList; // data

        historyRecyclerView = findViewById(R.id.recyclerlist);
        adapter = new HistoryRecyclerAdapter(HistoryData,this);
        adapter.listener = this; // step 4
        historyRecyclerView.setAdapter(adapter);
        // todoRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

//    @Override
//    public void onClick(View v) {
//
//    }

    @Override
    public void onHistoryClicked(int i) {
        Toast.makeText(this,HistoryData.get(i).getItemPurchased(),Toast.LENGTH_LONG).show();
        String product= HistoryData.get(i).getItemPurchased();
        String Price= String.format("%.2f",HistoryData.get(i).getTotalPurchaseCost());
        String time= HistoryData.get(i).getPurchaseTime();
        Intent detailHistoryIntent = new Intent(HistoryListActivity.this, DetailHistoryActivity.class);
        detailHistoryIntent.putExtra("detail","Product:"+product+"\nPrice:"+Price+"\nPurchaseDate:"+time);
       // parent.getChildAt(i).setBackgroundColor(getColor(R.color.red));
        startActivity(detailHistoryIntent);

    }
}
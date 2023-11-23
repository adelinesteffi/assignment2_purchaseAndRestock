package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailHistoryActivity extends AppCompatActivity {
TextView detailHistory;
    ArrayList<HistoryListItem> HistoryData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        detailHistory = findViewById(R.id.HistoryDetailedTextView);
        Intent intent = getIntent();
        if (intent != null) {
            String receivedValue = intent.getStringExtra("detail");
            if (receivedValue != null) {
                // Now you can use the receivedValue in your activity
                detailHistory.setText(receivedValue);
            }
        }
        // history.setOnClickListener(this);
        detailHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });
    }
}
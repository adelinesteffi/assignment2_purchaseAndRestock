package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerPage extends AppCompatActivity {
Button history,restockButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_page);
        history = findViewById(R.id.historyBtn);
        restockButton = findViewById(R.id.RestockBtn);

       // history.setOnClickListener(this);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent historyListIntent = new Intent(ManagerPage.this,HistoryListActivity.class);
                startActivity(historyListIntent);
            }
        });

        restockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent restockListIntent = new Intent(ManagerPage.this, restockProductActivity.class);
                startActivity(restockListIntent);
            }
        });
    }


}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class restockProductActivity extends AppCompatActivity {
    Button okButton,cancelButton;
    EditText newQntyUpdateText;
    ListView newQntyUpdateList;
    StockItem appStockListClicked;
    ListViewAdapter adapter;

    Boolean listClicked;
    int QuntyOfSelectedItemInStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock_product);


        okButton = findViewById(R.id.okBtn);
        cancelButton = findViewById(R.id.cancelBtn);
        newQntyUpdateText=findViewById(R.id.newQntyTextView);
                newQntyUpdateList=findViewById(R.id.listViewToUpdateQnty);
        adapter = new ListViewAdapter(((MyApp)getApplication()).getAppStockList(), this);
        newQntyUpdateList.setAdapter(adapter);
        newQntyUpdateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                appStockListClicked = ((MyApp)getApplication()).getAppStockList().get(position) ;
              //  ProuctTypeToDisplay= appStockListClicked.getItemName();
                QuntyOfSelectedItemInStock= appStockListClicked.getQtyInStock();
              //  Double costOfItemSelected = appStockListClicked.getUnitPrice();
                Log.d("testing", "in QuntyOfSelectedItemInStock restock "+QuntyOfSelectedItemInStock);
                listClicked=true;
            //    parent.getChildAt(position).setBackgroundColor(getColor(R.color.red));
             //   if(row >= 0){ parent.getChildAt(row).setBackgroundColor(getColor(R.color.white));
                //   } parent.getChildAt(position).setBackgroundColor(getColor(R.color.Pink));
                //   row = position;
            }
        });

        // history.setOnClickListener(this);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mainPagetIntent = new Intent(restockProductActivity.this, MainActivity.class);
                startActivity(mainPagetIntent);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              String qtyEnteredByUSer= String.valueOf(newQntyUpdateText.getText());
              if(listClicked) {


                  if (isValidNumber(qtyEnteredByUSer)) {
                      int newStock = QuntyOfSelectedItemInStock + Integer.parseInt(qtyEnteredByUSer);

                      appStockListClicked.setQtyInStock(newStock);
                      newQntyUpdateText.setText("");
                      Toast.makeText(getApplicationContext(), "Stock Updated", Toast.LENGTH_SHORT).show();

                  } else {

                      Toast.makeText(getApplicationContext(), "Enter a Valid Input", Toast.LENGTH_SHORT).show();
                  }

                  adapter.AvailableitemList = ((MyApp) getApplication()).getAppStockList();
                  adapter.notifyDataSetChanged();

              }
              else
                  Toast.makeText(getApplicationContext(), "Choose the list itme to update Quantity", Toast.LENGTH_SHORT).show();
            }
        });
listClicked=false;
        newQntyUpdateText.setText("");
    }

    public boolean isValidNumber(String input) {
        // Check if the input is not empty
        if (input != null && !input.isEmpty()) {
            // Check if the input contains only numbers
            return input.matches("\\d+");
        }
        return false;
    }

}
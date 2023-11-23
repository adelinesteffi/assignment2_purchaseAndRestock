package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 TextView productText, totalText, quantityText;
 Button one, two, three, four, five, six, seven, eight, nine, zero, buy, reset, managerButton;

    String quantity="";
    String ProuctTypeToDisplay="";

    String resultStringofPrice="";
    boolean newExpression = false;
    boolean listClicked= false;
    ListViewAdapter adapter;
    Purchase purchaseObj = new Purchase();
    StockItem appStockListClicked;
    String updatedText;
    HistoryListItem hil;
    ArrayList<HistoryListItem> appHistoryListLocal= new ArrayList<HistoryListItem>(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three =findViewById(R.id.button3);
        four= findViewById(R.id.button4);
        five =findViewById(R.id.button5);
        six =findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero=findViewById(R.id.button0);
        reset=findViewById(R.id.buttonC);
        zero =findViewById(R.id.button0);
        buy=findViewById(R.id.buyButton);
        productText=findViewById(R.id.productTypeTextView);
        totalText=findViewById(R.id.totalTextView);
        quantityText=findViewById(R.id.QntytextView);
        managerButton=findViewById(R.id.managerBtn);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        reset.setOnClickListener(this);
        buy.setOnClickListener(this);
        productText.setOnClickListener(this);
        totalText.setOnClickListener(this);
        quantityText.setOnClickListener(this);
        managerButton.setOnClickListener(this);
ListView ItemList;
        ItemList = findViewById(R.id.listView);
        try {
             adapter = new ListViewAdapter(((MyApp)getApplication()).getAppStockList(), this);
            ItemList.setAdapter(adapter);
            ItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    appStockListClicked = ((MyApp)getApplication()).getAppStockList().get(position) ;
                     ProuctTypeToDisplay= appStockListClicked.getItemName();
                    int QuntyOfSelectedItemInStock= appStockListClicked.getQtyInStock();
                    Double costOfItemSelected = appStockListClicked.getUnitPrice();
                    Log.d("testing", "in onItemClick ProuctTypeToDisplay "+ProuctTypeToDisplay);
                    Log.d("testing", "in onItemClick");
                    productText.setText(ProuctTypeToDisplay);
                    listClicked=true;
                    parent.getChildAt(position).setBackgroundColor(getColor(R.color.red));
                }
            });
        } catch (NullPointerException e) {
            e.printStackTrace();
            Log.d("testing", "in NullPointerException");
            // Handle or log the exception
        }

    }

    @Override
    public void onClick(View view) {
        Log.d("testing", "in onclick");

        Button clickedButton = (Button) view;
        String buttonText = clickedButton.getText().toString();
//        if (newExpression) {
//            quantityText.setText("");
//            productText.setText("");
//            totalText.setText("");
//            //quantityText.setText(buttonText);
//            newExpression = false;
//
//        }
//        if (!listClicked) {
//            productText.setText("");
//
//        }
        Log.d("buttonText", "in buttonText " + buttonText);
        if (clickedButton != buy && clickedButton != reset && clickedButton!= managerButton) {
            String currentText = quantityText.getText().toString();
            updatedText = currentText + buttonText;
            quantityText.setText(updatedText);
        }
        if (clickedButton == reset) {
            Log.d("testing", "in reset btn clear");
            quantityText.setText("");
            productText.setText("");
            totalText.setText("");
        }
        if (clickedButton == buy) {
            Log.d("testing", "in buy btn buy");
            if (!listClicked || updatedText.isEmpty()) {
                Toast.makeText(this, "All fields are required ", Toast.LENGTH_SHORT).show();
                //newExpression = true;
                // listClicked = false;
            } else  {
                //(listClicked && !updatedText.isEmpty())
                // newExpression = true;
                quantity = quantityText.getText().toString();
                int quantityValue = Integer.parseInt(quantity);
                //if (listClicked && !TextUtils.isEmpty(quantity)) {
                // if (purchaseObj.isStockAvailable(quantityValue, appStockListClicked.getQtyInStock())) {
                if (appStockListClicked.getQtyInStock() >= quantityValue) {
                    appStockListClicked.setQtyInStock(appStockListClicked.getQtyInStock() - quantityValue);
                    double totalToSet = quantityValue * appStockListClicked.getUnitPrice();
                    String resultStringofPrice = String.format("%.2f", totalToSet);
                    totalText.setText(resultStringofPrice);
                    adapter.AvailableitemList = ((MyApp) getApplication()).getAppStockList();
                    AlertDialog.Builder b = new AlertDialog.Builder(this);
                    String AlertMsg = "Thank you for your purchase \n Your purchase is " + quantity + " " + ProuctTypeToDisplay + " for " + resultStringofPrice;
                    b.setMessage(AlertMsg);
                    b.create().show();
                    //alert
                    adapter.notifyDataSetChanged();
                    Date purchaseTime= Calendar.getInstance().getTime();
                    hil=new HistoryListItem(ProuctTypeToDisplay,totalToSet,quantityValue,purchaseTime.toString());
                    ((MyApp) getApplication()).appHistoryList.add(hil);


                } else {
                    Toast.makeText(this, "No enough quantity in stock", Toast.LENGTH_SHORT).show();

                    // newExpression = true;
                }
            }
//            else {
//
//                Toast.makeText(this, "All fields are required ", Toast.LENGTH_SHORT).show();
//                //newExpression = true;
//            }

            // listClicked = false;

            listClicked = false;
           // newExpression = true;
            quantityText.setText("");
            productText.setText("");
            totalText.setText("");
            updatedText="";

        }
        if (clickedButton == managerButton)
        {
Intent managerIntent = new Intent(MainActivity.this, ManagerPage.class);
            startActivity(managerIntent);

    }
    }
}
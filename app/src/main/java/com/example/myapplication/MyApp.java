package com.example.myapplication;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application {

    ArrayList<StockItem> appStockList;

    ArrayList<HistoryListItem> appHistoryList= new ArrayList<HistoryListItem>(0);
    public ArrayList<StockItem> getAppStockList() {

        if(appStockList == null){
            appStockList = new ArrayList<>(3);
            appStockList.add(new StockItem("Pant",20.44,10));
            appStockList.add(new StockItem("Shoes",10.44,100));
            appStockList.add(new StockItem("Hats",5.9,30));


        }
        return appStockList;
    }





}

package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class StockItem {

    public StockItem(String itemName, Double unitPrice, int qtyInStock) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.qtyInStock = qtyInStock;
    }

    String itemName;
Double unitPrice;
    int qtyInStock;
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }





}

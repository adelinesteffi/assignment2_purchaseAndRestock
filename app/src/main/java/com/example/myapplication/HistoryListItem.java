package com.example.myapplication;

public class HistoryListItem {

    public HistoryListItem(String itemPurchased, Double totalPurchaseCost, int qtyPurchased, String purchaseTime) {
        this.itemPurchased = itemPurchased;
        this.totalPurchaseCost = totalPurchaseCost;
        this.qtyPurchased = qtyPurchased;
        this.purchaseTime = purchaseTime;
    }

    String itemPurchased;
    Double totalPurchaseCost;
    int qtyPurchased;

    public String getItemPurchased() {
        return itemPurchased;
    }

    public void setItemPurchased(String itemPurchased) {
        this.itemPurchased = itemPurchased;
    }

    public Double getTotalPurchaseCost() {
        return totalPurchaseCost;
    }

    public void setTotalPurchaseCost(Double totalPurchaseCost) {
        this.totalPurchaseCost = totalPurchaseCost;
    }

    public int getQtyPurchased() {
        return qtyPurchased;
    }

    public void setQtyPurchased(int qtyPurchased) {
        this.qtyPurchased = qtyPurchased;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    String purchaseTime;

}

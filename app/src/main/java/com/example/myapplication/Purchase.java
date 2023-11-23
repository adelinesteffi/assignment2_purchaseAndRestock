package com.example.myapplication;

import android.util.Log;

public class Purchase {

    boolean validated = false;
    public  boolean isStockAvailable(int UserQnty,int AvailableQnty){

        Log.d("testing","in validate UserQnty"+UserQnty+" AvailableQnty "+AvailableQnty);
        if(AvailableQnty>=UserQnty)
        {
            validated = true;

        }
        return  validated;
    }

}

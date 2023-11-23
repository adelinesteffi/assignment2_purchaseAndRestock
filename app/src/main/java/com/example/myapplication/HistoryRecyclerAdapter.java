package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryRecyclerAdapter  extends
        RecyclerView.Adapter<HistoryRecyclerAdapter.HistoryViewHolder>
{
    interface HistoryClickListener{ // step 1
        void onHistoryClicked(int i);

    }

    ArrayList<HistoryListItem> history_list;
    Context context;
    HistoryClickListener listener;// step 2

    public HistoryRecyclerAdapter(ArrayList<HistoryListItem> history_list, Context context) {
        this.history_list = history_list;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_view_items,parent,false);
        return  new HistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        TextView history_item_selcted = holder.itemView.findViewById(R.id.intemTextView);
        TextView qnty_item_selcted = holder.itemView.findViewById(R.id.qntyAvailTextView);
        TextView total_cost_item_selcted = holder.itemView.findViewById(R.id.costTextView);
        history_item_selcted.setText(history_list.get(position).getItemPurchased());
        String qtyPurchased = String.valueOf(history_list.get(position).getQtyPurchased());
        qnty_item_selcted.setText(qtyPurchased);
        String resultStringofFinalCost = String.format("%.2f", history_list.get(position).getTotalPurchaseCost());
        total_cost_item_selcted.setText(resultStringofFinalCost);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onHistoryClicked(holder.getAdapterPosition()); // step 5
            }
        });
    }

    @Override
    public int getItemCount() {
        return history_list.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}

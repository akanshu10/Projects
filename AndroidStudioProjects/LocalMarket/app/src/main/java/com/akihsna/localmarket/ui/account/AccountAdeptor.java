package com.akihsna.localmarket.ui.account;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.CategoryActivity;
import com.akihsna.localmarket.ui.home.categoryAdeptor;

import java.util.List;

public class AccountAdeptor extends RecyclerView.Adapter<AccountAdeptor.ViewHolder> {
    private List<AccountModel>accountModelList;

    public AccountAdeptor(List<AccountModel> accountModelList) {
        this.accountModelList = accountModelList;
    }

    @NonNull
    @Override
    public AccountAdeptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.account_order_layout,parent,false);
        return new AccountAdeptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountAdeptor.ViewHolder holder, int position) {
        String icon=accountModelList.get(position).getViewdetails();
        String name=accountModelList.get(position).getAccountlayoutname();
        holder.setlayoutname(name);
    }

    @Override
    public int getItemCount() {
        return accountModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryname=itemView.findViewById(R.id.accountlayout);

        }

        public void setlayoutname(String name) {
            categoryname.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }
    }
}

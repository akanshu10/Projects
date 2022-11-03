package com.akihsna.chandokmarket;

import android.provider.ContactsContract;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class categoryAdeptor extends RecyclerView.Adapter<categoryAdeptor.ViewHolder> {
    private List<category_model>categoryModelList;

    public categoryAdeptor(List<category_model> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public categoryAdeptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categoty_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdeptor.ViewHolder holder, int position) {
        String icon=categoryModelList.get(position).getCatagoryiconlink();
        String name=categoryModelList.get(position).getCategoryname();
        holder.setCategoryname(name);

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView catagoryicon;
        private TextView categoryname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catagoryicon=itemView.findViewById(R.id.categoryicon);
            categoryname=itemView.findViewById(R.id.categorytext);
        }
        private void setCatagoryicon(){

        }
        private void setCategoryname(String name){
            categoryname.setText(name);

        }
    }
}

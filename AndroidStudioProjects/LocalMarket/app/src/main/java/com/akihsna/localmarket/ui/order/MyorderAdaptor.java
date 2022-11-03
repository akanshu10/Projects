package com.akihsna.localmarket.ui.order;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.CategoryActivity;

import java.util.List;

public class MyorderAdaptor extends RecyclerView.Adapter<MyorderAdaptor.ViewHolder> {

    private List<MyorderModel>myorderModelList;

    public MyorderAdaptor(List<MyorderModel> myorderModelList) {
        this.myorderModelList = myorderModelList;
    }

    @NonNull
    @Override
    public MyorderAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.myorder_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyorderAdaptor.ViewHolder holder, int position) {
        int resource=myorderModelList.get(position).getProductimage();
        String name=myorderModelList.get(position).getProductTitle();
        String deliverystatus=myorderModelList.get(position).getDeliverystatus();
        holder.setData(resource,name,deliverystatus);
    }

    @Override
    public int getItemCount() {
        return myorderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ordername;
        private ImageView orderimage;
        private ImageView deliveryindicator;
        private  TextView deliverystatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ordername=itemView.findViewById(R.id.orderitemname);
            orderimage=itemView.findViewById(R.id.orderitemimage);
            deliveryindicator=itemView.findViewById(R.id.orderstatusindicator);
            deliverystatus=itemView.findViewById(R.id.order_delivery_status);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent categoryIntent = new Intent(itemView.getContext(), orderDetailsActivity.class);
                    itemView.getContext().startActivity(categoryIntent);

                }
            });
        }
        @SuppressLint("ResourceType")
        private void setData(int resouces,String o_name,String deliverystatus1){
            ordername.setText(o_name);
            orderimage.setImageResource(resouces);
           if(deliverystatus1.equals("Cancel")){
               deliveryindicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.red)));
           }else{
               deliveryindicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.purple_200)));

            }
            deliverystatus.setText(deliverystatus1);
        }
    }
}

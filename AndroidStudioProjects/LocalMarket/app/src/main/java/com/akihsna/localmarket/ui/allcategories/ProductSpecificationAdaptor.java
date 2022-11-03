package com.akihsna.localmarket.ui.allcategories;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.akihsna.localmarket.R;

import java.util.List;

public class ProductSpecificationAdaptor extends RecyclerView.Adapter<ProductSpecificationAdaptor.ViewHolder> {

    private List<ProductSpecificationModel>productSpecificationModelList;

    public ProductSpecificationAdaptor(List<ProductSpecificationModel> productSpecificationModelList) {
        this.productSpecificationModelList = productSpecificationModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (productSpecificationModelList.get(position).getType()){
            case 0:
                return ProductSpecificationModel.SPECIFICATION_TITLE;
            case 1:
                return ProductSpecificationModel.SPECIFICATION_BODY;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public ProductSpecificationAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case ProductSpecificationModel.SPECIFICATION_TITLE:
                TextView title=new TextView(parent.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.BLACK);
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(setDp(16,parent.getContext()),
                        setDp(16,parent.getContext()),
                        setDp(16,parent.getContext()),
                        setDp(8,parent.getContext()));
                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);
                case ProductSpecificationModel.SPECIFICATION_BODY:
                    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_specification_item_layout,parent,false);
                    return new ViewHolder(view);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecificationAdaptor.ViewHolder holder, int position) {
        switch (productSpecificationModelList.get(position).getType()){
            case ProductSpecificationModel.SPECIFICATION_TITLE:
                holder.setTitle(productSpecificationModelList.get(position).getTitle());
                break;
                case ProductSpecificationModel.SPECIFICATION_BODY:
                    String featurename=productSpecificationModelList.get(position).getFeaturename();
                    String featurename1=productSpecificationModelList.get(position).getFeaturevalue();
                    holder.setFeature(featurename,featurename1);
                    break;
            default:
                return;
        }


    }

    @Override
    public int getItemCount() {
        return productSpecificationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featurename;
        private TextView featurevalue;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        private void setTitle(String titletext){
            title= (TextView) itemView;
            title.setText(titletext);
        }
        private void setFeature(String featuretitle,String featurevalue1){
            featurename=itemView.findViewById(R.id.feature_title);
            featurevalue=itemView.findViewById(R.id.feature_value);
            featurename.setText(featuretitle);
            featurevalue.setText(featurevalue1);
        }
    }
    private int setDp(int dp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }
}

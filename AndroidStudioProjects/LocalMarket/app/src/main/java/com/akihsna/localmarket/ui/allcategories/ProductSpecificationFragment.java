package com.akihsna.localmarket.ui.allcategories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akihsna.localmarket.R;

import java.util.ArrayList;
import java.util.List;


public class ProductSpecificationFragment extends Fragment {
    private RecyclerView productspecificationrecyclerview;

    public ProductSpecificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_product_specification, container, false);
        productspecificationrecyclerview=view.findViewById(R.id.product_spwcification_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        productspecificationrecyclerview.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationModel>productSpecificationModelList=new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Genral"));
        productSpecificationModelList.add(new ProductSpecificationModel("RAM","16GB",1));
        productSpecificationModelList.add(new ProductSpecificationModel("RAM","16GB",1));
        productSpecificationModelList.add(new ProductSpecificationModel("RAM","16GB",1));
        productSpecificationModelList.add(new ProductSpecificationModel("RAM","16GB",1));
        productSpecificationModelList.add(new ProductSpecificationModel("RAM","16GB",1));

        ProductSpecificationAdaptor productSpecificationAdaptor=new ProductSpecificationAdaptor(productSpecificationModelList);
        productspecificationrecyclerview.setAdapter(productSpecificationAdaptor);
        productSpecificationAdaptor.notifyDataSetChanged();
        return view;
    }
}
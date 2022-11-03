package com.akihsna.localmarket.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.localmarket.R;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    private RecyclerView cartitemrecyclerview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cart,container,false);
        cartitemrecyclerview=view.findViewById(R.id.cartreciclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartitemrecyclerview.setLayoutManager(layoutManager);

        List<CartitemModel>cartitemModelList=new ArrayList<>();
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(0,R.drawable.beauty,"Rs 8734/-","Rs 454/-",5,"Rs 4598/-"));
        cartitemModelList.add(new CartitemModel(1,"Rs 8734/-","Rs 454/-","5","Rs 40/-","Rs 4598/-"));

        CartAdaptor cartAdaptor=new CartAdaptor(cartitemModelList);
        cartitemrecyclerview.setAdapter(cartAdaptor);
        cartAdaptor.notifyDataSetChanged();

        return view;
    }
}

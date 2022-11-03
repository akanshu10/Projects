package com.akihsna.localmarket.ui.notification;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.home.HorizontalproductscrollAdeptor;
import com.akihsna.localmarket.ui.home.categoryAdeptor;
import com.akihsna.localmarket.ui.home.category_model;
import com.akihsna.localmarket.ui.home.horizontalproductmodel;
import com.akihsna.localmarket.ui.home.slider_Adeptor;
import com.akihsna.localmarket.ui.home.slider_model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationFragment extends Fragment {
    private RecyclerView recyclerView;
    private com.akihsna.localmarket.ui.home.categoryAdeptor categoryAdeptor;
    private ViewPager viewPager;
    private List<slider_model> sliderModelList;
    private  int currentpage=2;
    private Timer timer;
    final private long DELAY_TIME=3000;
    final private long PERIOD_TIME=3000;
    private FrameLayout frameLayout1;

    private ImageView stripimage;
    private ConstraintLayout stripconstraintLayout;

    private TextView layoutTitle;
    private Button viewallbutton;
    private RecyclerView horizontalscrollrecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_notification,container,false);

        stripimage=view.findViewById(R.id.stripadimage);
        stripconstraintLayout=view.findViewById(R.id.stripadcontainer);
        stripimage.setImageResource(R.drawable.beauty);

        viewPager=view.findViewById(R.id.banner_slider);
//        sliderModelList=new ArrayList<slider_model>();
//        sliderModelList.add(new slider_model(R.drawable.beauty,"#000000"));
//        sliderModelList.add(new slider_model(R.drawable.cmit2,"#000000"));
//
//        sliderModelList.add(new slider_model(R.drawable.home,"#000000"));
//        sliderModelList.add(new slider_model(R.drawable.beauty,"#000000"));
//        sliderModelList.add(new slider_model(R.drawable.cmit2,"#000000"));
//
//        sliderModelList.add(new slider_model(R.drawable.home,"#000000"));
//        sliderModelList.add(new slider_model(R.drawable.beauty,"#000000"));
//        slider_Adeptor slider_adeptor=new slider_Adeptor(sliderModelList);
//        viewPager.setAdapter(slider_adeptor);
//        viewPager.setClipToPadding(false);
//        viewPager.setPageMargin(20);
//        viewPager.setCurrentItem(currentpage);





        ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentpage=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state==ViewPager.SCROLL_STATE_IDLE);
                pagelooper();
            }
        };
        viewPager.addOnPageChangeListener(onPageChangeListener);
        startbannerslideshow();
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pagelooper();
                stopbanner();
                if(event.getAction()==MotionEvent.ACTION_UP){
                    startbannerslideshow();
                }
                return false;
            }
        });

        layoutTitle=view.findViewById(R.id.horizontalscreentext);
        viewallbutton=view.findViewById(R.id.horizontalscreenbutton);
        horizontalscrollrecyclerView=view.findViewById(R.id.horizontalscreenrecycler);

//        List<horizontalproductmodel>horizontalproductmodelList=new ArrayList<>();
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
//        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));

        //HorizontalproductscrollAdeptor horizontalproductscrollAdeptor=new HorizontalproductscrollAdeptor(horizontalproductmodelList);
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(view.getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalscrollrecyclerView.setLayoutManager(linearLayoutManager2);
       // horizontalscrollrecyclerView.setAdapter(horizontalproductscrollAdeptor);
       // horizontalproductscrollAdeptor.notifyDataSetChanged();

        recyclerView=view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager1);
        List<category_model> categoryModelList=new ArrayList<category_model>();
        categoryModelList.add(new category_model("link","All categories"));
        categoryModelList.add(new category_model("link","Home"));
        categoryModelList.add(new category_model("link","Fashion"));
        categoryModelList.add(new category_model("link","Beauty"));
        categoryModelList.add(new category_model("link","Mobiles"));
        categoryModelList.add(new category_model("link","Appliences"));
        categoryModelList.add(new category_model("link","Toys"));
        categoryModelList.add(new category_model("link","Food&sweets"));
        categoryModelList.add(new category_model("link","sports"));
        categoryModelList.add(new category_model("link","Clothes"));


        categoryAdeptor =new categoryAdeptor(categoryModelList);
        recyclerView.setAdapter(categoryAdeptor);
        categoryAdeptor.notifyDataSetChanged();


        return view;
    }
    private void pagelooper(){
        if(currentpage==sliderModelList.size()-2){
            currentpage =2;
            viewPager.setCurrentItem(currentpage,false);
        }
        if(currentpage==1){
            currentpage =sliderModelList.size()-3;
            viewPager.setCurrentItem(currentpage,false);
        }
    }
    private void startbannerslideshow(){
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if(currentpage>=sliderModelList.size()){
                    currentpage=1;
                }
                viewPager.setCurrentItem(currentpage++,true);
            }
        } ;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },DELAY_TIME,PERIOD_TIME);
    }
    private void stopbanner(){
        timer.cancel();
    }

}

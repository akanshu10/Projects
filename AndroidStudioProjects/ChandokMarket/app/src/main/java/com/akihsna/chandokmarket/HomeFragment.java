package com.akihsna.chandokmarket;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private categoryAdeptor categoryAdeptor;
    private ViewPager viewPager;
    private List<slider_model>sliderModelList;
    private  int currentpage=2;
    private Timer timer;
    final private long DELAY_TIME=3000;
    final private long PERIOD_TIME=3000;

    private TextView layoutTitle;
    private Button viewallbutton;
    private RecyclerView horizontalscrollrecyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<category_model>categoryModelList=new ArrayList<category_model>();
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


        viewPager=view.findViewById(R.id.banner_slider);
        sliderModelList=new ArrayList<slider_model>();
        sliderModelList.add(new slider_model(R.drawable.beauty,"#000000"));
        sliderModelList.add(new slider_model(R.drawable.cmit2,"#000000"));

        sliderModelList.add(new slider_model(R.drawable.home,"#000000"));
        sliderModelList.add(new slider_model(R.drawable.beauty,"#000000"));
        sliderModelList.add(new slider_model(R.drawable.cmit2,"#000000"));

        sliderModelList.add(new slider_model(R.drawable.home,"#000000"));
        sliderModelList.add(new slider_model(R.drawable.beauty,"#000000"));
        slider_Adeptor slider_adeptor=new slider_Adeptor(sliderModelList);
        //viewPager.setAdapter(slider_adeptor);
        //viewPager.setClipToPadding(false);
        //viewPager.setPageMargin(20);
       /* ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
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
        };*/
        //viewPager.addOnPageChangeListener(onPageChangeListener);
        //startbannerslideshow();
        /*viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pagelooper();
                stopbanner();
                if(event.getAction()==MotionEvent.ACTION_UP){
                    startbannerslideshow();
                }
                return false;
            }
        });*/

        layoutTitle=view.findViewById(R.id.horizontalscreentext);
        viewallbutton=view.findViewById(R.id.horizontalscreenbutton);
        horizontalscrollrecyclerView=view.findViewById(R.id.horizontalscreenrecycler);

        List<horizontalproductmodel>horizontalproductmodelList=new ArrayList<>();
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));
        horizontalproductmodelList.add(new horizontalproductmodel(R.drawable.pic,"redmi 5a","hello","5000"));

        HorizontalproductscrollAdeptor horizontalproductscrollAdeptor=new HorizontalproductscrollAdeptor(horizontalproductmodelList);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(view.getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalscrollrecyclerView.setLayoutManager(linearLayoutManager1);
        horizontalscrollrecyclerView.setAdapter(horizontalproductscrollAdeptor);
        horizontalproductscrollAdeptor.notifyDataSetChanged();




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
                //viewPager.setCurrentItem(currentpage++,true);
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
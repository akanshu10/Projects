package com.akihsna.localmarket.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.akihsna.localmarket.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private categoryAdeptor categoryAdeptor;
    private ViewPager viewPager;
    private List<slider_model>sliderModelList;
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


    private List<category_model> categoryModelList;
    private FirebaseFirestore firebaseFirestore;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);


        stripimage=view.findViewById(R.id.stripadimage);
        stripconstraintLayout=view.findViewById(R.id.stripadcontainer);
        stripimage.setImageResource(R.drawable.beauty);
        stripimage.setBackgroundColor(Color.parseColor("#000000"));
        viewPager=view.findViewById(R.id.banner_slider);
        sliderModelList=new ArrayList<slider_model>();
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
//
//        HorizontalproductscrollAdeptor horizontalproductscrollAdeptor=new HorizontalproductscrollAdeptor(horizontalproductmodelList);
//        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(view.getContext());
//        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
//        horizontalscrollrecyclerView.setLayoutManager(linearLayoutManager2);
//        horizontalscrollrecyclerView.setAdapter(horizontalproductscrollAdeptor);
//        horizontalproductscrollAdeptor.notifyDataSetChanged();

        recyclerView=view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager1);




        categoryModelList=new ArrayList<category_model>();

        categoryAdeptor =new categoryAdeptor(categoryModelList);
        recyclerView.setAdapter(categoryAdeptor);


          firebaseFirestore=FirebaseFirestore.getInstance();
          firebaseFirestore.collection("Categories").orderBy("index").get()
                  .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                      @Override
                      public void onComplete(@NonNull Task<QuerySnapshot> task) {
                          if(task.isSuccessful()){
                              for (QueryDocumentSnapshot queryDocumentSnapshot:task.getResult()){
                                  categoryModelList.add(new category_model(queryDocumentSnapshot.get("icon").toString(),queryDocumentSnapshot.get("title").toString()));
                              }
                              categoryAdeptor.notifyDataSetChanged();
                          }else
                          {
                              String error=task.getException().getMessage();
                              Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                          }
                      }
                  });
//        categoryModelList.add(new category_model("link","All categories"));
//        categoryModelList.add(new category_model("link","Home"));
//        categoryModelList.add(new category_model("link","Fashion"));
//        categoryModelList.add(new category_model("link","Beauty"));
//        categoryModelList.add(new category_model("link","Mobiles"));
//        categoryModelList.add(new category_model("link","Appliences"));
//        categoryModelList.add(new category_model("link","Toys"));
//        categoryModelList.add(new category_model("link","Food&sweets"));
//        categoryModelList.add(new category_model("link","sports"));
//        categoryModelList.add(new category_model("link","Clothes"));




//        TextView gridlayouttitle=view.findViewById(R.id.gridlayoutitle);
//        Button gridlayoutbutton=view.findViewById(R.id.gridviewallbutton);
//        GridView gridView1=view.findViewById(R.id.gridview);
//
//        gridView1.setAdapter(new GridproductAdaptor(horizontalproductmodelList));
//

        /////////////////////

        RecyclerView homerecycler=view.findViewById(R.id.homerecyclerview);
        LinearLayoutManager homelenearlayout=new LinearLayoutManager(getContext());
        homelenearlayout.setOrientation(LinearLayoutManager.VERTICAL);
        homerecycler.setLayoutManager(homelenearlayout);
        List<HomeModel>homeModelsList=new ArrayList<>();
        HomeAdaptor homeAdaptor=new HomeAdaptor(homeModelsList);
        homerecycler.setAdapter(homeAdaptor);
        firebaseFirestore.collection("Categories").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot queryDocumentSnapshot:task.getResult()){
                                homeModelsList.add(new HomeModel(4,queryDocumentSnapshot.get("icon").toString(),queryDocumentSnapshot.get("title").toString(),categoryModelList));
                                break;
                            }
                            homeAdaptor.notifyDataSetChanged();
                        }else
                        {
                            String error=task.getException().getMessage();
                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        firebaseFirestore.collection("Categories")
                .document("e-s-m-allcategores")
                .collection("TopDeals").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                   if(task.isSuccessful()){
                       for(QueryDocumentSnapshot queryDocumentSnapshot: task.getResult()){
                               if((long)queryDocumentSnapshot.get("view_type")==0){
                               List<slider_model> sliderModelList = new ArrayList<>();
                               long no_of_banner = (long) queryDocumentSnapshot.get("no_of_banner");
                               for (long x = 1; x <= no_of_banner; x++) {
                                   sliderModelList.add(new slider_model(queryDocumentSnapshot.get("banner_" + x).toString(), queryDocumentSnapshot.get("banner_" + x + "_background").toString()));
                               }
                               homeModelsList.add(new HomeModel(0, sliderModelList));
                           }
                               else if((long)queryDocumentSnapshot.get("view_type")==1){
                                   homeModelsList.add(new HomeModel(1,queryDocumentSnapshot.get("strip_1").toString(),queryDocumentSnapshot.get("strip_1_background").toString()));

                               }
                               else if((long)queryDocumentSnapshot.get("view_type")==2){
                                   List<horizontalproductmodel>horizontalproductmodelList1=new ArrayList<>();
                                   long no_of_products = (long) queryDocumentSnapshot.get("no_of_product");
                                   for (long x = 1; x <= no_of_products; x++) {
                                      horizontalproductmodelList1.add(new horizontalproductmodel(queryDocumentSnapshot.get("product_Id_"+x).toString(), queryDocumentSnapshot.get("product_Image_" +x).toString(),
                                              queryDocumentSnapshot.get("product_title_"+x).toString(),queryDocumentSnapshot.get("index").toString(),queryDocumentSnapshot.get("product_price_"+x).toString()));
                                       }
                                   homeModelsList.add(new HomeModel(2,queryDocumentSnapshot.get("layout_title").toString(),horizontalproductmodelList1));
                               }
                               else if((long)queryDocumentSnapshot.get("view_type")==3){
                                   List<horizontalproductmodel>GridproductmodelList1=new ArrayList<>();
                                   long no_of_products = (long) queryDocumentSnapshot.get("no_of_product");
                                   for (long x = 1; x <= no_of_products; x++) {
                                       GridproductmodelList1.add(new horizontalproductmodel(queryDocumentSnapshot.get("product_Id_"+x).toString(), queryDocumentSnapshot.get("product_Image_" +x).toString(),
                                               queryDocumentSnapshot.get("product_title_"+x).toString(),queryDocumentSnapshot.get("index").toString(),queryDocumentSnapshot.get("product_price_"+x).toString()));
                                   }
                                   homeModelsList.add(new HomeModel(3,queryDocumentSnapshot.get("layout_title").toString(),GridproductmodelList1));

                               }
                       }

                       homeAdaptor.notifyDataSetChanged();
                   }else
                   {
                       String error=task.getException().getMessage();
                       Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                   }
                    }
                });

        homeAdaptor.notifyDataSetChanged();

//        homeModelsList.add(new HomeModel(0,sliderModelList));
//        homeModelsList.add(new HomeModel(1,R.drawable.beauty,"#000000"));
//        homeModelsList.add(new HomeModel(2,"Deals of the day",horizontalproductmodelList));
//        homeModelsList.add(new HomeModel(3,"Deals of the days",horizontalproductmodelList));
//        homeModelsList.add(new HomeModel(2,"Deals of the days",horizontalproductmodelList));
//        homeModelsList.add(new HomeModel(3,"Deals of the day",horizontalproductmodelList));
//       homeModelsList.add(new HomeModel(0,sliderModelList));
//        homeModelsList.add(new HomeModel(1,R.drawable.beauty,"#000000"));
//        homeModelsList.add(new HomeModel(0,sliderModelList));
//        homeModelsList.add(new HomeModel(1,R.drawable.beauty,"#000000"));
//        homeModelsList.add(new HomeModel(0,sliderModelList));
//        homeModelsList.add(new HomeModel(1,R.drawable.beauty,"#000000"));
//        HomeAdaptor homeAdaptor=new HomeAdaptor(homeModelsList);
//        homerecycler.setAdapter(homeAdaptor);
//        homeAdaptor.notifyDataSetChanged();
//        List<HomeModels>homeModelsList=new ArrayList<>();
//        homeModelsList.add(new HomeModels(0,sliderModelList));
//        homeModelsList.add(new HomeModels(1,R.drawable.beauty,"#000000"));
//        homeModelsList.add(new HomeModels(2,"Deals of the day",horizontalproductmodelList));
//        homeModelsList.add(new HomeModels(3,"Deals of the days",horizontalproductmodelList));
//        homeModelsList.add(new HomeModels(2,"Deals of the days",horizontalproductmodelList));
//        homeModelsList.add(new HomeModels(3,"Deals of the day",horizontalproductmodelList));
//        homeModelsList.add(new HomeModels(0,sliderModelList));
//        homeModelsList.add(new HomeModels(1,R.drawable.beauty,"#000000"));
//        homeModelsList.add(new HomeModels(0,sliderModelList));
//        homeModelsList.add(new HomeModels(1,R.drawable.beauty,"#000000"));
//        homeModelsList.add(new HomeModels(0,sliderModelList));
//        homeModelsList.add(new HomeModels(1,R.drawable.beauty,"#000000"));
//        HomeAdaptor homeAdaptor=new HomeAdaptor(homeModelsList);
//        homerecycler.setAdapter(homeAdaptor);
//        homeAdaptor.notifyDataSetChanged();


        /////////////////////



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
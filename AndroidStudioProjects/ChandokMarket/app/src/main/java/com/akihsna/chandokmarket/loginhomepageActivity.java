package com.akihsna.chandokmarket;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Timer;

public class loginhomepageActivity extends AppCompatActivity {
    Toolbar toolbar1;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginhomepage);
        toolbar1 = findViewById(R.id.toolbar1);
        navigationView=findViewById(R.id.navmenu);
        drawerLayout=findViewById(R.id.drawer);
        //frameLayout1=findViewById(R.id.frame);
        //setFragment(new HomeFragment());
        //toolbar1.setLogo(R.drawable.cmit2);
        setSupportActionBar(toolbar1);
        //toolbar1.setLogo(R.drawable.cmit2);
//        layoutTitle=findViewById(R.id.horizontalscreentext);
//        viewallbutton=findViewById(R.id.horizontalscreenbutton);
//        horizontalscrollrecyclerView=findViewById(R.id.horizontalscreenrecycler);

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
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getBaseContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //horizontalscrollrecyclerView.setLayoutManager(linearLayoutManager);
        //horizontalscrollrecyclerView.setAdapter(horizontalproductscrollAdeptor);
       // horizontalproductscrollAdeptor.notifyDataSetChanged();


//        viewPager=findViewById(R.id.banner_slider);
//        stripimage=findViewById(R.id.stripadimage);
//        stripconstraintLayout=findViewById(R.id.stripadcontainer);
//        stripimage.setImageResource(R.drawable.beauty);
//        stripconstraintLayout.setBackgroundColor(Color.parseColor("#000000"));
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


//        TextView gridlayouttitle=findViewById(R.id.gridlayoutitle);
//        Button gridlayoutButton=findViewById(R.id.gridviewallbutton);
//        GridView gridView=findViewById(R.id.gridview);
//
//        gridView.setAdapter(new GridproductAdaptor(horizontalproductmodelList));

//
//
//        ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                currentpage=position;
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                if(state==ViewPager.SCROLL_STATE_IDLE);
//                pagelooper();
//            }
//        };
//        viewPager.addOnPageChangeListener(onPageChangeListener);
//        startbannerslideshow();
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                pagelooper();
//                stopbanner();
//                if(event.getAction()==MotionEvent.ACTION_UP){
//                    startbannerslideshow();
//                }
//                return false;
//            }
//        });

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar1,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
//    private void pagelooper(){
//        if(currentpage==sliderModelList.size()-2){
//            currentpage =2;
//            viewPager.setCurrentItem(currentpage,false);
//        }
//        if(currentpage==1){
//            currentpage =sliderModelList.size()-3;
//            viewPager.setCurrentItem(currentpage,false);
//        }
//    }
//    private void startbannerslideshow(){
//        Handler handler=new Handler();
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                if(currentpage>=sliderModelList.size()){
//                    currentpage=1;
//                }
//                viewPager.setCurrentItem(currentpage++,true);
//            }
//        } ;
//        timer=new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(runnable);
//            }
//        },DELAY_TIME,PERIOD_TIME);
//    }
//    private void stopbanner(){
//        timer.cancel();
//    }
//    private void setFragment(Fragment fragment){
//        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(frameLayout1.getId(),fragment);
//        fragmentTransaction.commit();
//    }
}
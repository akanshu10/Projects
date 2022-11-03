package com.akihsna.localmarket.ui.temp;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.CategoryActivity;
import com.akihsna.localmarket.ui.home.GridproductAdaptor;
import com.akihsna.localmarket.ui.home.HorizontalproductscrollAdeptor;
import com.akihsna.localmarket.ui.home.horizontalproductmodel;
import com.akihsna.localmarket.ui.home.slider_Adeptor;
import com.akihsna.localmarket.ui.home.slider_model;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
public class TempAdaptor extends RecyclerView.Adapter {
    private List<TempModels> tempModelsList;
    public TempAdaptor(List<TempModels> tempModelsList) {
        this.tempModelsList = tempModelsList;
    }
    @Override
    public int getItemViewType(int position) {
        switch (tempModelsList.get(position).getType()) {
            case 0:
                return TempModels.BANNER_SLIDER;
            case 1:
                return TempModels.STRIP_AD_BANNER;
            case 2:
                return TempModels.HORIZONTAL_PRODUCT_VIEW;
            case 3:
                return TempModels.GRID_LAYOUT_VIEW;
            default:
                return -1;
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case TempModels.BANNER_SLIDER:
                View bannersliderview = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_ad_layout, parent, false);
                return new BannersliderViewholder(bannersliderview);
            case TempModels.STRIP_AD_BANNER:
                View stripview = LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_ad_layout, parent, false);
                return new StripAdViewholder(stripview);
                case TempModels.HORIZONTAL_PRODUCT_VIEW:
                    View horizontalview=LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_screenlayout,parent,false);
                    return new HorizontalViewholder(horizontalview);
            case TempModels.GRID_LAYOUT_VIEW:
                View gridlayoutview=LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product_layout,parent,false);
                return new GridViewholder(gridlayoutview);

                    default:
                        return null;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (tempModelsList.get(position).getType()) {
            case TempModels.BANNER_SLIDER:
                List<slider_model> sliderModelList = tempModelsList.get(position).getSliderModelList();
                ((BannersliderViewholder) holder).setBannersliderviewer(sliderModelList);
                break;
            case TempModels.HORIZONTAL_PRODUCT_VIEW:
                String htitle= tempModelsList.get(position).getTitle();
                List<horizontalproductmodel>horizontalproductmodelList1= tempModelsList.get(position).getHorizontalproductmodelList();
                ((HorizontalViewholder)holder).setHorizontalview(horizontalproductmodelList1,htitle);
                break;
            case TempModels.STRIP_AD_BANNER:
                int resource= tempModelsList.get(position).getResource();
                String color= tempModelsList.get(position).getBackgroundcolor();
                ((StripAdViewholder)holder).setStripAd(resource,color);
                break;
            case TempModels.GRID_LAYOUT_VIEW:
                String gridtitle= tempModelsList.get(position).getTitle();
                List<horizontalproductmodel>horizontalproductmodelgridList= tempModelsList.get(position).getHorizontalproductmodelList();
                ((GridViewholder)holder).setGridproduct(horizontalproductmodelgridList,gridtitle);
                break;

            default:
                return;
        }
    }
    @Override
    public int getItemCount() {
        return tempModelsList.size();
    }
    public class BannersliderViewholder extends RecyclerView.ViewHolder {
        private ViewPager viewPager;
        private int currentpage = 2;
        private Timer timer;
        final private long DELAY_TIME = 3000;
        final private long PERIOD_TIME = 3000;

        public BannersliderViewholder(@NonNull View itemView) {
            super(itemView);
            viewPager = itemView.findViewById(R.id.banner_slider);

        }

        private void setBannersliderviewer(List<slider_model> sliderModelList1) {
            slider_Adeptor slider_adeptor = new slider_Adeptor(sliderModelList1);
            viewPager.setAdapter(slider_adeptor);
            viewPager.setClipToPadding(false);
            viewPager.setPageMargin(20);
            viewPager.setCurrentItem(currentpage);


            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    currentpage = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) ;
                    pagelooper(sliderModelList1);
                }
            };
            viewPager.addOnPageChangeListener(onPageChangeListener);
            startbannerslideshow(sliderModelList1);
            viewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pagelooper(sliderModelList1);
                    stopbanner(sliderModelList1);
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startbannerslideshow(sliderModelList1);
                    }
                    return false;
                }
            });
        }
        private void pagelooper(List<slider_model> sliderModelList1) {
            if (currentpage == sliderModelList1.size() - 2) {
                currentpage = 2;
                viewPager.setCurrentItem(currentpage, false);
            }
            if (currentpage == 1) {
                currentpage = sliderModelList1.size() - 3;
                viewPager.setCurrentItem(currentpage, false);
            }
        }

        private void startbannerslideshow(final List<slider_model> sliderModelList) {
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (currentpage >= sliderModelList.size()) {
                        currentpage = 1;
                    }
                    viewPager.setCurrentItem(currentpage++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            }, DELAY_TIME, PERIOD_TIME);
        }

        private void stopbanner(List<slider_model> sliderModelList1) {
            timer.cancel();
        }
    }
    public class StripAdViewholder extends RecyclerView.ViewHolder {
        private ImageView stripimage;
        private ConstraintLayout stripconstraintLayout;
        public StripAdViewholder(@NonNull View itemView) {
            super(itemView);
            stripimage=itemView.findViewById(R.id.stripadimage);
            stripconstraintLayout=itemView .findViewById(R.id.stripadcontainer);

        }
        private void setStripAd(int resource,String color){
            stripimage.setImageResource(resource);
            stripimage.setBackgroundColor(Color.parseColor(color));
        }
    }
    public class HorizontalViewholder extends RecyclerView.ViewHolder{
        private TextView layoutTitle;
        private Button viewallbutton;
        private RecyclerView horizontalscrollrecyclerView;

        public HorizontalViewholder(@NonNull View itemView) {
            super(itemView);
            layoutTitle=itemView.findViewById(R.id.horizontalscreentext);
            viewallbutton=itemView.findViewById(R.id.horizontalscreenbutton);
            horizontalscrollrecyclerView=itemView.findViewById(R.id.horizontalscreenrecycler);
        }
        private void setHorizontalview(List<horizontalproductmodel>horizontalproductmodelList,String title){

            layoutTitle.setText(title);
            if(horizontalproductmodelList.size()>8){
                viewallbutton.setVisibility(View.VISIBLE);
            }else {
                viewallbutton.setVisibility(View.INVISIBLE);
            }

            HorizontalproductscrollAdeptor horizontalproductscrollAdeptor=new HorizontalproductscrollAdeptor(horizontalproductmodelList);
            LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalscrollrecyclerView.setLayoutManager(linearLayoutManager2);
            horizontalscrollrecyclerView.setAdapter(horizontalproductscrollAdeptor);
            horizontalproductscrollAdeptor.notifyDataSetChanged();
        }
    }
    public class GridViewholder extends RecyclerView.ViewHolder{
        private TextView gridlayouttitle;
        private Button gridlayoutbutton;
        private GridView gridView1;
        public GridViewholder(@NonNull View itemView) {
            super(itemView);
            gridlayouttitle=itemView.findViewById(R.id.gridlayoutitle);
            gridlayoutbutton=itemView.findViewById(R.id.gridviewallbutton);
            gridView1=itemView.findViewById(R.id.gridview);
        }
        private void setGridproduct(List<horizontalproductmodel>horizontalproductmodelList,String title){
            gridlayouttitle.setText(title);
            gridView1.setAdapter(new GridproductAdaptor(horizontalproductmodelList));
        }
    }
    public class categoryViewHolder extends RecyclerView.ViewHolder{
        private ImageView catagoryicon;
        private TextView categoryname;

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            catagoryicon=itemView.findViewById(R.id.categoryicon);
            categoryname=itemView.findViewById(R.id.categorytext);
        }
        private void setCatagoryicon(){

        }
        private void setCategoryname(String name){
            categoryname.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent categoryIntent = new Intent(itemView.getContext(), CategoryActivity.class);
                    categoryIntent.putExtra("categoryname", name);
                    itemView.getContext().startActivity(categoryIntent);

                }
            });

        }
        private void setcategoryproduct(){

        }
    }
}
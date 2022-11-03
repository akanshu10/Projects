package com.akihsna.localmarket.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.akihsna.localmarket.R;
import com.akihsna.localmarket.ui.allcategories.ProductActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeAdaptor extends RecyclerView.Adapter {
    private List<HomeModel> modelsList;
    public HomeAdaptor(List<HomeModel> modelsList) {
        this.modelsList = modelsList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (modelsList.get(position).getType()) {
            case 0:
                return HomeModel.BANNER_SLIDER;
            case 1:
                return HomeModel.STRIP_AD_BANNER;
            case 2:
                return HomeModel.HORIZONTAL_PRODUCT_VIEW;
            case 3:
                return HomeModel.GRID_LAYOUT_VIEW;
            case 4:
                return HomeModel.CATEGORY_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HomeModel.BANNER_SLIDER:
                View bannersliderview = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_ad_layout, parent, false);
                return new HomeAdaptor.BannersliderViewholder(bannersliderview);
            case HomeModel.STRIP_AD_BANNER:
                View stripview = LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_ad_layout, parent, false);
                return new HomeAdaptor.StripAdViewholder(stripview);
            case HomeModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalview=LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_screenlayout,parent,false);
                return new HomeAdaptor.HorizontalViewholder(horizontalview);
            case HomeModel.GRID_LAYOUT_VIEW:
                View gridlayoutview=LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product_layout,parent,false);
                return new HomeAdaptor.GridViewholder(gridlayoutview);
            case HomeModel.CATEGORY_VIEW:
                View categorylayoutview=LayoutInflater.from(parent.getContext()).inflate(R.layout.categoryproduct_layout,parent,false);
                return new HomeAdaptor.CategoryViewholder(categorylayoutview);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (modelsList.get(position).getType()) {
            case HomeModel.CATEGORY_VIEW:
                String categorytitle= modelsList.get(position).getCategoryname();
                //String categorylink= modelsList.get(position).getCatagoryiconlink();
                List<category_model>categoryModelList= modelsList.get(position).getCategoryModelList();
                ((HomeAdaptor.CategoryViewholder)holder).setCategoryproduct(categoryModelList,categorytitle);
                break;
            case HomeModel.BANNER_SLIDER:
                List<slider_model> sliderModelList = modelsList.get(position).getSliderModelList();
                ((HomeAdaptor.BannersliderViewholder) holder).setBannersliderviewer(sliderModelList);
                break;
            case HomeModel.HORIZONTAL_PRODUCT_VIEW:
                String htitle= modelsList.get(position).getTitle();
                List<horizontalproductmodel>horizontalproductmodelList1= modelsList.get(position).getHorizontalproductmodelList();
                ((HomeAdaptor.HorizontalViewholder)holder).setHorizontalview(horizontalproductmodelList1,htitle);
                break;
            case HomeModel.STRIP_AD_BANNER:
                String resource= modelsList.get(position).getResource();
                String color= modelsList.get(position).getBackgroundcolor();
                ((HomeAdaptor.StripAdViewholder)holder).setStripAd(resource,color);
                break;
            case HomeModel.GRID_LAYOUT_VIEW:
                String gridtitle= modelsList.get(position).getTitle();
                List<horizontalproductmodel>horizontalproductmodelgridList= modelsList.get(position).getHorizontalproductmodelList();
                ((HomeAdaptor.GridViewholder)holder).setGridproduct(horizontalproductmodelgridList,gridtitle);
                break;

            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return modelsList.size();
    }

    public class BannersliderViewholder extends RecyclerView.ViewHolder {
        private ViewPager viewPager;
        private int currentpage ;
        private Timer timer;
        final private long DELAY_TIME = 3000;
        final private long PERIOD_TIME = 3000;
        private List<slider_model>arrangedlist;

        public BannersliderViewholder(@NonNull View itemView) {
            super(itemView);
            viewPager = itemView.findViewById(R.id.banner_slider);

        }

        private void setBannersliderviewer(final List<slider_model> sliderModelList1) {
            //slider_Adeptor slider_adeptor = new slider_Adeptor(sliderModelList1);
//            viewPager.setAdapter(slider_adeptor);
//            viewPager.setClipToPadding(false);
//            viewPager.setPageMargin(20);
//            viewPager.setCurrentItem(currentpage);

            currentpage=2;
            if(timer!=null){
                timer.cancel();
            }
            arrangedlist=new ArrayList<>();
            for(int x=0;x<sliderModelList1.size();x++){
                arrangedlist.add(x,sliderModelList1.get(x));
            }
            arrangedlist.add(0,sliderModelList1.get(sliderModelList1.size()-2));
            arrangedlist.add(1,sliderModelList1.get(sliderModelList1.size()-1));
            arrangedlist.add(sliderModelList1.get(0));
            arrangedlist.add(sliderModelList1.get(1));

            slider_Adeptor slider_adeptor1=new slider_Adeptor(arrangedlist);
            viewPager.setAdapter(slider_adeptor1);
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
                    pagelooper(arrangedlist);
                }
            };
            viewPager.addOnPageChangeListener(onPageChangeListener);
            startbannerslideshow(arrangedlist);
            viewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pagelooper(arrangedlist);
                    stopbanner();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startbannerslideshow(arrangedlist);
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

        private void stopbanner() {
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
        private void setStripAd(String resource,String color){
            Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions()).placeholder(R.drawable.category);
//            stripimage.setImageResource(resource);
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
        //private GridLayout gridView1;
        public GridViewholder(@NonNull View itemView) {
            super(itemView);
            gridlayouttitle=itemView.findViewById(R.id.gridlayoutitle);
            gridlayoutbutton=itemView.findViewById(R.id.gridviewallbutton);
            gridView1=itemView.findViewById(R.id.gridview);
        }
        private void setGridproduct(List<horizontalproductmodel>horizontalproductmodelList,String title){
            gridlayouttitle.setText(title);

//            for(int x=0;x<4;x++){
//                ImageView productImage=gridView1.getChildAt(x).findViewById(R.id.horizontalimage);
//                TextView producttitle=gridView1.getChildAt(x).findViewById(R.id.horizontaltitle);
//                TextView productdec=gridView1.getChildAt(x).findViewById(R.id.horizontaldec);
//                TextView productprice=gridView1.getChildAt(x).findViewById(R.id.horizontalprice);
//
//                Glide.with(itemView.getContext()).load(horizontalproductmodelList.get(x).getProductimage()).apply(new RequestOptions().placeholder(R.drawable.category)).into(productImage);
//                producttitle.setText(horizontalproductmodelList.get(x).getProductname());
//                productdec.setText(horizontalproductmodelList.get(x).getProductdes());
//                productprice.setText(horizontalproductmodelList.get(x).getProductprice());
//
//                gridView1.getChildAt(x).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent productintent= new Intent(itemView.getContext(), ProductActivity.class);
//                        itemView.getContext().startActivity(productintent);
//                    }
//                    });
//            }

            gridView1.setAdapter(new GridproductAdaptor(horizontalproductmodelList));
        }
    }

    public class CategoryViewholder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView icon;
        private RecyclerView recyclerView;

        public CategoryViewholder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.categorytext);
           icon=itemView.findViewById(R.id.categoryicon);
            recyclerView=itemView.findViewById(R.id.categoryrecycler);
        }

        public void setCategoryproduct(List<category_model> categoryModelList, String categorytitle) {
            title.setText(categorytitle);
//            icon.setImageResource(Integer.parseInt(categorylink));
            LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager1);
            recyclerView.setAdapter(new categoryAdeptor(categoryModelList));
        }
    }
}


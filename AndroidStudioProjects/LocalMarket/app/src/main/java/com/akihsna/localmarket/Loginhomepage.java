package com.akihsna.localmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import com.akihsna.localmarket.ui.account.AccountActivity;
import com.akihsna.localmarket.ui.allcategories.AllcategoryActivityActivity;
import com.akihsna.localmarket.ui.cart.CartActivity;
import com.akihsna.localmarket.ui.home.HomeFragment;
import com.akihsna.localmarket.ui.language.LanguageFragment;
import com.akihsna.localmarket.ui.list.wishlistActivity;
import com.akihsna.localmarket.ui.notification.NotificationFragment;
import com.akihsna.localmarket.ui.order.MyorderActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Loginhomepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    private static final int HOME_FRAGMENT=0;
    private static final int CART_FRAGMENT=1;
    private static  int currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginhomepage);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerLayout= findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.nav_host_fragment,new HomeFragment());
        fragmentTransaction.commit();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home1, R.id.allcategorios1, R.id.language1,R.id.order1
        ,R.id.cart1,R.id.list1,R.id.account1)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loginhomepage, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id=item.getItemId();
        if(id==R.id.Notification1){
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id==R.id.cart1) {
            mycart();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void mycart() {
        Intent intent =new Intent(Loginhomepage.this, CartActivity.class);
        startActivity(intent);


    }

    /*public boolean onNavigationItemsSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.home) {
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id==R.id.allcategorios){
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.language){
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id==R.id.order){
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.cart){
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id==R.id.list){
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.account){
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.notification){
            Toast.makeText(Loginhomepage.this,"hello notification",Toast.LENGTH_SHORT).show();
            return true;
        }
        DrawerLayout drawerLayout=
    }*/

    /*@Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        int id=item.getItemId();
        if(id==R.id.home1) {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,new HomeFragment());
            fragmentTransaction.commit();
        }
        else if (id==R.id.allcategorios1){
           startActivity(new Intent(Loginhomepage.this,AllcategoryActivityActivity.class));

        }
        else if(id==R.id.language1){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,new LanguageFragment());
            fragmentTransaction.commit();

        }
        else if (id==R.id.order1){
            startActivity(new Intent(Loginhomepage.this, MyorderActivity.class));

        }
        else if(id==R.id.cart1){
            mycart();

        }
        else if (id==R.id.list1){
           startActivity(new Intent(Loginhomepage.this, wishlistActivity.class));
        }
        else if(id==R.id.account1){
            startActivity(new Intent(Loginhomepage.this, AccountActivity.class));

        }
        else if(id==R.id.notification1){
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,new NotificationFragment());
            fragmentTransaction.commit();
        }
        return true;
    }
}
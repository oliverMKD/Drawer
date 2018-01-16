package com.oliver.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.oliver.drawer.Adapter.FragmentAdapter;
import com.oliver.drawer.Fragments.Fragment_Home;
import com.oliver.drawer.Fragments.Fragment_Movies;
import com.oliver.drawer.Fragments.Fragment_Notifications;
import com.oliver.drawer.Fragments.Fragment_Photos;
import com.oliver.drawer.Fragments.Fragment_Settings;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.myPager)
    public ViewPager pager;
//    @BindView(R.id.imageView)
//    ImageView slika;
//    @BindView(R.id.Ime)
//    TextView ime;
//    @BindView(R.id.textView)
//    TextView text;

        TextView ime;
        TextView text;
    DrawerLayout drawer;
    String []activityTitles;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activityTitles=getResources().getStringArray(R.array.nav_item_activity_titles);


            FragmentAdapter pagerAdapter = new  FragmentAdapter(getSupportFragmentManager());
            pagerAdapter.AddFragments(new Fragment_Home());
            pagerAdapter.AddFragments(new Fragment_Movies());
            pagerAdapter.AddFragments(new Fragment_Notifications());
            pagerAdapter.AddFragments(new Fragment_Photos());
            pagerAdapter.AddFragments(new Fragment_Settings());
            pager.setAdapter(pagerAdapter);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        ime = (TextView)header.findViewById(R.id.Ime);
        text = (TextView)header.findViewById(R.id.textView);

        ime.setText(R.string.macReds);
        text.setText(R.string.mail);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // ova se trite tocki gore//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (index==0){
            getMenuInflater().inflate(R.menu.main, menu);
        }
        if (index==3){
            getMenuInflater().inflate(R.menu.notifications, menu);
        }
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            index=0;
           pager.setCurrentItem(index);
        } else if (id == R.id.nav_Movies) {
            index=1;
            pager.setCurrentItem(index);
        } else if (id == R.id.nav_photos) {
            index=2;
            pager.setCurrentItem(index);
        } else if (id == R.id.nav_notifications) {
            index=3;
            pager.setCurrentItem(index);
        } else if (id == R.id.nav_settings) {
            index=4;
            pager.setCurrentItem(index);
        } else if (id == R.id.nav_aboutUs) {
            Intent intent = new Intent(this,AboutUs.class);
            startActivity(intent);
            drawer.closeDrawers();
        }else if (id == R.id.nav_Privacy) {
            Intent intent2 = new Intent(this,AboutUs.class);
            startActivity(intent2);
            drawer.closeDrawers();

        }
        getSupportActionBar().setTitle(activityTitles[index]);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
//
        return true;
    }
    private void  setToolbarTitle(){
        getSupportActionBar().setTitle(activityTitles[index]);
        invalidateOptionsMenu();

    }
}

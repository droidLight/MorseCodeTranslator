package com.example.sibi.morsecode;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;


public class tabbedactivity extends AppCompatActivity{

    Toolbar toolbar;
    TabLayout tablayout;
    ViewPager viewpager;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_tabbedactivity);
       toolbar = (Toolbar) findViewById(R.id.tool);
       setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();// back button pressed
           }
       });

       viewpager = (ViewPager) findViewById(R.id.pager);
       setupViewPager(viewpager);

       tablayout = (TabLayout) findViewById(R.id.tabs);
       tablayout.setupWithViewPager(viewpager);




   }
    private void setupViewPager(ViewPager viewpager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new englishToMorse(),"English To Morse");
        adapter.addFragment(new morseToEnglish(),"Morse To English");
        viewpager.setAdapter(adapter);
    }
}
class ViewPagerAdapter extends FragmentPagerAdapter{

    private List<String>fragTitle = new ArrayList<>();
    private List<Fragment>fragmentobj = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentobj.get(position);
    }

    @Override
    public int getCount() {
        return fragmentobj.size();
    }
    public void addFragment(Fragment fragment,String title){
        fragTitle.add(title);
        fragmentobj.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragTitle.get(position);
    }
}

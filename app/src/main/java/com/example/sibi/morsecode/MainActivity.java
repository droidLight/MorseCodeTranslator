package com.example.sibi.morsecode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked(View v){
        int option = v.getId();
        switch(option){

            case R.id.bOne:
                Intent pageOne = new Intent(this,tabbedactivity.class );
                startActivity(pageOne);
                break;

            case R.id.customCode:
                Intent pageThree = new Intent(this,chart.class);
                startActivity(pageThree);
                break;


        }
    }

    





}

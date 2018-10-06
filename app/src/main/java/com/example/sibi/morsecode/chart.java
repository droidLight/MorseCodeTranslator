package com.example.sibi.morsecode;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sibi.morsecode.R.array.alphabets;
import static com.example.sibi.morsecode.R.layout.listitem;

public class chart extends AppCompatActivity {

    ListView listview;
    Toolbar toolbar;
    customAdapter arrayAdapter;
    Resources res;
    MorseCode morse;
    AlertDialog.Builder builder;
    LayoutInflater inflater;
    TextView head,change;
    EditText edit;
    Button okButton;
    SharedPreferences sharedpref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        res = getResources();
        morse = new MorseCode();
        listview = (ListView)findViewById(R.id.listView);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        //sharedpref = getSharedPreferences("com.example.sibi.morsecode.testfile",MODE_PRIVATE);





        final String[] listArray = res.getStringArray(alphabets);
        final String[] codeArray = morse.morse;

        arrayAdapter = new customAdapter(this,listArray,codeArray);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listview.setAdapter(arrayAdapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //for dialog box
                builder = new AlertDialog.Builder(chart.this);
                inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.customdialog,null);
                builder.setView(view);
                head = (TextView) view.findViewById(R.id.head);
                head.setText(listArray[position]);
                edit = (EditText) view.findViewById(R.id.editText);
                okButton = (Button) view.findViewById(R.id.ok);
                AlertDialog dialog = builder.create();
                dialog.show();
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("REACHED");
                        sharedpref = getSharedPreferences("customcode",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpref.edit();
                        editor.putString(listArray[position],edit.getText().toString());
                        editor.apply();
                        String temp = sharedpref.getString(listArray[position], "");
                        Toast.makeText(chart.this,temp,Toast.LENGTH_LONG).show();
                        System.out.println("REACHEDTWO");
                        v = inflater.inflate(R.layout.listitem,null);
                        change = (TextView) v.findViewById(R.id.morseFormat);
                        change.setText("SIBI");
                        System.out.println("REACHEDTHREE");
                    }
                });


            }
        });


    }

}

class customAdapter extends ArrayAdapter<String>{

    String[] alphabets;
    String[] code;
    TextView txt,txtCode;
    Typeface type;

    public customAdapter(Context context,String[] alphabets,String[] code){
        super(context,listitem,R.id.alpha,alphabets);
        this.alphabets=alphabets;
        this.code=code;
        type=Typeface.createFromAsset(context.getAssets(),"fonts/Roboto-Medium.ttf");
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(listitem,parent,false);

        txt = (TextView) row.findViewById(R.id.alpha);
        txt.setTypeface(type);
        txtCode = (TextView) row.findViewById(R.id.morseFormat);
        txtCode.setTypeface(type);
        txt.setText(alphabets[position]);
        txtCode.setText(code[position]);
        return row;
    }
}


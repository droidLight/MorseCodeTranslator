package com.example.sibi.morsecode;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class morseToEnglish extends Fragment{

    Button transButton;
    TextView text;
    EditText textIn;
    String input;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.activity_morse_to_english,container,false);

        transButton = (Button) view.findViewById(R.id.buttonTrans);
        text = (TextView) view.findViewById(R.id.text_out);
        textIn = (EditText) view.findViewById(R.id.morse_in);
        //button
        transButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                input = textIn.getText().toString();
                MorseCode object = new MorseCode(input);
                text.setText(object.morseToEng());
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
package com.example.sibi.morsecode;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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

import java.util.Arrays;

import static android.content.Context.CLIPBOARD_SERVICE;

public class englishToMorse extends Fragment {
    String input;
    EditText textIn;
    Button tranButton,copy;
    TextView output;
    MorseCode obj;
    ClipboardManager clipboard;
    String res;
    Typeface type;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.activity_english_to_morse,container,false);
        type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Roboto-Medium.ttf");

        tranButton = (Button) view.findViewById(R.id.buttonOne);
        tranButton.setTypeface(type);
        copy = (Button) view.findViewById(R.id.buttonTwo);
        copy.setTypeface(type);
        output = (TextView) view.findViewById(R.id.morse_out);
        output.setTypeface(type);
        textIn = (EditText) view.findViewById(R.id.text_in);
        textIn.setTypeface(type);

        textIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textIn.setText(" ");
            }
        });

        tranButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                input = textIn.getText().toString();
                obj = new MorseCode(input);
                res =obj.engToMorse();
                output.setText(res);
            }
        });
        copy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text",res);
                clipboard.setPrimaryClip(clip);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}




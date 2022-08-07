package com.techno.colordesigner;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
View show,l;
Integer rv=0,gv=0,bv=0;
SeekBar red,blue,green;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=findViewById(R.id.show);
        red=findViewById(R.id.red);
        green=findViewById(R.id.green);
        l=findViewById(R.id.l1);
        blue=findViewById(R.id.blue);
        tv=findViewById(R.id.textView);
        show.setBackgroundColor(Color.BLACK);
        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                show.setBackgroundColor(Color.argb(255,rv=i,gv,bv));
                tv.setText("#"+Integer.toHexString(rv)+Integer.toHexString(gv)+Integer.toHexString(bv));
                ((TextView)findViewById(R.id.r)).setText(String.valueOf(rv));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){}
        });
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                show.setBackgroundColor(Color.argb(255,rv,gv=i,bv));
                tv.setText("#"+Integer.toHexString(rv)+Integer.toHexString(gv)+Integer.toHexString(bv));
                ((TextView)findViewById(R.id.g)).setText(String.valueOf(gv));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){}
        });
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                show.setBackgroundColor(Color.argb(255,rv,gv,bv=i));
                tv.setText("#"+Integer.toHexString(rv)+Integer.toHexString(gv)+Integer.toHexString(bv));
                ((TextView)findViewById(R.id.b)).setText(String.valueOf(bv));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){}
        });
        tv.setOnClickListener((View v) -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(ClipData.newPlainText("Color Code", tv.getText()));
            Toast.makeText(this,"Copied To Clipboard",Toast.LENGTH_SHORT).show();
        });
        findViewById(R.id.imageButton).setOnClickListener((View v)->{
            if(l.getVisibility() != View.VISIBLE){
                l.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);
                ((ImageButton)findViewById(R.id.imageButton)).setImageResource(R.drawable.ic_twotone_visibility_24);
            }else{
                l.setVisibility(View.GONE);
                tv.setVisibility(View.GONE);
                ((ImageButton)findViewById(R.id.imageButton)).setImageResource(R.drawable.ic_baseline_visibility_off_24);
            }
        });
    }
}
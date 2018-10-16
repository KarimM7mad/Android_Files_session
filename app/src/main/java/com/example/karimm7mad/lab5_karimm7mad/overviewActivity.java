package com.example.karimm7mad.lab5_karimm7mad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;

public class overviewActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        tv = (TextView) findViewById(R.id.txtView);
        tv.setMovementMethod(new ScrollingMovementMethod());
        //setImage
        iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.overviewimg);
        //setText
        try {
            InputStream is = this.getResources().openRawResource(R.raw.overview);
            String str = "";
            int i;
            while ((i = is.read()) != -1) {
                str += (char) i;
            }
            tv.setText(str);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

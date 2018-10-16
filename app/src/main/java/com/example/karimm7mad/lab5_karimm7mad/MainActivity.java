package com.example.karimm7mad.lab5_karimm7mad;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private ListView lv;
    public TextView txt;
    public Intent i, i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = new Intent(this, specificDepartmentActivity.class);
        i2 = new Intent(this, overviewActivity.class);
        //set Image View
        iv = (ImageView) findViewById(R.id.imgView);
        iv.setImageResource(R.drawable.logo);
        iv.setOnClickListener(new View.OnClickListener() {  public void onClick(View v){   startActivity(i2);  }});
        //get Text from file
        String[] deps = new String[8];
        //get reading file input stream
        InputStream is = this.getResources().openRawResource(R.raw.departmentlist);
        //read file content
        try {
            int i;
            int counter = 0;
            String x = "";
            while ((i = is.read()) != -1) {
                if (((char) i) == '\n') {
                    deps[counter++] = x;
                    x = "";
                }
                else
                    x += (char) i;
            }
        }
        catch (Exception e) {}
        //configuring ListView
        lv = findViewById(R.id.depsListView);
        // new ArrayAdapter takes this as a context , single element view ( 4kl el one element ) , array of strings to present
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.elementview, deps);
        lv.setAdapter(adapter);
        //item click listener is a listener specific to list views
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra("department", ((TextView) view).getText().toString());
                startActivity(i);
            }
        });

    }
}

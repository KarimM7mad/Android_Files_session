package com.example.karimm7mad.lab5_karimm7mad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;

public class specificDepartmentActivity extends AppCompatActivity {

    public TextView txt;
    public ListView lv;
    public ImageView iv;
    public Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_department);

        i = new Intent(this,overviewActivity.class);
        iv = (ImageView) findViewById(R.id.specificImgView);
        iv.setImageResource(R.drawable.logo);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

        String s = this.getIntent().getStringExtra("department");
        txt = findViewById(R.id.depName);
        txt.setText(s);
        String[] courses = new String[25];
        switch (s) {
            case "Building Engineering Program":
                this.fillStrArray(courses, this.getResources().openRawResource(R.raw.bldg));
                this.configureListView(courses);
                break;
            case "Communication Systems Engineering Program":
                this.fillStrArray(courses, this.getResources().openRawResource(R.raw.comm));
                this.configureListView(courses);
                break;
            case "Materials Engineering Program":
                this.fillStrArray(courses, this.getResources().openRawResource(R.raw.matr));
                this.configureListView(courses);
                break;
            case "Manufacturing Engineering Program":
                this.fillStrArray(courses, this.getResources().openRawResource(R.raw.manf));
                this.configureListView(courses);
                break;
            case "Energy and Renewable Energy Engineering Program":
                this.fillStrArray(courses, this.getResources().openRawResource(R.raw.energy));
                this.configureListView(courses);
                break;
            case "Computer Engineering and Software Systems Program":
                this.fillStrArray(courses, this.getResources().openRawResource(R.raw.cess));
                this.configureListView(courses);
                break;
            case "Landscape Architecture Program":
                this.fillStrArray(courses, this.getResources().openRawResource(R.raw.land));
                this.configureListView(courses);
                break;
            case "Mechatronics Engineering and Automation Program":
                this.fillStrArray(courses, this.getResources().openRawResource(R.raw.mct));
                this.configureListView(courses);
                break;
        }


    }

    //read file content into string array
    public void fillStrArray(String[] arr, InputStream is) {
        try {
            int i;
            int counter = 0;
            String x = "";
            while ((i = is.read()) != -1) {
                if (((char) i) == '\n') {
                    arr[counter++] = x;
                    x = "";
                } else
                    x += (char) i;
            }
        } catch (Exception e) {
        }

    }

    public void configureListView(String[] arr) {
        this.lv = findViewById(R.id.coursesListView);
        this.lv.setClickable(false);
        this.lv.setFocusable(false);
        this.lv.setAdapter(new ArrayAdapter<String>(this, R.layout.elementview, arr));
    }

}

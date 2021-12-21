package com.example.nestedrecycleview;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CourseType extends AppCompatActivity {
    TextView tvupper,remain,topcourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_type);
        tvupper=findViewById(R.id.tvupper);
        remain=findViewById(R.id.remain);
        topcourse=findViewById(R.id.topcourse);
        tvupper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CourseType.this,MainActivity.class).putExtra("type","upper"));
            }
        });

        remain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CourseType.this,MainActivity.class).putExtra("type","remain"));
            }
        });

        topcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CourseType.this,MainActivity.class).putExtra("type","top"));
            }
        });

    }
}
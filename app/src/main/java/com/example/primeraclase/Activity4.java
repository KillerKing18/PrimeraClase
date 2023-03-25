package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Bundle extras = getIntent().getExtras();
        String content2 = extras.getString("content2");
        TextView textViewContent2 = (TextView) findViewById(R.id.textViewContent2);
        textViewContent2.setText(content2);
    }
}
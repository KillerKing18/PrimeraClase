package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle extras = getIntent().getExtras();
        String dataParameter = extras.getString("parameter");
        TextView textData = (TextView) findViewById(R.id.parameterView);
        textData.setText(dataParameter);
    }
}
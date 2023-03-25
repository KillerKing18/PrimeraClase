package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Bundle extras = getIntent().getExtras();
        String content1 = extras.getString("content1");
        String content2 = extras.getString("content2");
        TextView textViewContent1 = (TextView) findViewById(R.id.textViewContent1);
        textViewContent1.setText(content1);


        Button button = (Button) findViewById(R.id.buttonActivity3);
        button.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getBaseContext(), Activity4.class);
            intent.putExtra("content2", content2);
            startActivity(intent);
            finish();
        });
    }
}
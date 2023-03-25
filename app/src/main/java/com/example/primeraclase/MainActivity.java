package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGoTo2 = (Button) findViewById(R.id.buttonGoTo2);
        buttonGoTo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity2.class);
                startActivity(intent);
                finish();
            }
        });

        Button buttonGoTo3 = (Button) findViewById(R.id.buttonGoTo3);
        buttonGoTo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity3.class);
                startActivity(intent);
            }
        });
    }
}
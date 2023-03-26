package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGoTo2 = (Button) findViewById(R.id.buttonGoTo2);
        buttonGoTo2.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getBaseContext(), Activity2.class);
            //Sending a parameter to the second activity
            String aux = "String created in MainActivity";
            intent.putExtra("parameter", aux);
            startActivity(intent);
            finish();
        });

        Button buttonGoTo3 = (Button) findViewById(R.id.buttonGoTo3);
        buttonGoTo3.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getBaseContext(), Activity3.class);
            //Sending a parameter to the third activity
            String content1 = ((EditText) findViewById(R.id.editTextContent1)).getText().toString();
            String content2 = ((EditText) findViewById(R.id.editTextContent2)).getText().toString();
            intent.putExtra("content1", content1);
            intent.putExtra("content2", content2);
            startActivity(intent);
        });

        Button buttonGoToCalculator = (Button) findViewById(R.id.buttonGoToCalculator);
        buttonGoToCalculator.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getBaseContext(), CalculatorActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
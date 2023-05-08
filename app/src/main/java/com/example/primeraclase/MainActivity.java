package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int option = item.getItemId();
        switch (option)
        {
            case R.id.option1:
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity2.class);
                //Sending a parameter to the second activity
                String aux = "String created in MainActivity";
                intent.putExtra("parameter", aux);
                startActivity(intent);
                break;
            case R.id.option2:
                break;
        }
        return false;
    }

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

        Button button3 = (Button)findViewById(R.id.ButtonGoToList);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), List.class);
                startActivity(intent);
            }
        });

    }
}
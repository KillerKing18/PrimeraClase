package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle(R.string.titleDialog);
                alert.setMessage(R.string.messageDialog);
                alert.setPositiveButton(R.string.ok, new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //This code will be executed when the user clicks "ACCEPT"
                            }
                        });
                alert.setNegativeButton(R.string.cancel, new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //This code will be executed when the user clicks "CANCEL"
                            }
                        });
                alert.show();

                Toast.makeText(this,R.string.click2, Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {

            Toast.makeText(this, R.string.backPressed, Toast.LENGTH_LONG).show();
        }

        return super.onKeyDown(keyCode, event); // This to propagate the event and let the back button work as usual after executing the code above
        //return false; // This to avoid the back action by default
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
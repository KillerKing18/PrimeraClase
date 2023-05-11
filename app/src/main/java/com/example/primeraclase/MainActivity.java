package com.example.primeraclase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    UserSQLiteHelper usdbh;
    SQLiteDatabase db;


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
        Log.d("MainActivity", "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usdbh = new UserSQLiteHelper(this);

        Button buttonSQLiteInsert = (Button) findViewById(R.id.buttonSQLiteInsert);
        buttonSQLiteInsert.setOnClickListener(view -> {
            //We open the database in writer mode
            db = usdbh.getWritableDatabase();
            //Check if the database is opened correctly
            if (db != null)
            {
                //We will insert a new row
                usdbh.insertUser(db, 8, "Studio");
                //Close the database
                db.close();
            }
        });

        Button buttonSQLiteUpdate = (Button) findViewById(R.id.buttonSQLiteUpdate);
        buttonSQLiteUpdate.setOnClickListener(view -> {
            //We open the database in writer mode
            db = usdbh.getWritableDatabase();
            //Check if the database is opened correctly
            if (db != null)
            {
                int id = Integer.parseInt(((EditText) findViewById(R.id.editTextSQLiteId)).getText().toString());
                String newValue = ((EditText) findViewById(R.id.editTextSQLiteNewValue)).getText().toString();
                //We will update the row with id = 5
                usdbh.updateUserById(db, id, newValue);
                //Close the database
                db.close();
            }
        });

        Button buttonSQLiteDelete = (Button) findViewById(R.id.buttonSQLiteDelete);
        buttonSQLiteDelete.setOnClickListener(view -> {
            //We open the database in writer mode
            db = usdbh.getWritableDatabase();
            //Check if the database is opened correctly
            if (db != null)
            {
                int id = Integer.parseInt(((EditText) findViewById(R.id.editTextSQLiteId)).getText().toString());
                //Delete the record with id selected by the user
                usdbh.deleteUserById(db, id);
                db.close();
            }
        });

        Button buttonSQLiteQuery = (Button) findViewById(R.id.buttonSQLiteQuery);
        buttonSQLiteQuery.setOnClickListener(view -> {
            db = usdbh.getReadableDatabase();
            Cursor c = usdbh.getUser(db,"User4");
            //We have to check if at least one register exists
            if (c.moveToFirst()) {
                //List all results
                do {
                    @SuppressLint("Range") String code = c.getString(c.getColumnIndex("id"));
                    @SuppressLint("Range") String name = c.getString(c.getColumnIndex("name"));
                    Log.d("MainActivity", code + name);
                } while(c.moveToNext());
            }
            db.close();
        });

        Button buttonSQLiteQueryAll = (Button) findViewById(R.id.buttonSQLiteQueryAll);
        buttonSQLiteQueryAll.setOnClickListener(view -> {
            db = usdbh.getReadableDatabase();
            Cursor c = usdbh.getAllUsers(db);
            //We have to check if at least one register exists
            if (c.moveToFirst()) {
                //List all results
                do {
                    @SuppressLint("Range") String code = c.getString(c.getColumnIndex("id"));
                    @SuppressLint("Range") String name = c.getString(c.getColumnIndex("name"));
                    Log.d("MainActivity", code + name);
                } while(c.moveToNext());
            }
            db.close();
        });

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

    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.d("MainActivity", "onRestart");
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

}
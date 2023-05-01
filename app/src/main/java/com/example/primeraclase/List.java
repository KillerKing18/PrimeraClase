package com.example.primeraclase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class List extends Activity {

    ListView listView;
    String[] teamNames = new String[] { "Real Madrid", "Barcelona"};
    int[] teamImages = {R.drawable.realmadrid, R.drawable.barcelona};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        listView = (ListView) findViewById(android.R.id.list);

        listView.setEmptyView(findViewById(android.R.id.empty));

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                    intent.putExtra("name", teamNames[position]);
                    intent.putExtra("image", teamImages[position]);
                    startActivity(intent);
                }
            });
    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return teamImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView name = view1.findViewById(R.id.teams);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(teamNames[i]);
            image.setImageResource(teamImages[i]);

            return view1;
        }
    }
}

package com.example.sts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadingLocationActivity extends AppCompatActivity {
            UserLogInActivity data;
    ArrayAdapter<String> aA;
    private ListView iv ;


    static String iid;
    static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_location);
        iv = (ListView) findViewById( R.id.listview );

        aA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data.namelist);
        iv.setAdapter(aA);

        iv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (jhunda == 1)
//                    li.set(previousPosition, previousValue);
//                jhunda = 1;
//                previousValue = li.get(position);
//                previousPosition = position;
//                li.set(position, li.get(position) + "          " + phoneNumber.get(position));
//                aA.notifyDataSetChanged();
                    Log.i("pos",""+position);
                Log.i("name",""+data.namelist.get(position));
                Log.i("id",""+data.idlist.get(position));

                name=data.namelist.get(position);
                iid=data.idlist.get(position);
                Intent inte = new Intent(LoadingLocationActivity.this, viewlocations.class);
                startActivity(inte);



            }
        });
    }
}

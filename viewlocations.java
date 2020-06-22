package com.example.sts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sts.model.Locate;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class viewlocations extends AppCompatActivity {
    LoadingLocationActivity data;
    ArrayAdapter<String> aA;
    private ListView iv ;
    List<String> localist;
    List<String> newlist;
    static String longi;
    static String latti;
    LocationActivity ab;
    List<Locate> datalist;
    private DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlocations);

        database = FirebaseDatabase.getInstance().getReference();
        iv = (ListView) findViewById( R.id.listview );
        aA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        localist= new ArrayList<>();
        newlist= new ArrayList<>();

        datalist= new ArrayList<>();
        Log.i("iid",""+data.iid);
        database.child("LOCATION").child(data.iid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());

                    int i=0;
                for (DataSnapshot data : snapshot.getChildren()){
                    localist.add(data.getValue().toString());
                    String s1=localist.get(i);
                    String[] words=s1.split(" ");
                    Log.i("tt",""+localist.get(0));
                    newlist.add(" "+words[3]+words[4]+" ");

                        i++;

                }

                aA.addAll(newlist);
                iv.setAdapter(aA);

                iv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       String s1 =localist.get(position);
                        String[] words=s1.split(" ");
                        Log.i("uu"," "+words[6]+words[9]+" ");
                        longi=words[6];
                        latti=words[9];
                        double Lo = Double.parseDouble(longi);
                        double LA = Double.parseDouble(latti);
                        Intent inte = new Intent(viewlocations.this, LocationActivity.class);
                        startActivity(inte);
                    }
                });

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });





    }
}

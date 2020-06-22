package com.example.sts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sts.ui.Data;
import com.example.sts.ui.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;

public class DisplayActivity extends AppCompatActivity {

    TextView a,b,c,d,e,f,g,i;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mGetReference = mDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        a = (TextView)findViewById(R.id.textView1);
        b = (TextView)findViewById(R.id.textView2);
        c = (TextView)findViewById(R.id.textView3);
        d = (TextView)findViewById(R.id.textView4);
        e = (TextView)findViewById(R.id.textView5);
        f = (TextView)findViewById(R.id.textView6);
        g = (TextView)findViewById(R.id.textViewP);
        i = (TextView)findViewById(R.id.textViewA);

        final DatabaseReference DBref = FirebaseDatabase.getInstance().getReference("EMPLOYEES");
        DBref.child("0016321").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              String n = String.valueOf(dataSnapshot.child("Name").getValue());
              a.setText(n);
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    String v = String.valueOf(dataSnapshot.child("Name").getValue());
                    b.setText(v);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               // Log.w(TAG, "Failed to read value.",
                d.setText((CharSequence) error.toException());
            }
        });
    }
}


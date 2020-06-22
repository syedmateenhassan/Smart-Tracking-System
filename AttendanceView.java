package com.example.sts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.sts.model.User;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceView extends AppCompatActivity {
    UserLogInActivity id;
    User fuser;
    String currentDate,currentTime;
    List<String> datalist;
    private DatabaseReference database;

    public void f(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_view);
        database = FirebaseDatabase.getInstance().getReference();

        SimpleDateFormat dateToday = new SimpleDateFormat("yyy/MM/dd");
        currentDate = dateToday.format(new Date());
        Log.i("cd=",""+currentDate);
        datalist= new ArrayList<>();
        Log.i("id=","id= " +id.hh);
        database.child("ATTENDANCE").child("Attendance of " + currentDate).child(id.hh).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());
                datalist.add(snapshot.getValue().toString());
                       // Log.i("ssssize",""+datalist.get(1));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
f();
    }
}

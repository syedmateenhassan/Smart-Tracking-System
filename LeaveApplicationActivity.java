package com.example.sts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sts.ui.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveApplicationActivity extends AppCompatActivity {

    private Button submitFile;
    private EditText Lname;
    private EditText Ltime;
    private EditText Ldate;
    private EditText Lparagraph;
    private FirebaseAuth mAuth;
    private DatabaseReference database;
    public String currentDate, currentTime;
UserLogInActivity id;
    public void LateAndTime() {
        SimpleDateFormat dateToday = new SimpleDateFormat("yyy/MM/dd");
        currentDate = dateToday.format(new Date());
        Ldate.setText(currentDate);
        SimpleDateFormat timeToday = new SimpleDateFormat("HH:mm aa");
        currentTime = timeToday.format(new Date());
        Ltime.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_application);
        Lname = (EditText) findViewById(R.id.nameLeave);
        Ldate = (EditText) findViewById(R.id.dateLeave);
        Ltime = (EditText) findViewById(R.id.timeLeave);
        Lparagraph = (EditText) findViewById(R.id.paragraphLeave);

        database = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        LateAndTime();

        submitFile = (Button) findViewById(R.id.submitButton);
        submitFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mAuth.getCurrentUser() != null) {
                    database.child("LEAVES").child("Leave applications of " + currentDate).child(id.hh).setValue("Date : " +
                            currentDate+ ", Time : " + currentTime+ ", Name : " + Lname.getText() + ", Reason : " + Lparagraph.getText() , new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError == null) {
                                Toast.makeText(LeaveApplicationActivity.this, "Application Submitted.", Toast.LENGTH_LONG).show();
                                finish();
                                setContentView(R.layout.activity_home);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(LeaveApplicationActivity.this, "Application not submitted", Toast.LENGTH_LONG).show();
                    setContentView(R.layout.activity_home);
                }
            }
        });

    }
}


       /* submitFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference myRef = database.getReference("Leave").child("Application");
                LApplication();
                myRef.child(String.valueOf(maxid+1)).setValue(DaleaveApp);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        myRef.setValue(DaleaveApp);
                        //if(dataSnapshot.exists())
                            maxid=(dataSnapshot.getChildrenCount());
                        Toast.makeText(LeaveApplicationActivity.this,"Submitted",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(LeaveApplicationActivity.this,"Not Submitted",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        */


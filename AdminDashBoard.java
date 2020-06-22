package com.example.sts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sts.ui.Data;

public class AdminDashBoard extends AppCompatActivity {

    Button scanQRBTN;
    Button mapBTN;
    Button leaveBTN;
    Button locationBTN;
    Button attendanceBTN;
    Button settingBTN;
    Button creat;
    TextView title;
    Data info;
    String x;

    static UserLogInActivity dd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_board);
        title = (TextView)findViewById(R.id.infoTextView);
        x=dd.name;
        title.setText(x);
        scanQRBTN = (Button) findViewById(R.id.qrButton);
        scanQRBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),QrScannerActivity.class);
                startActivity(intent);
            }
        });

        mapBTN = (Button) findViewById(R.id.mapButton);
        mapBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        leaveBTN = (Button) findViewById(R.id.leaveButton);
        leaveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LeaveApplicationActivity.class);
                startActivity(intent);
            }
        });

        locationBTN = (Button) findViewById(R.id.livebutton);
        locationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoadingLocationActivity.class);
                startActivity(intent);
            }
        });

        creat = (Button) findViewById(R.id.createNewButton);
        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateNewUserActivity.class);
                startActivity(intent);
            }
        });

        settingBTN = (Button) findViewById(R.id.settingButton);
        settingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        attendanceBTN = (Button) findViewById(R.id.attendButton);
        attendanceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AttendanceView.class);
                startActivity(intent);
            }
        });
    }
}

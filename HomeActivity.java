package com.example.sts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Button scanQRBTN;
    Button mapBTN;
    Button leaveBTN;
    Button locationBTN;
    Button attendanceBTN;
    Button create;
    Button settingBTN;
    TextView i;
    String x;

    static UserLogInActivity dd;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
            x=dd.name;
            i = (TextView)findViewById(R.id.infoTextViewEm);
        i.setText(x);

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
                Intent intent = new Intent(getApplicationContext(),LocationActivity.class);
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

/*
        attendanceBTN = (Button) findViewById(R.id.attendButton);
        attendanceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AttendanceView.class);
                startActivity(intent);
            }
        });
*/

    }
}

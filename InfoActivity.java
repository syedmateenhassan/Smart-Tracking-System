package com.example.sts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView infoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        infoText = (TextView) findViewById(R.id.infoTextView);
        infoText.setText("Contact at Syed.mateen.hassan@gmail.com for email and password!");
    }
}

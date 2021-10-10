package com.krisantus.p5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        String strOutput = getIntent().getStringExtra("OUTPUT");
        TextView total = (TextView) findViewById(R.id.total);
        total.setText(strOutput);
    }
}
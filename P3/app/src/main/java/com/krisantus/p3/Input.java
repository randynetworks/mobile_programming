package com.krisantus.p3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Input extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EditText nama = findViewById(R.id.nama);
        EditText email = findViewById(R.id.email);
        EditText alamat = findViewById(R.id.alamat);

        Button btnSumbit = findViewById(R.id.btn_submit);
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DATA PENGIRIM
                String StrNama = nama.getText().toString();
                String strEmail = email.getText().toString();
                String strAlamat = alamat.getText().toString();

                String MESSAGE = "Data Pengendara\n" +
                        "Nama Lengkap : " + StrNama + "\n" +
                        "Alamat Email : " + strEmail + "\n" +
                        "Alamat       : " + strAlamat + "\n" +
                        "===============================";

                System.out.println(MESSAGE);

                Intent successFormResult = new Intent(getBaseContext(), Success.class);
                successFormResult.putExtra("OUTPUT", MESSAGE);
                startActivity(successFormResult);
            }
        });
    }
}
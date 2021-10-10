package com.krisantus.p4;

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
        EditText nik = findViewById(R.id.nik);
        EditText alamat = findViewById(R.id.alamat);

        Button btnSumbit = findViewById(R.id.btn_submit);
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DATA PENGIRIM
                String StrNama = nama.getText().toString();
                String strNIK = nik.getText().toString();
                String strAlamat = alamat.getText().toString();

                String MESSAGE = "Data Vaksin\n" +
                        "Nama Lengkap : " + StrNama + "\n" +
                        "NIK          : " + strNIK + "\n" +
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
package com.krisantus.p5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Input extends Activity {

    String strCovid;
    String strStatus;
    String strUmur;

    String[] arrStatus = {
          "Pelajar",
            "Mahasiswa",
            "Pegawai Negeri"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EditText nama = findViewById(R.id.nama);
        EditText nik = findViewById(R.id.nik);
        EditText alamat = findViewById(R.id.alamat);
        EditText kode = findViewById(R.id.kodeVaksin);
        RadioGroup covid = findViewById(R.id.covid);

        Spinner status = findViewById(R.id.status);
// inisialiasi Array Adapter dengan memasukkan string array di atas
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arrStatus);

        // mengeset Array Adapter tersebut ke Spinner
        status.setAdapter(adapter);

        status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String item = String.valueOf(status.getSelectedItem());

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strStatus = (item.equals(status.getSelectedItem())) ? "" : parent.getItemAtPosition(position).toString();
                Toast.makeText(Input.this, "Kamu Memilih " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner umur = findViewById(R.id.umur);

        umur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String item = String.valueOf(status.getSelectedItem());

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strUmur = (item.equals(status.getSelectedItem())) ? "" : parent.getItemAtPosition(position).toString();
                Toast.makeText(Input.this, "Kamu Memilih " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        covid.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    strCovid = checkedRadioButton.getText().toString();
                }
            }
        });

        Button btnSumbit = findViewById(R.id.btn_submit);
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(Input.this);
                dialog.setTitle("Yakin disimpan?");

                dialog.setPositiveButton("Data valid?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // DATA PENGIRIM
                        String StrNama = nama.getText().toString();
                        String strNIK = nik.getText().toString();
                        String strAlamat = alamat.getText().toString();
                        String strKode = kode.getText().toString();

                        String MESSAGE = "Data Vaksin\n" +
                                "Nama Lengkap : " + StrNama + "\n" +
                                "NIK          : " + strNIK + "\n" +
                                "Alamat       : " + strAlamat + "\n" +
                                "Kode       : " + strKode + "\n" +
                                "Covid?       : " + strCovid + "\n" +
                                "======================  =========";

                        System.out.println(MESSAGE);

                        Toast.makeText(Input.this, MESSAGE, Toast.LENGTH_LONG).show();

                        Intent successFormResult = new Intent(getBaseContext(), Success.class);
                        successFormResult.putExtra("OUTPUT", MESSAGE);
                        startActivity(successFormResult);
                    }
                });
                dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();

            }
        });
    }
}
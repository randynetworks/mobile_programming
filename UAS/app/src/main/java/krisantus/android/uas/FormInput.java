package krisantus.android.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class FormInput extends AppCompatActivity {

    String tipe;
    String diterima;
    String strLunas;
    String strPlastic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);

        // ===================== EDIT TEXT =============================
        EditText nama_barang = findViewById(R.id.input_barang);
        EditText input_keterangan = findViewById(R.id.input_keterangan);
        EditText inputNomorBarang = findViewById(R.id.input_nomor_barang);
        EditText inputJenisBarang = findViewById(R.id.input_jenis_barang);
        EditText inputJumlahBarang = findViewById(R.id.jml_barang);




        // ===================== RADIO GROUP =============================
        RadioGroup pakaiPlastic = findViewById(R.id.pakai_plastic);

        pakaiPlastic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked)
                {
                    strPlastic = checkedRadioButton.getText().toString();
                    Toast.makeText(FormInput.this, "Kamu Memilih " + strPlastic, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // ===================== SWITCH =============================
        Switch lunas = findViewById(R.id.s_lunas);

        lunas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                strLunas = (isChecked) ? "Lunas Dong" : "Nyicil";
                Toast.makeText(FormInput.this, "Kamu Memilih " + strLunas, Toast.LENGTH_SHORT).show();

            }
        });


        // ===================== CHECKBOX =============================

        CheckBox cb_diterima = findViewById(R.id.cb_diterima);

        cb_diterima.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                diterima = (isChecked) ? "Diterima" : "Tidak Diterima";
                Toast.makeText(FormInput.this, "Kamu Memilih " + diterima, Toast.LENGTH_SHORT).show();
            }
        });


        // ===================== SPINNER =============================
        Spinner tipeBuah = findViewById(R.id.tipe_buah);

        tipeBuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String item = String.valueOf(tipeBuah.getSelectedItem());
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipe = (item.equals(tipeBuah.getSelectedItem())) ? "" : parent.getItemAtPosition(position).toString();
                Toast.makeText(FormInput.this, "Kamu Memilih " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // ===================== SUBMIT FORM =============================

        Button btnSumbit = findViewById(R.id.btn_submit);
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ===================== ALERT DIALOG YES NO =============================
                AlertDialog.Builder dialog = new AlertDialog.Builder(FormInput.this);
                dialog.setTitle("Yakin disimpan?");
                dialog.setIcon(R.drawable.icon_info);

                dialog.setPositiveButton("Data Valid", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // DATA PENGIRIM
                        String strBarang = nama_barang.getText().toString();
                        String strKeterangan = input_keterangan.getText().toString();
                        String strNomorBarang = inputNomorBarang.getText().toString();
                        String strJenisBarang = inputJenisBarang.getText().toString();
                        Integer strJmlBarang = Integer.valueOf(inputJumlahBarang.getText().toString());

                        // HASIL
                        int TotalHarga =  strJmlBarang * 50000;


                        String MESSAGE = "Data Barang\n" +
                                "Nama Barang : " + strBarang + "\n" +
                                "Keterangan Barang : " + strKeterangan +  "\n" +
                                "Nomor Barang : " + strNomorBarang + "\n" +
                                "Jenis Barang  : " + strJenisBarang + "\n" +
                                "Jumlah Barang  : " + strJmlBarang + "\n" +
                                "Informasi Lainnya\n" +
                                "Menggunakan Kantung Plastic : " + strPlastic + "\n" +
                                "Lunas? : "+ strLunas + "\n" +
                                "Diterima? : " + diterima + "\n" +
                                "Total Yang Harus Dibayar : \n" +
                                "======== " + TotalHarga + " ========\n" ;

                        System.out.println(MESSAGE);

                        Intent successFormResult = new Intent(getBaseContext(), Success.class);
                        successFormResult.putExtra("OUTPUT", MESSAGE);
                        startActivity(successFormResult);
                    }
                });
                dialog.setNegativeButton("Data Tidak Valid", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(FormInput.this, "Data Gagal Disimpan.", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });
    }
}
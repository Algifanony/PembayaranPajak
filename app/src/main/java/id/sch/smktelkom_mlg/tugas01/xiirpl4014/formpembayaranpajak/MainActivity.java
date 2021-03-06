package id.sch.smktelkom_mlg.tugas01.xiirpl4014.formpembayaranpajak;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etNomor;
    Button bSubmit;
    CheckBox cb1, cb2, cb3, cb4;
    RadioGroup rgVia;
    TextView tvHasil;
    Spinner Sppajak;
    String cbHasil1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.tulisnama);
        etNomor = (EditText) findViewById(R.id.tulisnomor);
        bSubmit = (Button) findViewById(R.id.submit);
        tvHasil = (TextView) findViewById(R.id.textviewhasil);
        rgVia = (RadioGroup) findViewById(R.id.radioGroup);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        Sppajak = (Spinner) findViewById(R.id.sppajak);

        kondisiawal();
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void kondisiawal() {
        etNama.setText("");
        etNomor.setText("");
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        rgVia.clearCheck();
        Sppajak.setSelection(0);
        cbHasil1 = "";
    }

    private void doClick() {
        if (isValid())
            if (isVal())

            {
                String nama = etNama.getText().toString();
                String nomor = etNomor.getText().toString();
                int strartlen1 = cbHasil1.length();
                String irb;

                if (cb1.isChecked()) cbHasil1 += "\t- " + cb1.getText() + "\n";
                if (cb2.isChecked()) cbHasil1 += "\t- " + cb2.getText() + "\n";
                if (cb3.isChecked()) cbHasil1 += "\t- " + cb3.getText() + "\n";
                if (cb4.isChecked()) cbHasil1 += "\t- " + cb4.getText() + "\n";
                if (cbHasil1.length() == strartlen1) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Anda Belum Memilih Bukti Pembayaran !!");
                    builder1.setCancelable(true);

                    builder1.setNeutralButton(
                            "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                }
                if (rgVia.getCheckedRadioButtonId() != -1) {
                    RadioButton rb = (RadioButton) findViewById(rgVia.getCheckedRadioButtonId());
                    irb = rb.getText().toString();
                } else {
                    irb = null;
                }
                if (irb == null) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Anda Belum Memilih Via Pembayaran!!");
                    builder1.setCancelable(true);

                    builder1.setNeutralButton(
                            "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog Alert11 = builder1.create();
                    Alert11.show();
                } else {
                    tvHasil.setText("Nama Pembayar : " + nama + "\nJenis Pajak :" + Sppajak.getSelectedItem().toString() + "\nNomor : " + nomor +
                            "\nVia Pembayaran : " + irb + "\n Bukti Pembayaran :" + cbHasil1);
                    kondisiawal();

                }
            }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String nomor = etNomor.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
    } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
}

    private boolean isVal() {
        boolean valid = true;

        String nomor = etNomor.getText().toString();

        if (nomor.isEmpty()) {
            etNomor.setError("Nomor Belum Diisi");
            valid = false;
        } else if (nomor.length() < 8) {
            etNomor.setError("Nomor Minimal 8 Karakter");
            valid = false;
        } else {
            etNomor.setError(null);
        }
        return valid;
    }
}

package com.hmikup.fundamentalandroid;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar mCalendar = Calendar.getInstance();
    private Button modalDate;
    private Button modalSubmit;
    private Button modal;
    private Button tab_btn;
    private TextView hasil;
    private EditText nama;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modalDate=findViewById(R.id.submit);
        modal=findViewById(R.id.modal);
        modalDate=findViewById(R.id.modal_date);
        modalSubmit=findViewById(R.id.submit);
        hasil=findViewById(R.id.textHasil);
        nama=findViewById(R.id.input_nama);
        spinner=findViewById(R.id.input_spinner);
        tab_btn=findViewById(R.id.btn_tab);
        modalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDate();
            }
        });
        modal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAlert();
            }
        });
        modalSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data_nama= String.valueOf(nama.getText());
                String data_spinner = String.valueOf(spinner.getItemAtPosition(spinner.getSelectedItemPosition()));
                hasil.setText("Nama saya :" + data_nama + " dan saya memilih marketplace " + data_spinner);
                Toast.makeText(MainActivity.this, "Nama saya :" + data_nama + " dan saya memilih marketplace " + data_spinner, Toast.LENGTH_SHORT).show();
            }
        });
        tab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TabActivity.class));
            }
        });
    }

    void dialogDate(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, monthOfYear);
                mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String date = DateFormat.getDateInstance(DateFormat.MEDIUM).format(mCalendar.getTime());
                Toast.makeText(MainActivity.this, "Selected date is " + date, Toast.LENGTH_SHORT).show();
            }
        }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    void dialogAlert(){
        new AlertDialog.Builder(this)
                .setTitle("Nuke planet Jupiter?")
                .setMessage("Note that nuking planet Jupiter will destroy everything in there.")
                .setPositiveButton("Nuke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Sending atomic bombs to Jupiter", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Abort", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Aborting mission...", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}

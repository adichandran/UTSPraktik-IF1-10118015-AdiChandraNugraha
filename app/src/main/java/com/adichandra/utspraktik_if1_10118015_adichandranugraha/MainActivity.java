package com.adichandra.utspraktik_if1_10118015_adichandranugraha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Month;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtnik, edtnama, edtdate;
    Button selanjutnya;
    SharedPreferences preferences;
    SimpleDateFormat dateFormetter;
    RadioGroup kel, hub;
    RadioButton rkel, rhub;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NIK = "nik";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_TTL = "ttl";
    private static final String KEY_KEL = "Kel";
    private static final String KEY_HUB = "hub";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnik = findViewById(R.id.edtnik);
        edtnama = findViewById(R.id.edtnama);
        edtdate = findViewById(R.id.edtDate);
        kel = findViewById(R.id.jeniskelamin);
        hub = findViewById(R.id.hubungan);

        dateFormetter = new SimpleDateFormat("dd MMMM yyyy");
        selanjutnya = findViewById(R.id.selanjutnya);

        preferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        edtdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar newdate = Calendar.getInstance();
                        newdate.set(year, month, dayOfMonth);
                        edtdate.setText(dateFormetter.format(newdate.getTime()));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });


        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getvalueradio();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(KEY_NIK,edtnik.getText().toString());
                editor.putString(KEY_NAMA,edtnama.getText().toString());
                editor.putString(KEY_TTL,edtdate.getText().toString());
                editor.putString(KEY_KEL,rkel.getText().toString());
                editor.putString(KEY_HUB,rhub.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    private void getvalueradio() {
        // get selected radio button from radioGroup
        int selectedId = kel.getCheckedRadioButtonId();
        int selectedId2 = hub.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        rkel = (RadioButton) findViewById(selectedId);
        rhub = (RadioButton) findViewById(selectedId2);
    }
}
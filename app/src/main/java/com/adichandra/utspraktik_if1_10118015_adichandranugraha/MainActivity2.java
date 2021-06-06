package com.adichandra.utspraktik_if1_10118015_adichandranugraha;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    EditText edtnik, edtnama, edtdate, edtkel, edthub;
    SharedPreferences preferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NIK = "nik";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_TTL = "ttl";
    private static final String KEY_KEL = "Kel";
    private static final String KEY_HUB = "hub";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtnik = findViewById(R.id.edtnik);
        edtnama = findViewById(R.id.edtnama);
        edtdate = findViewById(R.id.edtTtl);
        edtkel = findViewById(R.id.editTextkel);
        edthub = findViewById(R.id.editTexthub);

        preferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String nik = preferences.getString(KEY_NIK,null);
        String nama = preferences.getString(KEY_NAMA,null);
        String ttl = preferences.getString(KEY_TTL,null);
        String kel = preferences.getString(KEY_KEL,null);
        String hub = preferences.getString(KEY_HUB,null);

        edtnik.setText(nik);
        edtnama.setText(nama);
        edtdate.setText(ttl);
        edtkel.setText(kel);
        edthub.setText(hub);

        Dialog dialog;
        Button simpan = findViewById(R.id.simpan);
        Button ubah = findViewById(R.id.ubah);

        dialog = new Dialog(this);

        //OnClick Button instagram
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.dialog);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void btnselanjutnya(View view) {
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}
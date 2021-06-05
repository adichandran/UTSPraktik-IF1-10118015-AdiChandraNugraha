package com.adichandra.utspraktik_if1_10118015_adichandranugraha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnselanjutnya(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
        finish();
    }
}
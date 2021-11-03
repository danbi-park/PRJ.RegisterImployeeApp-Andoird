package com.example.android_pdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnRegister, btnList, btnEnd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> {callReg();});

        btnList = findViewById(R.id.btnList);
        btnList.setOnClickListener(v -> {callList();});

        btnEnd = findViewById(R.id.btnEnd);
        btnEnd.setOnClickListener(v -> {
            callEnd();
        });
    }

    public void callReg() {
        Intent intent = new Intent(getApplicationContext(), com.example.android_pdb.RegActivity.class);
        startActivity(intent);
    }

    public void callList() {
        Intent intent = new Intent(getApplicationContext(), com.example.android_pdb.ListActivity.class);
        Log.i(">>", "ListActivity");
        startActivity(intent);
    }

    public void callEnd() {
        finish();
    }
}
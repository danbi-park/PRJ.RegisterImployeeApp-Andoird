package com.example.android_pdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegActivity extends AppCompatActivity {
    EditText edName, edEmail, edMobile;
    MySQLiteHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        handler = MySQLiteHandler.open(this);

        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edMobile = findViewById(R.id.edMobile);

        Button btnReg = findViewById(R.id.btnReg);
        Button btnRegBack = findViewById(R.id.btnRegBack);

        btnReg.setOnClickListener(v->{
            String name = edName.getText().toString();
            String email = edEmail.getText().toString();
            String mobile = edMobile.getText().toString();

            if(name == null || name.equals("")) {
                Toast.makeText(this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                edName.requestFocus();
                return;
            }
            if(email == null || email.equals("")) {
                Toast.makeText(this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                edEmail.requestFocus();
                return;
            }
            if(mobile == null || mobile.equals("")) {
                Toast.makeText(this, "연락처를 입력하세요.", Toast.LENGTH_SHORT).show();
                edMobile.requestFocus();
                return;
            }

            handler.insert(name, email, mobile);
            finish();
        });

        btnRegBack.setOnClickListener(v->{
            finish();
        });

    }


}
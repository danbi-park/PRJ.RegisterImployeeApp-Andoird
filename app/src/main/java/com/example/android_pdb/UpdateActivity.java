package com.example.android_pdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    private EditText mdId, mdName, mdEmail, mdMobile;
    private Button btnUpdate, btnModBack;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        mdId = findViewById(R.id.mdId);
        mdName = findViewById(R.id.mdName);
        mdEmail = findViewById(R.id.mdEmail);
        mdMobile = findViewById(R.id.mdMobile);

        Intent intent = getIntent();
        employee = intent.getParcelableExtra("employee");
        mdId.setText(employee.get_id()+"");
        mdName.setText(employee.getName()+"");
        mdEmail.setText(employee.getEmail()+"");
        mdMobile.setText(employee.getMobile()+"");

        Button btnUpdate = findViewById(R.id.btnUpdate);
        Button btnModBack = findViewById(R.id.btnModBack);

    }

    public void confirmUpd(View view) {
        MySQLiteHandler handler = MySQLiteHandler.open(this);

        int id = employee.get_id();
        String name  = mdName.getText().toString();
        String email = mdEmail.getText().toString();
        String mobile = mdMobile.getText().toString();
        employee = new Employee(id,name,email,mobile);


        if(name == null || name.equals("")) {
            Toast.makeText(this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
            mdName.requestFocus();
            return;
        }
        if(email == null || email.equals("")) {
            Toast.makeText(this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
            mdEmail.requestFocus();
            return;
        }
        if(mobile == null || mobile.equals("")) {
            Toast.makeText(this, "연락처를 입력하세요.", Toast.LENGTH_SHORT).show();
            mdMobile.requestFocus();
            return;
        }


        handler.update(id, name,email,mobile);

        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("employee", employee);
        startActivity(intent);

        Toast.makeText(this, "수정되었습니다", Toast.LENGTH_SHORT).show();
        finish();
    }




}
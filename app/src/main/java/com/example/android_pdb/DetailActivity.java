package com.example.android_pdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView dtId, dtName, dtEmail, dtMobile;
    Employee employee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dtId = findViewById(R.id.dtId);
        dtName = findViewById(R.id.dtName);
        dtEmail = findViewById(R.id.dtEmail);
        dtMobile = findViewById(R.id.dtMobile);

        Intent intent = getIntent();
        employee = intent.getParcelableExtra("employee"); //ListActivity에서 employee라고 했기 때문에
        Log.i("item>>", String.valueOf(employee));

        dtId.setText(employee.get_id()+"");
        dtName.setText(employee.getName()+"");
        dtEmail.setText(employee.getEmail()+"");
        dtMobile.setText(employee.getMobile()+"");
        Log.i(">>>>>>>>>>", String.valueOf(dtId) + dtEmail);

    }


    public void goBack(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }

    public void callUpdate(View view){
        Intent intentSel = new Intent(getApplicationContext(), UpdateActivity.class);
        intentSel.putExtra("employee", employee);
        startActivity(intentSel);

        finish();
    }

    public void delete(View view) {
        MySQLiteHandler handler = MySQLiteHandler.open(this);
        handler.delete(employee.get_id());
        Toast.makeText(this,"삭제되었습니다.",Toast.LENGTH_SHORT).show();
        finish();
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }



}

package com.example.android_pdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EmployeeAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    MySQLiteHandler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        ArrayList<Employee> list = new ArrayList<>();
        handler = MySQLiteHandler.open(this);
        handler.select(list);

        adapter = new EmployeeAdapter(list);
        adapter.setOnEmployeeItemClickListener(new OnEmployeeItemClickListener() {
            @Override
            public void onItemClick(EmployeeAdapter.ViewHolder holder, View view, int position) {
                Employee item = adapter.getItem(position);
                //선택한 항목 상세보기
                Log.i("item>>", String.valueOf(item));
                Intent intentSel = new Intent(getApplicationContext(), DetailActivity.class);
                intentSel.putExtra("employee", item); //이때 액티비티 이동과 동시에 이전 액티비티에서 이동하는 액티비티로 어떤 값을 넘기고 싶다면
                startActivity(intentSel);
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<Employee> list = new ArrayList<>();
        handler = MySQLiteHandler.open(this);
        handler.select(list);
        Log.i(">>", list.toString());
        adapter.updateData(list);
    }
}

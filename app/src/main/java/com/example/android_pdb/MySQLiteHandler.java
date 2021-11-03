package com.example.android_pdb;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class MySQLiteHandler {

    SQLiteDatabase db;
    DatabaseHelper helper;

    public MySQLiteHandler(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    //데이터베이스 open
    public static MySQLiteHandler open(Context ctx){
        return new MySQLiteHandler(ctx);
    }

    //데이터베이스 close
    public void close(){
        helper.close();
    }

    //데이터 저장
    public void insert(String name, String email, String mobile){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name" , name);
        values.put("email" , email);
        values.put("mobile" , mobile);
        db.insert("emp", null, values);
    }

    //데이터 수정
    public void update(int _id, String name, String email, String mobile){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("_id", _id);
        values.put("name" , name);
        values.put("email", email);
        values.put("mobile" , mobile);
        db.update("emp", values, "_id=?", new String[]{String.valueOf(_id)});
    }

    //데이터 삭제
    public void delete(int _id){
        db = helper.getWritableDatabase();
        db.delete("emp","_id=?", new String[]{_id+""});
    }

    //데이터 조회
    @SuppressLint("Range")
    public void select(ArrayList<Employee> list) {
        db = helper.getReadableDatabase();
        Cursor c = db.query("emp", null, null,null, null, null, null);

        while (c.moveToNext()) {
            int _id = c.getInt(c.getColumnIndex("_id"));
            String name = c.getString(c.getColumnIndex("name"));
            String email = c.getString(c.getColumnIndex("email"));
            String mobile = c.getString(c.getColumnIndex("mobile"));
            Employee employee = new Employee(_id, name, email ,mobile);
            list.add(employee);
            Log.i("emp:", employee.toString());
        }
    }


}

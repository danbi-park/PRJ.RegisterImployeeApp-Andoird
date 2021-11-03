package com.example.android_pdb;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Employee implements Parcelable {
    private int _id;
    private String name;
    private String email;
    private String mobile;
    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public Employee(int _id, String name, String email, String mobile) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Employee(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        email = in.readString();
        mobile = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(mobile);
    }

    public int get_id() {return _id;}
    public void set_id(int _id) {this._id = _id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public String getMobile() {return mobile;}
    public void setMobile(String mobile) {this.mobile = mobile;}

    @NonNull
    @Override
    public String toString() {
        return _id+"/"+name+"/"+email+"/"+mobile+"\n";
    }
}
package com.example.skripsi2;

import com.google.gson.annotations.SerializedName;

public class Contact {

    //    @SerializedName("id") private int Id;
    @SerializedName("id") private String Pa;
    @SerializedName("code") private String User;
    @SerializedName("pesan") private String Pesan;

//    public int getId() {
//        return Id;
//    }

    public String getPa() {
        return Pa;
    }

    public String getUser() {
        return User;
    }

    public String getPesan() {
        return Pesan;
    }

}
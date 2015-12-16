package com.github.vrcca.retrofitcustomadapterexample.model;

import com.google.gson.annotations.SerializedName;

public class Admin extends User {

    @SerializedName("master_key")
    private String masterKey;

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }
}

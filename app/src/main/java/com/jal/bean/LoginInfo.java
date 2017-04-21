package com.jal.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SEELE on 2017/4/21.
 */

public class LoginInfo implements Serializable{


    /**
     * username : xiaoyi
     * code : 1
     * city : ["深圳","北京","广州"]
     */

    private String username;
    private int code;
    private List<String> city;

    @Override
    public String toString() {
        return "LoginInfo{" +
                "username='" + username + '\'' +
                ", code=" + code +
                ", city=" + city +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }
}

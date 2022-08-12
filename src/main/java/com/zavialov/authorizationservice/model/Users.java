package com.zavialov.authorizationservice.model;

import java.util.*;

public class Users {
    private final String userName;
    private final String password;
    private static final int READ_INDEX = 0;
    private static final int WRITE_INDEX = 1;
    private static final int DELETE_INDEX = 2;
    private final List<Authorities> accessData;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAccessData() {
        return accessData;
    }

    public Users(String userName, String password, String read, String write, String delete) {
        this.userName = userName;
        this.password = password;
        this.accessData = new ArrayList<>();
        if (read.equals("read")) {
            accessData.add(READ_INDEX, Authorities.READ);
        } else {
            accessData.add(READ_INDEX, null);
        }
        if (write.equals("write")) {
            accessData.add(WRITE_INDEX, Authorities.WRITE);
        } else {
            accessData.add(WRITE_INDEX ,null);
        }
        if (delete.equals("delete")) {
            accessData.add(DELETE_INDEX, Authorities.DELETE);
        }else {
            accessData.add(DELETE_INDEX ,null);
        }
    }

    public void setUserRead() {
        this.accessData.set(READ_INDEX, Authorities.READ);
    }

    public void setUserWrite() {
            this.accessData.set(WRITE_INDEX, Authorities.WRITE);
    }

    public void setUserDelete() {
        this.accessData.set(DELETE_INDEX, Authorities.DELETE);
    }

}
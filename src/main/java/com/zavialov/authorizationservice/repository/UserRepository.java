package com.zavialov.authorizationservice.repository;

import com.zavialov.authorizationservice.model.Authorities;
import com.zavialov.authorizationservice.model.Users;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserRepository {
private CopyOnWriteArrayList<Users> userList= new CopyOnWriteArrayList<>() {
    {add(new Users("Ivan", "puppet", "read", "", ""));}
    {add(new Users("Alex", "majesty", "read", "write", ""));}
    {add(new Users("Pavel", "highlight", "read", "", ""));}
    {add(new Users("Stanislav", "miserable", "read", "write", "delete"));}
    {add(new Users("Roman", "cucumber", "read", "", "delete"));}
    {add(new Users("Mikhail", "jellyfish", "read", "write", ""));}
    {add(new Users("Andrei", "cockroach", "read", "write", ""));}
    {add(new Users("Sergei", "imagine", "read", "", ""));}
    {add(new Users("Ruslan", "premarital", "read", "write", "delete"));}
    {add(new Users("Petr", "participant", "read", "", "delete"));}
};


    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> result = null;
        for (Users userData : userList) {
            if (userData.getUserName().equals(user) && userData.getPassword().equals(password)) {
                result = userData.getAccessData();
            }
        }
        return result;
    }

    public void addUser (String name, String password, String read, String write, String delete) {
        userList.add(new Users(name, password,read, write, delete));
    }
}

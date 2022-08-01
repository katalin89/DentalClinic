package com.company;

import model.User;

public class Main {
    public static void main(String[] args) {
        User user=new User(1,1,"alin","alin@yahoo.com","2012","test");
        User user2=new User(1,1,"alin1","alin@yahoo.com","2012","test");
        System.out.println(user.equals(user2)) ;
    }

}

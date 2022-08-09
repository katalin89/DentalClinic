package com.company;

import model.*;

public class Main {
    public static void main(String[] args) {
    Doctors doctors=new Doctors(1,1,"Alex","alex@yahoo.com","1988.03.12","Dezrobirii nr 2","076365","123","alex");
        Doctors doctors2=new Doctors(1,1,"Alex","alex@yahoo.com","1988.03.12","Dezrobirii nr 2","076365","123","alex");
        System.out.println(doctors.equals(doctors2));
    }

}

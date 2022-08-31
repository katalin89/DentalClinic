package com.company;

import model.*;
import view.ViewPatient;

public class Main {
    public static void main(String[] args) {
        Patient patient=new Patient(1,1,"Andrei","And@yahoo.com","1999","Dezrobirii","7545","123","test");

        ViewPatient viewPatient=new ViewPatient(patient);
    viewPatient.play();

    }


}

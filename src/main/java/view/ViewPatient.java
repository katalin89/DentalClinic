package view;

import model.Patient;
import model.Problems;
import model.Programare;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ViewPatient extends View {
    private Patient patient;

    public ViewPatient(Patient patient) {
        this.patient = patient;
    }

    public void meniu() {
        System.out.println("Apasa tasta 1 pentru afisa problemele pacientului");
        System.out.println("Apasa tasta 2 pentru a afisa  toti doctori");
        System.out.println("Apasa tasta 3 pentru a afisa asistenta");
        System.out.println("Apasa tasta 4 pentru a afisa programarile");
        System.out.println("Apasa tasta 5 pentru a adauga o programare");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int alegere = 0;
        while (run == true) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afiseazaProblema();
                    break;
                case 2:
                    afiseazaDoctorii();
                    break;
                case 4:
                    afiseazaProgramarile();
                    break;
                case 5:
                    adaugaProgramare();
                    break;
            }

        }
    }

    public void afiseazaProgramarile() {
        System.out.println(String.format("Programarile pacientului: %s sunt", patient.getName()));
        List<Programare> programareList = repositoryProgramare.listProgramareByPatient(patient.getId());
        for (Programare programare : programareList) {
            System.out.println(String.format("doctorId: %d ,date: %s", programare.getDoctorId(), programare.getProgramDate()));
        }
    }

    public void adaugaProgramare()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id ul doctorului");
        String i = scanner.nextLine();
        int doctorId = Integer.parseInt(i);
        System.out.println("Introduceti data si ora yyyy-MM-dd HH:mm");
        String data = scanner.nextLine();
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Programare programare = new Programare(doctorId, patient.getId(), date1);
        repositoryProgramare.insertProgramare(programare);
    }

    public void afiseazaProblema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id");
        String i = scanner.nextLine();
        int id = Integer.parseInt(i);
        System.out.println("Introduceti name");
        String name = scanner.nextLine();
        System.out.println("introduceti type");
        String type = scanner.nextLine();
        System.out.println("Introduceti descrierea");
        String description = scanner.nextLine();

        List<Problems> probleme = repositoryProblems.allProblems();
        for (Problems p : probleme) {
            System.out.println(p.toString());
        }

    }

    public void afiseazaDoctorii() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti name");
        String name = scanner.nextLine();
        repositoryDoctors.returnDoctorNume("Ani");


    }
}

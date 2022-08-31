package view;

import model.Patient;
import model.Problems;
import repository.RepositoryPatient;
import repository.RepositoryProblems;

import java.util.List;
import java.util.Scanner;

import static view.View.repositoryDoctors;
import static view.View.repositoryProblems;

public class ViewPatient {

    public  ViewPatient(Patient patient){
        RepositoryPatient repositoryPatient=new RepositoryPatient();
        RepositoryProblems repositoryProblems=new RepositoryProblems();
    }

    public void meniu(){
        System.out.println("Apasa tasta 1 pentru afisa problemele pacientului");
        System.out.println("Apasa tasta 2 pentru a afisa  toti doctori");
        System.out.println("Apasa tasta 3 pentru a afisa asistenta");

    }
    public  void play(){
        Scanner scanner=new Scanner(System.in);
        boolean run=true;
        int alegere=0;
        while(run==true){
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:afiseazaProblema();
                break;
                case 2:afiseazaDoctorii();
                break;

            }

        }
    }

    public  void afiseazaProblema(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Introduceti id");
        String i= scanner.nextLine();
        int id=Integer.parseInt(i);
        System.out.println("Introduceti name");
        String name=scanner.nextLine();
        System.out.println("introduceti type");
        String type=scanner.nextLine();
        System.out.println("Introduceti descrierea");
        String description=scanner.nextLine();

        List<Problems>probleme=repositoryProblems.allProblems();
        for (Problems p:probleme){
            System.out.println(p.toString());
        }

    }

    public void afiseazaDoctorii(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti name");
        String name= scanner.nextLine();
        repositoryDoctors.returnDoctorNume("Ani");


    }
}

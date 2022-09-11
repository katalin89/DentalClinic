package repository;

import model.Permission;
import model.Programare;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProgramare extends Repository {

    public void insertProgramare(Programare programare) {
        String insertTo = "";
        insertTo += " insert into programare ( doctor_id,patient_id,program_date) values(";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        insertTo += String.format("%d, %d, '%s'", programare.getDoctorId(), programare.getPatientId()
                , simpleDateFormat.format(programare.getProgramDate()));
        insertTo += ")";
        executeStatement(insertTo);
    }

    private ResultSet allProgramare() {
        executeStatement("select * from programare");
        try {
            return statement.getResultSet();

        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public List<Programare> listAllProgramare() {
        ResultSet set = allProgramare();
        List<Programare> programares = new ArrayList<>();
        try {
            while (set.next()) {
                programares.add(new Programare(set.getInt(1), set.getInt(2), set.getDate(3)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
        }
        return programares;
    }

    public List<Programare> listProgramareByPatient(int patientId) {
        ResultSet set = null;

        executeStatement(String.format("select * from programare where patient_id = %d", patientId));
        try {
            set = statement.getResultSet();

        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }

        List<Programare> programares = new ArrayList<>();
        try {
            while (set.next()) {
                programares.add(new Programare(set.getInt(1), set.getInt(2), set.getDate(3)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
        }
        return programares;
    }

    public List<Programare> listProgramareByDoctor(int doctorId) {
        ResultSet set = null;

        executeStatement(String.format("select * from programare where doctor_id = %d", doctorId));
        try {
            set = statement.getResultSet();

        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }

        List<Programare> programares = new ArrayList<>();
        try {
            while (set.next()) {
                programares.add(new Programare(set.getInt(1), set.getInt(2), set.getDate(3)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
        }
        return programares;
    }

}

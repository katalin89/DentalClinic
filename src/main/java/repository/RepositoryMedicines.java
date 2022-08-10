package repository;

import model.Medicines;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryMedicines extends Repository {
    public RepositoryMedicines() {
        super();
    }

    public void insertMedicines(Medicines medicines) {
        String insertTo = "";
        insertTo += " insert into medicines (name, type, company, cost) values(";
        insertTo += String.format("%s, '%s', '%s', '%d'",
                medicines.getName(),
                medicines.getType(),
                medicines.getCompany(),
                medicines.getCost());
        insertTo += ")";
        executeStatement(insertTo);
    }

    public void stergeMedicinesById(int id) {
        String delete = String.format("delete from medicines where id = %d", id);
        executeStatement(delete);
    }

    public void updateDescription(int id, String description) {
        String update = String.format("update medicines set description = '%s'", description);
        update += String.format("where id= %d", id);
        executeStatement(update);
    }

    private ResultSet allDuration() {
        executeStatement("select * from medicines");
        try {
            return statement.getResultSet();
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public List<Medicines> allMedicines() {
        ResultSet set = allDuration();
        List<Medicines> mediciness = new ArrayList<>();
        try {
            while (set.next()) {
                mediciness.add(new Medicines(set.getInt(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
        }
        return mediciness;
    }
}

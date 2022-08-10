package repository;

import model.Doctors;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDoctors extends Repository {
    public RepositoryDoctors() {
        super();
    }

    public void insertDoctors(Doctors doctors) {
        String insertTo = "";
        insertTo += "insert into doctors (id, name, email, dob, address, mobile, password, username) values(";
        insertTo += String.format("%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s' ", doctors.getRoleId(),
                doctors.getName(),
                doctors.getEmail(),
                doctors.getDob(),
                doctors.getAddress(),
                doctors.getMobile(),
                doctors.getPassword(),
                doctors.getUsename());
        insertTo += ")";
        executeStatement(insertTo);
    }

    public void stergeDoctorsById(int id) {
        String delete = String.format("delete from doctors where id = %d", id);
        executeStatement(delete);
    }

    public void updateEmail(int id, String description) {
        String update = String.format("update doctors set email = '%s'", description);
        update += String.format("where id= %d", id);
        executeStatement(update);
    }

    private ResultSet allDuration() {
        executeStatement("select * from doctors");
        try {
            return statement.getResultSet();

        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public List<Doctors> allDoctors() {
        ResultSet set = allDuration();
        List<Doctors> doctorss = new ArrayList<>();
        try {
            while (set.next()) {
                doctorss.add(new Doctors(set.getInt(1),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6),
                        set.getString(7),
                        set.getString(8),
                        set.getString(9)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
        }
        return doctorss;
    }
}

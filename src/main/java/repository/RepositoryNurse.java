package repository;

import model.Nurse;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryNurse extends Repository {
    public RepositoryNurse() {
        super();
    }

    public void insertNurse(Nurse nurse) {
        String insertTo = "";
        insertTo += " insert into nurse (role_id, name, email, dob, address, mobile, password, username) values(";
        insertTo += String.format("%d, ,'%s', '%s', '%s','%s', '%s', '%s','%s'", nurse.getRoleId(),
                nurse.getName(),
                nurse.getEmail(),
                nurse.getDob(),
                nurse.getAddress(),
                nurse.getMobile(),
                nurse.getPassword(),
                nurse.getUsername());
        insertTo += ")";
        executeStatement(insertTo);

    }

    public void stergeNurseById(int id) {
        String delete = String.format("delete from nurse where id = %d", id);
        executeStatement(delete);


    }

    public void updateDescription(int id, String description) {
        String update = String.format("update nurse set description = '%s'", description);
        update += String.format("where id= %d", id);
        executeStatement(update);
    }

    private ResultSet allDuration() {
        executeStatement("select * from nurse");
        try {
            return statement.getResultSet();

        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }


    public List<Nurse> allNurse() {
        ResultSet set = allDuration();
        List<Nurse> permissions = new ArrayList<>();
        try {
            while (set.next()) {
                permissions.add(new Nurse(set.getInt(1),
                        set.getInt(2),
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
        return permissions;
    }
}
/**/
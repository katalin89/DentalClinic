package repository;

import model.Patient;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryPatient extends Repository{
    public RepositoryPatient(){
        super();
    }

    public  void insertPatient(Patient patient){
        String insertTo="";
        insertTo+=" insert into patient ( role_id,title,module,description) values(";

            insertTo+=String.format("%d, '%s', '%s', '%s','%s', '%s', '%s','%s'",patient.getRoleId(),patient.getName(),patient.getEmail(),patient.getDob(),
                    patient.getAddress(),patient.getMobile(),patient.getPassword(),patient.getUsername());
        insertTo+=")";
        executeStatement(insertTo);

    }

    public  void stergePatientById(int id){
        String delete=String.format("delete from patient where id = %d",id);
        executeStatement(delete);


    }
    public  void updateDescription(int id,String description){
        String  update=String.format("update patient set description = '%s'",description);
        update+=String.format("where id= %d",id);
        executeStatement(update);
    }
    private ResultSet allDuration(){
        executeStatement("select * from patient");
        try {
            return  statement.getResultSet();

        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

    public List<Patient> allPatient(){
        ResultSet set=allDuration();
        List<Patient>patients=new ArrayList<>();
        try{
            while(set.next()){

                    patients.add(new Patient(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),
                            set.getString(6),set.getString(7),set.getString(8),set.getString(9)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  patients;
    }

    public  Patient getPatientById(int id){
        String login=String.format("select * from patient where id=%d",id);
        executeStatement(login);
        try{
            ResultSet result=statement.getResultSet();
            if(result!=null){
                result.next();
                return  new Patient(result.getInt(1),
                                            result.getInt(2),
                                            result.getString(3),
                                            result.getString(4),
                                             result.getString(5),
                                             result.getString(6),
                                             result.getString(7),
                                             result.getString(8),
                                             result.getString(9));
            }
            else return  null;
        }catch ( Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }

    }

    public Patient login(String username,String password){
        String login=String.format("select * from student where username='%s' and password ='%s'",username,password);
        executeStatement(login);
        try{
            ResultSet result=statement.getResultSet();
            if(result!=null){
                result.next();
                return new Patient(result.getInt(1),
                result.getInt(2),
                result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9));



            }else return null;

        }
        catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

}




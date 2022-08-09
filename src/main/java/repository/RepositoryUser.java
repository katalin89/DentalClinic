package repository;

import model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUser extends Repository{
    public RepositoryUser() {
        super();
    }

    public void insertUser(User user) {
        String insertTo = "";
        insertTo += " insert into user( role_id, name, email, dob, address)  values(";
        insertTo +=String.format("%d,'%s','%s','%s','%s'",user.getRoleId(),user.getName(),user.getEmail(),user.getDob(),user.getAddress());
        insertTo+=")";
        executeStatement(insertTo);
    }

    public  void setergeById(int id){
        String delete=String.format("delete from user where id=%d",id);
        executeStatement(delete);
    }

    public void updateEmail(int id,String email){
        String update=String.format("update user set email='%s'",email);
        update+=String.format("where id=%d",id);
        executeStatement(update);
    }

    private ResultSet allStudent(){
        executeStatement("select * from user");
        try{
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }
    public List<User> allStudents(){
        ResultSet set =allStudent();
        List<User>users=new ArrayList<>();
        try{
            while (set.next()){
                users.add(new User(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return users;
    }
}

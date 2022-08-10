package repository;

import model.Role;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryRole extends Repository{
    public RepositoryMedicines(){
        super();
    }

    public  void insertRole(Role role){
        String insertTo="";
        insertTo+=" insert into role ( role_id,title,module,description) values(";
        insertTo+=String.format("%d, '%s', '%s', '%s'",role.getRoleId(),role.getTitle(),role.getModule(),role.getDescription());
        insertTo+=")";
        executeStatement(insertTo);

    }

    public  void stergeRoleById(int id){
        String delete=String.format("delete from role where id = %d",id);
        executeStatement(delete);


    }
    public  void updateDescription(int id,String description){
        String  update=String.format("update role set description = '%s'",description);
        update+=String.format("where id= %d",id);
        executeStatement(update);
    }
    private ResultSet allDuration(){
        executeStatement("select * from role");
        try {
            return  statement.getResultSet();

        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

    public List<Role> allRole(){
        ResultSet set=allDuration();
        List<Role>roles=new ArrayList<>();
        try{
            while(set.next()){
                roles.add(new Role(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  roles;
    }
}

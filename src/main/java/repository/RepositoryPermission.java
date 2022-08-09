package repository;

import model.Permission;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryPermission extends Repository{
    public RepositoryPermission(){
        super();
    }

    public  void insertPermission(Permission permission){
        String insertTo="";
        insertTo+=" insert into permission ( role_id,title,module,description) values(";
        insertTo+=String.format("%d, '%s', '%s', '%s'",permission.getRoleId(),permission.getTitle(),permission.getModule(),permission.getDescription());
        insertTo+=")";
        executeStatement(insertTo);

    }

    public  void stergePermissionById(int id){
        String delete=String.format("delete from permission where id = %d",id);
        executeStatement(delete);


    }
    public  void updateDescription(int id,String description){
        String  update=String.format("update permission set description = '%s'",description);
        update+=String.format("where id= %d",id);
        executeStatement(update);
    }
    private ResultSet allDuration(){
        executeStatement("select * from permission");
        try {
            return  statement.getResultSet();

        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

    public List<Permission> allPermission(){
        ResultSet set=allDuration();
        List<Permission>permissions=new ArrayList<>();
        try{
            while(set.next()){
                permissions.add(new Permission(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  permissions;
    }
}

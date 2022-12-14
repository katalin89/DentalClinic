package repository;

import model.Problems;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProblems extends Repository{
    public RepositoryProblems(){
        super();
    }

    public  void insertProblems(Problems problems){
        String insertTo="";
        insertTo+=" insert into problems (name,type,description) values(";


            insertTo+=String.format(" '%s', '%s', '%s'",problems.getName(),problems.getType(),problems.getDescription());
        insertTo+=")";
        executeStatement(insertTo);
    }

    public  void stergeProblemsById(int id){
        String delete=String.format("delete from problems where id = %d",id);
        executeStatement(delete);
    }
    
    public  void updateDescription(int id,String description){
        String  update=String.format("update problems set description = '%s'",description);
        update+=String.format("where id= %d",id);
        executeStatement(update);
    }
    
    private ResultSet allDuration(){
        executeStatement("select * from problems");
        try {
            return  statement.getResultSet();

        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

    public List<Problems> allProblems(){
        ResultSet set=allDuration();
        List<Problems>problemss=new ArrayList<>();
        try{
            while(set.next()){
                problemss.add(new Problems(set.getInt(1),set.getString(2),set.getString(3),set.getString(4)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  problemss;
    }
}

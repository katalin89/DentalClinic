package repository;

import model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryUserTest {
    @Test
    public void insertUser() {
        RepositoryUser repositoryUser = new RepositoryUser();
        User user = new User(1, 1, "Cezara", "cezara@yahoo.com", "2009-01-09", "Depozitelor nr 5");
        repositoryUser.insertUser(user);
    }

    @Test
    public void deleteById() {
        RepositoryUser repositoryUser = new RepositoryUser();
        repositoryUser.setergeById(7);

    }

    @Test
    public void update() {
        RepositoryUser repositoryUser = new RepositoryUser();
        repositoryUser.updateEmail(1, "test@yahoo.com");

    }

    @Test
    public void allList() {
        RepositoryUser repositoryUser = new RepositoryUser();
        List<User> users=repositoryUser.allStudents();
        for(User u:users){
            System.out.println(u.toString());
        }
    }

}
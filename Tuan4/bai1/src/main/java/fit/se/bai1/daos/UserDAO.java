package fit.se.bai1.daos;

import fit.se.bai1.entities.User;
import java.util.List;

public interface UserDAO {
    void saveUser(User user) throws Exception;
    List<User> getAllUsers() throws Exception;
}

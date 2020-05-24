package springCrud.DAO;

import springCrud.model.User;

import java.util.List;

//public interface UserDAO {
//
//    User getUserByName(String username);
//
//    void save(User user);
//}

public interface UserDAO {
    void addUserDAO(User user);

    void delUserDAO(Long id);

    void updateUserDAO(User userNew);

    List<User> allUserDAO();

    Long getUserIdByName(String name);

    User getUserByName(String name);

    User getUserById(Long id);
}

package springCrud.DAO;

import springCrud.model.User;

import java.util.List;

public interface UserDAO {
    void addUserDAO(User user);

    void delUserDAO(Long id);

    void updateUserDAO(User userNew);

    List<User> allUserDAO();

    Long getUserIdByNameAndPassword(String name, String password);

    User getUserById(Long id);
}

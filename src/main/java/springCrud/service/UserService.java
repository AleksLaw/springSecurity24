package springCrud.service;


import springCrud.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void delUser(Long id);

    void updateUser(User userNew);

    List<User> allUser();

    Long getUserIdByName(String name);

    User getUserById(Long id);
}

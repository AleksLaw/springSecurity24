package springCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springCrud.DAO.UserDAO;
import springCrud.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional
    public void addUser(User user) {
        Long userIdByName = getUserIdByName(user.getName());
        if (userIdByName == null) {
            userDAO.addUserDAO(user);
        }
    }

    @Override
    @Transactional
    public void delUser(Long id) {
        this.userDAO.delUserDAO(id);
    }

    @Override
    @Transactional
    public void updateUser(User userNew) {
        this.userDAO.updateUserDAO(userNew);
    }

    @Override
    @Transactional
    public List<User> allUser() {
        return this.userDAO.allUserDAO();
    }

    @Override
    @Transactional
    public Long getUserIdByName(String name) {
        return this.userDAO.getUserIdByName(name);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return this.userDAO.getUserById(id);
    }
}

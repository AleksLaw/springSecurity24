package springCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springCrud.DAO.RoleDAO;
import springCrud.DAO.UserDAO;
import springCrud.model.Role;
import springCrud.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.findByRoleName("USER"));
        user.setUserRoles(roles);
        userDAO.save(user);
    }

    @Override
    public User findUserByName(String name) {
        return userDAO.findUserByName(name);
    }
//    @Autowired
//    private UserDAO userDAO;
//
//    @Override
//    @Transactional
//    public void addUser(User user) {
//        Long userIdByName = getUserIdByName(user.getName(), user.getPassword());
//        if (userIdByName == null) {
//            userDAO.addUserDAO(user);
//        }
//    }
//
//    @Override
//    @Transactional
//    public void delUser(Long id) {
//        this.userDAO.delUserDAO(id);
//    }
//
//    @Override
//    @Transactional
//    public void updateUser(User userNew) {
//        this.userDAO.updateUserDAO(userNew);
//    }
//
//    @Override
//    @Transactional
//    public List<User> allUser() {
//        return this.userDAO.allUserDAO();
//    }
//
//    @Override
//    @Transactional
//    public Long getUserIdByName(String name, String password) {
//        return this.userDAO.getUserIdByNameAndPassword(name, password);
//    }
//
//    @Override
//    @Transactional
//    public User getUserById(Long id) {
//        return this.userDAO.getUserById(id);
//    }
}

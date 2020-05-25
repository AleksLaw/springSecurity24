package springCrud.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springCrud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUserDAO(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delUserDAO(Long id) {
        Query query = entityManager.createQuery("delete User where id = :param");
        query.setParameter("param", id);
        query.executeUpdate();
    }

    @Override
    public void updateUserDAO(User userNew) {
        entityManager.merge(userNew);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUserDAO() {
        return entityManager.createQuery(" from User  ").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getUserIdByName(String name) {
        Query query = entityManager.createQuery(" from User  " +
                "where name = :nameParam ");
        query.setParameter("nameParam", name);
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        User user = (User) resultList.get(0);
        return user.getId();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    public User getUserByName(String name) {
        Long userIdByName = getUserIdByName(name);
        User user = entityManager.find(User.class, userIdByName);
        return user;
    }

//    @Override
//    public User getUserByName(String username) {
//        return entityManager.find(User.class, username);
//    }
//
//    @Override
//    public void save(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    public User findUserByName(String name) {
//        return entityManager.find(User.class, name);
//    }


}

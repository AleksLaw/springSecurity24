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
        Query query = entityManager.createQuery("update User set name = :nameParam, " +
                "password = :passwordParam " +
             //   "role = :roleParam" +
                " where id = :idParam");
        query.setParameter("idParam", userNew.getId());
        query.setParameter("nameParam", userNew.getName());
        query.setParameter("passwordParam", userNew.getPassword());
       // query.setParameter("roleParam", userNew.getRole());
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUserDAO() {
        return entityManager.createQuery(" from User  ").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getUserIdByNameAndPassword(String name, String password) {
        Query query = entityManager.createQuery(" from User  " +
                "where name = :nameParam " +
                "and password = :passwordParam");
        query.setParameter("nameParam", name);
        query.setParameter("passwordParam", password);
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        User user = (User) resultList.get(0);
        return user.getId();
    }

    @Override
    public User getUserByName(String name) {
            return entityManager.find(User.class, name);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}

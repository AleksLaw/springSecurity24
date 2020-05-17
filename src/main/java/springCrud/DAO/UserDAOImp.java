package springCrud.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springCrud.model.User;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUserDAO(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void delUserDAO(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (id != null) {
            session.delete(user);
        }
    }

    @Override
    public void updateUserDAO(User userNew) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userNew);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUserDAO() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> listUsers = session.createCriteria(User.class).list();
        return listUsers;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getUserIdByName(String name, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> listUser = session.createCriteria(User.class).
                add(Restrictions.eq("name", name)).
                add(Restrictions.eq("password", password)).
                list();
        if (listUser.size() != 0) {
            User userGet = listUser.get(0);
            Long id = userGet.getId();
            return id;
        }
        return null;
    }

    @Override
    public User getUserById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        return user;
    }
}

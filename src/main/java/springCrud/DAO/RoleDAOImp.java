package springCrud.DAO;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springCrud.model.Role;
import springCrud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public class RoleDAOImp implements RoleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Long getRoleIdByName(String name) {
        Query query = entityManager.createQuery(" from Role  " +
                "where role = :nameParam ");
        query.setParameter("nameParam", name);
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        Role role = (Role) resultList.get(0);
        return role.getId();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void addRole(Role name) {
        entityManager.persist(name);
    }
}

package springCrud.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import springCrud.model.Role;

public interface RoleDAO extends JpaRepository {
    //Role findByRoleName(String name);

}

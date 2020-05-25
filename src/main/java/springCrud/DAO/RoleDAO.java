package springCrud.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import springCrud.model.Role;
import springCrud.model.User;

import java.util.Set;

public interface RoleDAO  {
    Long getRoleIdByName(String name);

    Role getRoleById(Long id);
}

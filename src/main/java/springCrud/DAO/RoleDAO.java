package springCrud.DAO;

import springCrud.model.Role;

public interface RoleDAO {
    Long getRoleIdByName(String name);

    Role getRoleById(Long id);

    void addRole(Role name);
}

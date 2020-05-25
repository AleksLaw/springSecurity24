package springCrud.service;

import springCrud.model.Role;

public interface RoleService {

    Long getRoleIdByName(String name);

    Role getRoleById(Long id);

    void addRole(Role name);
}

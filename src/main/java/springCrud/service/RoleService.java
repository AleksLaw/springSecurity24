package springCrud.service;

import org.springframework.stereotype.Service;
import springCrud.model.Role;
import springCrud.model.User;

import java.util.List;

public interface RoleService {

    Long getRoleIdByName(String name);

    Role getRoleById(Long id);
}

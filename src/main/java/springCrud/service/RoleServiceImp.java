package springCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springCrud.DAO.RoleDAO;
import springCrud.model.Role;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public Long getRoleIdByName(String name) {
        return roleDAO.getRoleIdByName(name);
    }

    @Override
    @Transactional
    public Role getRoleById(Long id) {
        return roleDAO.getRoleById(id);
    }
}

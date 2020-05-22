package springCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springCrud.DAO.UserDAO;
import springCrud.model.MyUserPrincipal;
import springCrud.model.Role;
import springCrud.model.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userDAO.getUserByName(username);
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for (Role userRole : user.getUserRoles()) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole()));
            
        }
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getName(),user.getPassword(),grantedAuthoritySet);
    }
}
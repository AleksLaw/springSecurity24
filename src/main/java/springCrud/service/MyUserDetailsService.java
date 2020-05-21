package springCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springCrud.DAO.UserDAO;
import springCrud.model.MyUserPrincipal;
import springCrud.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDAO.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return (UserDetails) new MyUserPrincipal(user);
    }
}
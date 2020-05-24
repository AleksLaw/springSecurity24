package springCrud.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        boolean isUser = false;
        boolean isAdmin = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if ("USER".equals(grantedAuthority.getAuthority())) {
                isUser = true;
                break;
            } else if ("ADMIN".equals(grantedAuthority.getAuthority())){
                isAdmin = true;
                break;
            }
        }

        if (isUser) {
            httpServletResponse.sendRedirect("/userInfoPage");
        } else if (isAdmin) {
            httpServletResponse.sendRedirect("/admin/adminPageInfo");
        } else {
            throw new IllegalStateException();
        }
    }
}
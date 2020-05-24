package springCrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import springCrud.handler.LoginSuccessHandler;
import springCrud.service.MyUserDetailServise;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailServise myUserDetailsService;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
        //    auth.inMemoryAuthentication().withUser("USER").password("USER").roles("USER");
        //   auth.inMemoryAuthentication().withUser("ADMIN").password("ADMIN").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/login")
                //указываем логику обработки при логине
                .successHandler(new LoginSuccessHandler())
                // указываем action с формы логина
                .loginProcessingUrl("/login")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                // даем доступ к форме логина всем
                .permitAll();

        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                // указываем URL логаута
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/login?logout")
                //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
                .and().csrf().disable();

//        http
//                // делаем страницу регистрации недоступной для авторизированных пользователей
//                .authorizeRequests()
//                //страницы аутентификаци доступна всем
//                .antMatchers("/login").anonymous()
//                // защищенные URL
//                .antMatchers("/admin").access("hasAnyAuthority()").anyRequest().authenticated();
//                //.antMatchers("/hello").access("hasAnyRole('USER')").anyRequest().authenticated();
//        http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/registrationPage", "/login").permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user/**").hasAnyRole("USER")
//                .anyRequest().authenticated()
//        ;
        http
                .authorizeRequests()
                .antMatchers("/registrationPage", "/login").permitAll()
                //.antMatchers("/index").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER").anyRequest().authenticated();


//        http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/rest/**").permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/secure/**").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}

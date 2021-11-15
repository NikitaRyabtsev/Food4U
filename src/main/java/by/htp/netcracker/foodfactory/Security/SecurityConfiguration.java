package by.htp.netcracker.foodfactory.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    UserPrincipalDetailService userPrincipalDetailService;

    public SecurityConfiguration(UserPrincipalDetailService userPrincipalDetailService) {
        this.userPrincipalDetailService = userPrincipalDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userPrincipalDetailService);
//                        .inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder().encode("user123"))
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder().encode("admin123"))
//                .authorities("API", "ROLE_ADMIN");
//                .roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/main").permitAll()
                .antMatchers("/menu/dish").permitAll()
                .antMatchers("/order/newOrder").permitAll()
                .antMatchers("/order/addOrder").authenticated()
                .antMatchers("/order/orders").authenticated()
                .antMatchers("/order/orders").hasAnyRole("ADMIN","USER")
                .antMatchers("/ingredients/**").authenticated()
                .antMatchers("/ingredients/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").authenticated()
                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin()
//                .loginPage("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/main");

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

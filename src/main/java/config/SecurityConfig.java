package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // enable in memory based authentication with a user named
                // "user" and "admin"
                .inMemoryAuthentication()
                .withUser("username").password("123456").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().
                defaultSuccessUrl("/reservaties/all").
                loginPage("/login");

        http.authorizeRequests()
                .antMatchers("/reservaties/*", "/filter*").hasRole("USER").
                and().csrf();
    }
}

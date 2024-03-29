package config;

import auth.HoGentAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HoGentAuthenticationProvider authProvider;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.authenticationProvider(authProvider);
        
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().
                defaultSuccessUrl("/filter").
                loginPage("/login");

        http.authorizeRequests()
                .antMatchers("/reservaties/*", "/filter*").hasRole("USER").
                and().csrf();
    }
}

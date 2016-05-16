package config;

import domain.ReservatieLijn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import service.JpaReservatieDao;
import service.JpaReservatieLijnDao;
import service.ReservatieDao;
import service.ReservatieLijnDao;

@Configuration
@EnableWebMvc
@ComponentScan("controller")
@Import({PersistenceJPAConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ReservatieDao reservatieDao() {
        return new JpaReservatieDao();
    }
    
    @Bean
    public ReservatieLijnDao reservatieLijnDao() {
        return new JpaReservatieLijnDao();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("resources/img/");
    }

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}

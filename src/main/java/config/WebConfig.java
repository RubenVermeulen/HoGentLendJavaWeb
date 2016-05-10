package config;
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
import service.ReservatieDao;



@Configuration
@EnableWebMvc
@ComponentScan("controller")
//TODO
@Import({PersistenceJPAConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {
/*
    @Bean
    public BankCustomerDao bankCustomerDao()
    {
        return new JpaBankCustomerDao();
    }
*/
    
    @Bean
    public ReservatieDao reservatieDao(){
    return new JpaReservatieDao();
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

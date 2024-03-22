package lk.ijse.springstudentmanagementmvc.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "lk.ijse.springstudentmanagementmvc")
@Configuration
@EnableWebMvc
@MultipartConfig
public class WebAppConfig {

}

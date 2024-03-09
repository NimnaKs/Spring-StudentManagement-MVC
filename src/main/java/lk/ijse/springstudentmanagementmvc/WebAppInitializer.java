package lk.ijse.springstudentmanagementmvc;

import lk.ijse.springstudentmanagementmvc.config.WebAppConfig;
import lk.ijse.springstudentmanagementmvc.config.WebAppRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }//Register root config class

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }//Register servlet config class

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }//Front - Controller Design Pattern
}

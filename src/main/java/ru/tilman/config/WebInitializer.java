package ru.tilman.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.tilman.config.security.SecurityConfig;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        //возвращает корневую конфигурации приложения (сервисы и дао-уровень)
        return new Class<?>[]{AppConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        //возвращает конфигураци сервлета(веб-уровень, который включает в себя контроллеры)
        return new Class<?>[]{DispatcherServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {

        //возвращает путь, на который мэппится данный сервлет
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {

        //создание фильтра кодировки, который позволит работать с русскими символами
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        //создание фильтра, который добавляет поддержку  HTTP методов(например,таких как PUT)
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter, httpMethodFilter};

    }

    // TODO: 12.07.18 добавлено для реализации jsf. Неудается совмместить с SecurityWebApplicationInitializer
//    @Override
//    public void onStartup(ServletContext sc) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        sc.addListener(new ContextLoaderListener(context));
//    }

}

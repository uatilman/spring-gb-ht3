package ru.tilman;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tilman.service.ApplicationService;

public class Application {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ApplicationService applicationService = context.getBean(ApplicationService.class);

        applicationService.printAllEntity();
        applicationService.removeFirstAd();


    }
}

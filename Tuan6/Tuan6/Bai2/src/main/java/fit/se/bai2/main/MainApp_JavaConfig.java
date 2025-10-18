package fit.se.bai2.main;

import fit.se.bai2.confg.AppConfig;
import fit.se.bai2.entities.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp_JavaConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee emp = context.getBean(Employee.class);
        System.out.println(emp);
    }
}

package fit.se.bai2.main;

import fit.se.bai2.entities.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "fit.se.bai2.entities")
public class MainApp_Annotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainApp_Annotation.class);

        Employee emp = context.getBean(Employee.class);
        System.out.println(emp);
    }
}

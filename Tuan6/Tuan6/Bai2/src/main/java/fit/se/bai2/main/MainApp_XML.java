package fit.se.bai2.main;

import fit.se.bai2.entities.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp_XML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Employee emp1 = (Employee) context.getBean("employee1");
        System.out.println(emp1);

        System.out.println("--------");

        Employee emp2 = (Employee) context.getBean("employee2");
        System.out.println(emp2);
    }
}

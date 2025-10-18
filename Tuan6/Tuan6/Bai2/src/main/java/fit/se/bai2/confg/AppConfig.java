package fit.se.bai2.confg;

import fit.se.bai2.entities.Address;
import fit.se.bai2.entities.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fit.se.bai2")
public class AppConfig {
    @Bean
    public Address javaBasedAddress(){
        Address address = new Address();
        address.setCity("Tokyo");
        address.setState("Tokyo");
        address.setCountry("Japan");
        return address;
    }

    @Bean
    public Employee javaBasedEmployee(){
        Employee employee = new Employee();
        employee.setId(103);
        employee.setName("Charlie Brown");
        employee.setAddress(javaBasedAddress()); // Tiêm phụ thuộc Address
        return employee;
    }

}

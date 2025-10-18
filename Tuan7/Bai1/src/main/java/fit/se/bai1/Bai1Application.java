package fit.se.bai1;

import fit.se.bai1.dao.EmployeeDAO;
import fit.se.bai1.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bai1Application {

    public static void main(String[] args) {

        SpringApplication.run(Bai1Application.class, args);
    }
    // @Bean và CommandLineRunner để chạy code test DAO
    // Spring sẽ tự động tiêm EmployeeDAO (tức EmployeeDAOImpl) vào đây
    @Bean
    public CommandLineRunner runTest(EmployeeDAO dao) {
        return args -> {
            System.out.println("\n=================================================");
            System.out.println("        STARTING EMPLOYEE DAO TEST (JDBC)        ");
            System.out.println("=================================================");

            // --- 1. SAVE (Thêm mới) ---
            System.out.println("--- 1. SAVE ---");
            Employee e1 = new Employee("Le Van C", "Manager");
            Employee e2 = new Employee("Pham Thi D", "Intern");
            dao.save(e1);
            dao.save(e2);

            // Lấy ID của nhân viên đầu tiên để kiểm tra Update/Delete
            int testId = dao.getAll().stream()
                    .mapToInt(Employee::getId)
                    .min()
                    .orElse(0);


            // --- 2. GET ALL ---
            System.out.println("\n--- 2. GET ALL ---");
            dao.getAll().forEach(System.out::println);


            if (testId > 0) {
                // --- 3. GET BY ID ---
                System.out.println("\n--- 3. GET BY ID (" + testId + ") ---");
                Employee retrieved = dao.getById(testId);
                System.out.println("Found: " + retrieved);

                // --- 4. UPDATE ---
                System.out.println("\n--- 4. UPDATE ---");
                retrieved.setName("Le Van C (Senior)");
                retrieved.setRole("Senior Manager");
                dao.update(retrieved);
                System.out.println("Updated data: " + dao.getById(testId));

                // --- 5. DELETE ---
                System.out.println("\n--- 5. DELETE ---");
                dao.delete(testId);

                // --- 6. CHECK ALL AFTER DELETE ---
                System.out.println("\n--- 6. ALL EMPLOYEES AFTER DELETE ---");
                dao.getAll().forEach(System.out::println);
            } else {
                System.out.println("\n⚠️ Không có ID để kiểm tra Update/Delete.");
            }

            System.out.println("\n=================================================");
            System.out.println("        DAO TEST COMPLETE                        ");
            System.out.println("=================================================");
        };
    }

}

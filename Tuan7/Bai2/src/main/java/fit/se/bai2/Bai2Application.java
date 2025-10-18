package fit.se.bai2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bai2Application {

    public static void main(String[] args) {

        SpringApplication.run(Bai2Application.class, args);
    }
    // 💡 Spring tự động tiêm EmployeeRepository (JpaRepository)
    @Bean
    public CommandLineRunner runTest(EmployeeRepository repository) {
        return args -> {
            System.out.println("\n=================================================");
            System.out.println("        STARTING EMPLOYEE DAO TEST (JPA)         ");
            System.out.println("=================================================");

            // Xóa dữ liệu cũ để test sạch
            repository.deleteAll();
            System.out.println("--- Database cleared ---");

            // --- 1. SAVE (Thêm mới) ---
            System.out.println("--- 1. SAVE ---");
            Employee e1 = new Employee("Nguyen Van A", "Developer");
            Employee e2 = new Employee("Tran Thi B", "Intern");
            Employee e3 = new Employee("Vu Van C", "Intern");
            Employee e4 = new Employee("Lan Anh", "Intern");
            repository.save(e1); // CREATE
            repository.save(e2);
            repository.save(e3);
            repository.save(e4);

            // Lấy ID của nhân viên A để test Update/Delete
            Integer testId = repository.findAll().stream()
                    .filter(e -> e.getName().equals("Nguyen Van A"))
                    .mapToInt(Employee::getId)
                    .findFirst()
                    .orElse(0);

            // --- 2. GET ALL ---
            System.out.println("\n--- 2. GET ALL ---");
            repository.findAll().forEach(System.out::println);

            if (testId > 0) {
                // --- 3. GET BY ID ---
                System.out.println("\n--- 3. GET BY ID (" + testId + ") ---");
                // findById trả về Optional, dùng .get() hoặc .orElse()
                Employee retrieved = repository.findById(testId).orElse(null);
                System.out.println("Found: " + retrieved);

                // --- 4. UPDATE ---
                System.out.println("\n--- 4. UPDATE ---");
                if (retrieved != null) {
                    retrieved.setRole("Senior Developer");
                    repository.save(retrieved); // UPDATE: Dùng save() khi Entity có ID
                    System.out.println("Updated: " + repository.findById(testId).get());
                }

                // --- 5. Custom Query (Test phương thức tự định nghĩa) ---
                System.out.println("\n--- 5. FIND BY ROLE (Intern) ---");
                repository.findByRole("Intern").forEach(System.out::println);

                // --- 6. DELETE ---
                System.out.println("\n--- 6. DELETE ID " + testId + " ---");
                repository.deleteById(testId);

                // --- 7. CHECK ALL AFTER DELETE ---
                System.out.println("\n--- 7. ALL EMPLOYEES AFTER DELETE ---");
                repository.findAll().forEach(System.out::println);
            }

            System.out.println("\n=================================================");
            System.out.println("        JPA TEST COMPLETE                        ");
            System.out.println("=================================================");
        };
    }
}

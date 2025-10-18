package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Employee> employees;
        if (keyword != null && !keyword.isEmpty()) {
            employees = employeeService.search(keyword);
            model.addAttribute("keyword", keyword);
        } else {
            employees = employeeService.getList();
        }
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @GetMapping("/show-form")
    public ModelAndView showForm(ModelAndView modelAndView) {
        Employee employee = new Employee();
        modelAndView.setViewName("employee_register");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return "employee_register";
        }

        employeeService.save(employee);

        return "redirect:/";
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam("employeeId") int id, ModelAndView modelAndView) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            modelAndView.addObject("error", "User Id khong ton tai");
            modelAndView.setViewName("error");
        }
        else {
            modelAndView.addObject("employee", employee);
            modelAndView.setViewName("employee_register");
        }

        return modelAndView;
    }

    // Thêm GetMapping cho /delete
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }
}

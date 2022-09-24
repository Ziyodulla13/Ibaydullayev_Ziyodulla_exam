package uz.pdp.ibaydullayev_ziyodulla_exam.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.ibaydullayev_ziyodulla_exam.department.DeapartmentDao;
import uz.pdp.ibaydullayev_ziyodulla_exam.employee.Employee;
import uz.pdp.ibaydullayev_ziyodulla_exam.employee.EmployeeDao;
import uz.pdp.ibaydullayev_ziyodulla_exam.position.PositionDao;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeDao employeeDao;
    private final PositionDao positionDao;
    private final DeapartmentDao deapartmentDao;

    @GetMapping
    public String getEmployee(Model model) {
        model.addAttribute("employee", employeeDao.getAllEmployee());
        return "/view-employees";
    }

    @GetMapping("/get-form")
    public String addForm(Model model) {
        model.addAttribute("position",positionDao.getAllPosition());
        model.addAttribute("department",deapartmentDao.getAllDepartment());
        return "add-employee-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model){
        model.addAttribute("employee",employeeDao.getEmployeeById(id));
        model.addAttribute("position",positionDao.getAllPosition());
        model.addAttribute("department",deapartmentDao.getAllDepartment());
        return "edit-employee-form";
    }

    @PostMapping
    public String addEmployee(Employee employee){
        employeeDao.addNewEmployee(employee);
        return "redirect:/employee";
    }

    @PostMapping("/edit")
    public String editEmployee(Employee employee){
        employeeDao.editEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/employee";
    }
}

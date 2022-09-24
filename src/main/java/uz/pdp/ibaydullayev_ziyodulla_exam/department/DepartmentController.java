package uz.pdp.ibaydullayev_ziyodulla_exam.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DeapartmentDao deapartmentDao;

    @GetMapping
    public String getDepartment(Model model) {
        model.addAttribute("department", deapartmentDao.getAllDepartment());
        return "/view-departments";
    }

    @GetMapping("/get-form")
    public String addForm() {
        return "add-department-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model){
        model.addAttribute("department",deapartmentDao.getDepartmentById(id));
        return "edit-department-form";
    }

    @PostMapping
    public String addDepartment(Department department){
        deapartmentDao.addNewDepartment(department);
        return "redirect:/department";
    }

    @PostMapping("/edit")
    public String editDepartment(Department department){
        deapartmentDao.editDepartment(department);
        return "redirect:/department";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Integer id){
        deapartmentDao.deleteDepartment(id);
        return "redirect:/department";
    }
}

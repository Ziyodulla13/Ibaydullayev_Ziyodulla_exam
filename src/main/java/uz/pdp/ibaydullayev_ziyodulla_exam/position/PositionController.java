package uz.pdp.ibaydullayev_ziyodulla_exam.position;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/position")
public class PositionController {
    private final PositionDao positionDao;

    @GetMapping
    public String getPosition(Model model) {
        model.addAttribute("position", positionDao.getAllPosition());
        return "/view-positions";
    }

    @GetMapping("/get-form")
    public String addForm() {
        return "add-position-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model){
        model.addAttribute("position",positionDao.getPositionById(id));
        return "edit-position-form";
    }

    @PostMapping
    public String addPosition(Position position){
        positionDao.addNewPosition(position);
        return "redirect:/position";
    }

    @PostMapping("/edit")
    public String editPosition(Position position){
        positionDao.editPosition(position);
        return "redirect:/position";
    }

    @GetMapping("/delete/{id}")
    public String deletePosition(@PathVariable Integer id){
        positionDao.deletePosition(id);
        return "redirect:/position";
    }
}

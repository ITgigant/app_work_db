package ru.chernyshovms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.chernyshovms.dao.BodyTableDAO;
import ru.chernyshovms.models.BodyTable;

@Controller
@RequestMapping("/table")
public class BodyTableController {
    private final BodyTableDAO bodyTableDAO;
    @Autowired
    public BodyTableController(BodyTableDAO bodyTableDAO) {
        this.bodyTableDAO = bodyTableDAO;
    }

    @GetMapping("/page/{pageNumber}")
    public String indexPage( Model model, @PathVariable(name = "pageNumber") int pageNumber) {
        Pageable firstPage =
                PageRequest.of(pageNumber, 10);
        Page<BodyTable> page = bodyTableDAO.index(firstPage);
        model.addAttribute("bodyTables", page);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("pageNumber", pageNumber);
        return "/index";
    }

    @GetMapping("/search/page/{pageNumber}")
    public String searchByPage(String keyword, @PathVariable(name = "pageNumber")int pageNumber, Model model ) {
        Pageable firstPage =
                PageRequest.of(pageNumber, 10);
        Page<BodyTable> result = bodyTableDAO.search(keyword, firstPage);
        model.addAttribute("bodyTables", result);
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("keyword", keyword);
        return  "/search";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("bodyTables", bodyTableDAO.show(id));
        return "/show";
    }

    @GetMapping("/new")
    public String newBodyTable(@ModelAttribute("bodyTables") BodyTable bodyTable) {
        return "/new";
    }

//    @PostMapping()
//    public String create(@ModelAttribute("bodyTables") BodyTable bodyTable, BindingResult bindingResult){
//        if (bindingResult.hasErrors())
//            return "/new";
//
//        bodyTableDAO.save(bodyTable);
//        return "redirect:/table";
//    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("bodyTables", bodyTableDAO.show(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("bodyTables") BodyTable bodyTable, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/new";

        bodyTableDAO.update(id, bodyTable);
        return "redirect:/table/page/0";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bodyTableDAO.delete(id);
        return "redirect:/table/page/0";
    }


}
package com.example.demo.controller;

import com.example.demo.entity.Computer;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(value = "/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/create")
    public String addComputer(Model model) {
        model.addAttribute("computer", computerService.findAll());
        return "computer/create";
    }

    @PostMapping("/save")
    public String saveComputer(@Validated @ModelAttribute Computer computer, BindingResult bindingResult, Model model,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("computer", computerService.findAll());
        } else {
            computerService.save(computer);
            redirectAttributes.addFlashAttribute("message", "Thêm mới máy tính " + computer.getComputerId() + " thành công.");
            model.addAttribute("computer", computer);
        }
        return "redirect:/computer";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable String id, Model model) {
        model.addAttribute("computer", computerService.findAll());
        model.addAttribute("customer", computerService.findById(id));
        return "computer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Validated @ModelAttribute Computer computer, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", computerService.findAll());
            return "computer/create";
        } else {
            computerService.save(computer);
            redirect.addFlashAttribute("message", "Cập nhật máy tính " + computer.getComputerId() + " thành công.!");
            return "computer/list";
        }
    }
}


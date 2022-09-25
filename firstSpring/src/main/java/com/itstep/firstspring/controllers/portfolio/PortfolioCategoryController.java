package com.itstep.firstspring.controllers.portfolio;

import com.itstep.firstspring.entities.portfolio.PortfolioCategory;
import com.itstep.firstspring.repos.portfolio.PortfolioCategoryRepository;
import com.itstep.firstspring.repos.portfolio.PortfolioItemRepository;
import com.itstep.firstspring.repos.portfolio.PortfolioTagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PortfolioCategoryController {
    private final PortfolioItemRepository itemRepository;
    private final PortfolioCategoryRepository categoryRepository;
    private final PortfolioTagRepository tagRepository;

    public PortfolioCategoryController(
            PortfolioItemRepository itemRepository,
            PortfolioCategoryRepository categoryRepository,
            PortfolioTagRepository tagRepository
    ) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    @GetMapping("/category")
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "portfolio/category";
    }

    @GetMapping("/category/create")
    public String create(Model model){
        return "/portfolio/categoryForm-create";
    }

    @PostMapping("/category/store")
    public RedirectView store(
            PortfolioCategory category
    ){
        categoryRepository.save(category);
        return new RedirectView("/category");
    }

    @GetMapping("/category/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name="id") Long id
    ){
        PortfolioCategory c = categoryRepository.findById(id).get();
        model.addAttribute("category", c);
        return "/portfolio/categoryForm-update";
    }

    @GetMapping("/category/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") Long id
    ){
        categoryRepository.deleteById(id);
        return new RedirectView("/category");
    }
}

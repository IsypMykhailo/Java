package com.itstep.firstspring.controllers.portfolio;

import com.itstep.firstspring.entities.portfolio.PortfolioTag;
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
public class PortfolioTagController {
    private final PortfolioItemRepository itemRepository;
    private final PortfolioCategoryRepository categoryRepository;
    private final PortfolioTagRepository tagRepository;

    public PortfolioTagController(
            PortfolioItemRepository itemRepository,
            PortfolioCategoryRepository categoryRepository,
            PortfolioTagRepository tagRepository
    ) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    @GetMapping("/tag")
    public String index(Model model){
        model.addAttribute("tags", tagRepository.findAll());
        return "portfolio/tag";
    }

    @GetMapping("/tag/create")
    public String create(Model model){
        return "/portfolio/tagForm-create";
    }

    @PostMapping("/tag/store")
    public RedirectView store(
            PortfolioTag tag
    ){
        tagRepository.save(tag);
        return new RedirectView("/tag");
    }

    @GetMapping("/tag/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name="id") Long id
    ){
        PortfolioTag t = tagRepository.findById(id).get();
        model.addAttribute("tag", t);
        return "/portfolio/tagForm-update";
    }

    @GetMapping("/tag/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") Long id
    ){
        tagRepository.deleteById(id);
        return new RedirectView("/tag");
    }
}

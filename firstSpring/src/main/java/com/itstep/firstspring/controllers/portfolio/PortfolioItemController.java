package com.itstep.firstspring.controllers.portfolio;

import com.itstep.firstspring.entities.portfolio.PortfolioItem;
import com.itstep.firstspring.exceptions.storage.StorageFileNotFoundException;
import com.itstep.firstspring.repos.portfolio.PortfolioCategoryRepository;
import com.itstep.firstspring.repos.portfolio.PortfolioItemRepository;
import com.itstep.firstspring.repos.portfolio.PortfolioTagRepository;
import com.itstep.firstspring.services.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PortfolioItemController {

    private final StorageService storageService;
    private final PortfolioItemRepository itemRepository;
    private final PortfolioCategoryRepository categoryRepository;
    private final PortfolioTagRepository tagRepository;

    @Autowired
    public PortfolioItemController(
            StorageService storageService,
            PortfolioItemRepository itemRepository,
            PortfolioCategoryRepository categoryRepository,
            PortfolioTagRepository tagRepository
    ) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
        this.storageService = storageService;
    }


    /**
     * Вывод на экран всех портфолио
     * @param model
     * @return
     */
    @GetMapping("/portfolio")
    public String index(Model model){
        model.addAttribute("portfolios", itemRepository.findAll());
        return "portfolio/index";
    }

    /**
     * Вывод формы для создания новой сущности
     * @return
     */

    @GetMapping("/portfolio/create")
    public String create(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "/portfolio/form-create";

    }


    /**
     * Сохранение сущности
     * @param portfolio
     */
    @PostMapping("/portfolio/store")
    public RedirectView store(
            @Param("category_id") long category_id,
            @Param("tags_id") long[] tags_id,
            @RequestParam("main_img") MultipartFile mainImg,
            PortfolioItem portfolio
    ){
        storageService.store(mainImg);
        portfolio.setCategory(categoryRepository.findById(category_id).get());
        portfolio.setMainImg(StringUtils.cleanPath(mainImg.getOriginalFilename()));
        itemRepository.save(portfolio);

        // ArrayList<PortfolioTag> tags = new ArrayList<>();
        if(tags_id != null) {
            for (int i = 0; i < tags_id.length; i++) {

                portfolio.getTags().add( tagRepository.findById(tags_id[i]).get() );
                //   tags.add(tagRepository.findById(tags_id[i]).get());
            }
        }
        //itemRepository.save(portfolio);
        return new RedirectView("/portfolio", true);
    }

    @GetMapping("/portfolio/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name="id") Long id
    ){
        PortfolioItem p = itemRepository.findById(id).get();
        model.addAttribute("portfolio", p);
        return "/portfolio/form-update";
    }

    @GetMapping("/portfolio/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") Long id
    ) {
        itemRepository.deleteById(id);
        return new RedirectView("/portfolio");
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}

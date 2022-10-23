package com.mykhailo.timezone.controllers;

import com.mykhailo.timezone.entities.Category;
import com.mykhailo.timezone.entities.Product;
import com.mykhailo.timezone.repos.CategoryRepository;
import com.mykhailo.timezone.repos.ProductRepository;
import com.mykhailo.timezone.services.UserService;
import com.mykhailo.timezone.services.storage.StorageService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AdminController {
    private final UserService userService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final StorageService storageService;

    public AdminController(UserService userService, ProductRepository productRepository, CategoryRepository categoryRepository, StorageService storageService) {
        this.userService = userService;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.storageService = storageService;
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin/deleteUser")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
    @PostMapping("/admin/deleteCategory")
    public String  deleteCategory(@RequestParam(required = true, defaultValue = "" ) Long categoryId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            categoryRepository.deleteById(categoryId);
        }
        return "redirect:/admin";
    }
    @PostMapping("/admin/deleteProduct")
    public String  deleteProduct(@RequestParam(required = true, defaultValue = "" ) Long productId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            productRepository.deleteById(productId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }

    @GetMapping("/admin/products")
    public String adminProducts(Model model){
        model.addAttribute("allProducts", productRepository.findAll());
        return "admin/products";
    }

    @GetMapping("/admin/categories")
    public String adminCategories(Model model){
        model.addAttribute("allCategories", categoryRepository.findAll());
        return "admin/categories";
    }

    @GetMapping("/admin/users")
    public String adminUsers(Model model){
        model.addAttribute("allUsers", userService.allUsers());
        return "admin/users";
    }

    @GetMapping("/admin/addProduct")
    public String addProductGet(Model model){
        model.addAttribute("categories", categoryRepository.findAll());

        return "admin/addProduct";
    }

    @PostMapping("/admin/addProduct")
    public String addProductPost(
            @Param("title") String title,
            @Param("price") Float price,
            @Param("category_id") long category_id,
            @RequestPart("file") MultipartFile image,
            Product product
    ){
        storageService.store(image, "Default");
        product.setCategory(categoryRepository.findById(category_id).get());
        product.setImage("/store/default/"+StringUtils.cleanPath(image.getOriginalFilename()));
        product.setTitle(title);
        product.setPrice(price);
        productRepository.save(product);
        return "redirect:/admin";
    }

    @GetMapping("/admin/addCategory")
    public String addCategory(){
        return "admin/addCategory";
    }
    @PostMapping("/admin/addCategory")
    public String addCategoryPost(
            @RequestParam("name") String name,
            Category category){
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:/admin";
    }
}

package com.mykhailo.timezone.controllers;

import com.mykhailo.timezone.entities.Cart;
import com.mykhailo.timezone.entities.Product;
import com.mykhailo.timezone.entities.User;
import com.mykhailo.timezone.repos.CartRepository;
import com.mykhailo.timezone.repos.CategoryRepository;
import com.mykhailo.timezone.repos.ProductRepository;
import com.mykhailo.timezone.repos.UserRepository;
import com.mykhailo.timezone.services.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class PageController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CategoryRepository categoryRepository;

    public PageController(UserRepository userRepository, UserService userService, ProductRepository productRepository, CartRepository cartRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "pages/index";
    }
    @GetMapping("/shop")
    public String shop(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        model.addAttribute("products", productRepository.findAll());
        return "pages/shop";
    }
    @GetMapping("/about")
    public String about(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "pages/about";
    }
    @GetMapping("/product-details")
    public String product_details(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "pages/product_details";
    }
    @GetMapping("/blog")
    public String blog(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "pages/blog";
    }
    @GetMapping("/blog-details")
    public String blog_details(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "pages/blog-details";
    }
    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }
    /*@GetMapping("/registration")
    public String registration() {
        return "pages/registration";
    }*/
    @GetMapping("/cart")
    public String cart(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);



            /*ArrayList<Product> p = new ArrayList<>();
            for(Cart c : userRepository.findByUsername(username).getCarts()){
                p.add(productRepository.findById(c.getProduct().getId()).get());
            }

            Product[] products = new Product[p.size()];
            for(int i = 0; i < p.size(); i++){
                products[i] = productRepository.findById(p.get(i).getId()).get();
            }
            List<Product> productList = List.of(products);
            //Product[] products = (Product[]) p.toArray();
            model.addAttribute("products", productList);*/
            model.addAttribute("cart", cartRepository.findById(userRepository.findByUsername(username).getCart().getId()).get());
            model.addAttribute("products",cartRepository.findById(userRepository.findByUsername(username).getCart().getId()).get().getProducts());
        }
        return "pages/cart";
    }
    @GetMapping("/elements")
    public String elements() {
        return "pages/elements";
    }
    @GetMapping("/confirmation")
    public String confirmation(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "pages/confirmation";
    }
    @GetMapping("/checkout")
    public String checkout(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "pages/checkout";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user.getUsername();
            model.addAttribute("username", username);
        }
        return "pages/contact";
    }
    @GetMapping("/profile/{username}")
    public String profile(Model model,
                          @PathVariable(name="username") String username) {
        User u = userRepository.findByUsername(username);
        model.addAttribute("user", u);
        return "pages/profile";
    }
    @PostMapping("/changeProfile/{username}")
    public String changeProfile(
            @Param("name") String name,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("address") String address,
            @Param("city") String city,
            @Param("country") String country,
            @PathVariable(name="username") String username,
            User user
    ){
        user = userRepository.findByUsername(username);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setCity(city);
        user.setCountry(country);
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/{username}/addToCart")
    public String addToCart(@PathVariable("username") String username,
                            @RequestParam("product_id") long product_id){
        Product p = productRepository.findById(product_id).get();
        Cart cart = cartRepository.findById(userRepository.findByUsername(username).getCart().getId()).get();
        cart.getProducts().add(p);
        cart.setQuantity(cart.getQuantity()+1);
        cart.setRate(cart.getRate()+p.getPrice());
        cartRepository.save(cart);
        return "redirect:/shop";
    }

    @PostMapping("/{username}/buy")
    public String buy(@PathVariable("username") String username, Cart cart){
        cart = cartRepository.findById(userRepository.findByUsername(username).getCart().getId()).get();
        cartRepository.delete(cart);
        Cart newCart = new Cart();
        newCart.setUser(userRepository.findByUsername(username));
        newCart.setQuantity(0);
        newCart.setRate(0);
        cartRepository.save(newCart);
        return "redirect:/";
    }
}

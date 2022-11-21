package com.maramax.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value={"/products", "/products/pos-materials"})
    public String productsPosMaterials(Model model) {
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");
        return "products/pos-materials";
    }

    @GetMapping("/products/cashed")
    public String productsCashed(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");
        return "products/cashed";
    }

    @GetMapping("/products/cartboard")
    public String productsCartboard(Model model) {
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");
        return "products/cartboard";
    }

    @GetMapping("/products/corrugated-cartboard")
    public String productsCorrugatedCartboard(Model model) {
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");
        return "products/corrugated-cartboard";
    }
}

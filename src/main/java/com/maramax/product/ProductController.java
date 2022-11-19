package com.maramax.product;

import com.maramax.callback.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value={"/products", "/products/pos-materials"})
    public String productsPosMaterials(Model model) {
        model.addAttribute("products", this.productRepository.findByType("pos-materials"));
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.min.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/pos-materials";
    }

    @GetMapping("/products/cashed")
    public String productsCashed(Model model) {
        model.addAttribute("products", this.productRepository.findByType("cashed"));
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.min.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/cashed";
    }

    @GetMapping("/products/cartboard")
    public String productsCartboard(Model model) {
        model.addAttribute("products", this.productRepository.findByType("cartboard"));
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.min.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/cartboard";
    }

    @GetMapping("/products/corrugated")
    public String productsCorrugatedCartboard(Model model) {
        model.addAttribute("products", this.productRepository.findByType("corrugated"));
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.min.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/corrugated";
    }
}

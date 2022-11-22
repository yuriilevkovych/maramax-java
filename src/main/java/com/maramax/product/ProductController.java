package com.maramax.product;

import com.maramax.callback.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.Year;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("callback", new Callback());
    }

    @GetMapping(value={"/products", "/products/pos-materials"})
    public String productsPosMaterials(Model model) {
        model.addAttribute("products", this.productRepository.findByType("pos-materials"));
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/pos-materials";
    }

    @GetMapping("/products/cashed")
    public String productsCashed(Model model) {
        model.addAttribute("products", this.productRepository.findByType("cashed"));
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/cashed";
    }

    @GetMapping("/products/cartboard")
    public String productsCartboard(Model model) {
        model.addAttribute("products", this.productRepository.findByType("cartboard"));
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/cartboard";
    }

    @GetMapping("/products/corrugated")
    public String productsCorrugatedCartboard(Model model) {
        model.addAttribute("products", this.productRepository.findByType("corrugated"));
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/corrugated";
    }
}

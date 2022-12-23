package com.maramax.product;

import com.maramax.callback.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Year;

@Controller
public class ProductController {
    private static final String DEFAULT_TYPE = "pos_materials";

    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("callback", new Callback());
    }

    @GetMapping(value={"/products", "/products/{type}"})
    public String productsPosMaterials(@PathVariable(value = "type") String type, Model model) {
        if (type == null) {
            type = DEFAULT_TYPE;
        }

        model.addAttribute("products", this.productRepository.findByTypeOrderById(type.toUpperCase()));
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.css");
        model.addAttribute("script", "/js/production.min.js");

        return "products/" + type;
    }
}

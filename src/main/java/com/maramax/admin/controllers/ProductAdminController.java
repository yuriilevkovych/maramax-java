package com.maramax.admin.controllers;

import com.maramax.admin.service.ProductAdminService;
import com.maramax.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {
    @Autowired
    private ProductAdminService productAdminService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", this.productAdminService.getProducts());

        return "admin/product/index";
    }

    @GetMapping("create")
    public String create(Product product, Model model) {
        model.addAttribute("types", Product.Types.values());

        return "admin/product/create";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("number") Integer number,
            @RequestParam("type") String type,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) throws IOException {

        Product product = new Product(null, number, type, description, "");
        product = productAdminService.create(product, file);

        return "redirect:/admin/product";
    }

    @GetMapping("{id}")
    public String getUpdate(@PathVariable(value = "id") Long id, Model model) {
        Product product = productAdminService.findById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("types", Product.Types.values());

        return "admin/product/update";
    }

    @PostMapping("{id}")
    public String postUpdate(@PathVariable(value = "id") Long id,
                             @Valid Product product,
                             @RequestParam("file") MultipartFile file,
                             BindingResult result,
                             Model model) throws IOException {
        if (result.hasErrors()) {
            product.setId(id);

            return "admin/product/edit";
        }

        this.productAdminService.update(product, file);

        return "redirect:/admin/product";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Product product = productAdminService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        //Todo check this and if file have not deleted, show error
        productAdminService.delete(product);

        return "redirect:/admin/product";
    }
}

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
import java.util.Map;

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
    public String create(@ModelAttribute("product") @Valid Product product,
                        BindingResult bindingResult,
                        Model model,
                        @RequestParam("file") MultipartFile file) throws IOException {

        if (bindingResult.hasErrors()) {
            model.mergeAttributes(ControllerUtils.getErrors(bindingResult));
            model.addAttribute("product", product);
            model.addAttribute("types", Product.Types.values());

            return "admin/product/create";
        } else {
            product = productAdminService.create(product, file);

            return "redirect:/admin/product/" + product.getId() + "?create_success";
        }
    }

    @GetMapping("{id}")
    public String getUpdate(@PathVariable(value = "id") Long id, Model model) {
        Product product = productAdminService.findById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("types", Product.Types.values());

        return "admin/product/update";
    }

    //Todo change from post to patch
    //Todo after changing type of product, save picture to right folder
    @PostMapping("{id}")
    public String update(@ModelAttribute("product") @Valid Product product,
                             BindingResult bindingResult,
                             @PathVariable(value = "id") Long id,
                             Model model,
                             @RequestParam("file") MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            model.mergeAttributes(ControllerUtils.getErrors(bindingResult));
            model.addAttribute("product", product);
            model.addAttribute("types", Product.Types.values());

            return "admin/product/update";
        }

        product = this.productAdminService.update(product, file);

        return "redirect:/admin/product/" + product.getId() + "?update_success";
    }

    //Todo method to DELETE
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Product product = productAdminService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        //Todo check this and if file have not deleted, show error
        productAdminService.delete(product);

        return "redirect:/admin/product" + "?delete_success";
    }
}

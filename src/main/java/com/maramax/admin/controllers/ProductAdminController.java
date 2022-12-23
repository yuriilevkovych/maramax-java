package com.maramax.admin.controllers;

import com.maramax.product.Product;
import com.maramax.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {
    @Autowired
    private ProductRepository productRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAllByOrderByIdAsc());

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
//        if (result.hasErrors()) {
//            return "/admin/product/create";
//        }
        Product product = new Product(null, number, type, description, "");

        if (file != null) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename =  "/img/maramax-images-compressed/"+ product.getType() + "/" + uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + resultFilename));
            product.setImg_path(resultFilename);
        }

        productRepository.save(product);

        return "redirect:/admin/product";
    }

    @GetMapping("{product}")
    public String update(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);
        model.addAttribute("types", Product.Types.values());

        return "admin/product/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable(value = "id") Long id, @Valid Product product,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);

            return "admin/product/edit";
        }

        productRepository.save(product);

        return "redirect:/admin/product";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        productRepository.delete(product);

        return "redirect:/admin/product";
    }
}

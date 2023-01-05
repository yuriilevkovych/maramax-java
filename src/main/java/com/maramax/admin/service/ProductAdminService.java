package com.maramax.admin.service;

import com.maramax.product.Product;
import com.maramax.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductAdminService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAllByOrderByIdDesc();
    }

    public Product create(Product product, MultipartFile file) throws IOException {
        product = this.setProductImage(file, product);

        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    public boolean delete(Product product) {
        if (!this.deleteImage(product)) {
            return false;
        }

        productRepository.delete(product);

        return true;
    }

    public boolean update(Product product, MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            Product oldProduct = this.productRepository.findById(product.getId()).get();
            this.deleteImage(oldProduct);
            product = this.setProductImage(file, product);
        }

        productRepository.save(product);

        return true;
    }

    private Product setProductImage(MultipartFile file, Product product) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename =  "/img/maramax-images-compressed/"+ product.getType() + "/" + uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(this.uploadPath + resultFilename));
            product.setImg_path(resultFilename);
        }

        return product;
    }

    private boolean deleteImage(Product product) {
        if (product.getImg_path() != null) {
            File file = new File(this.uploadPath + "/" + product.getImg_path());

            if (file.exists()) {
                return file.delete();
            }
        }

        return true;
    }
}

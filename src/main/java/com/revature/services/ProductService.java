package com.revature.services;

import com.revature.dtos.ProductInfo;
import com.revature.models.Product;
import com.revature.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    public List<Product> saveAll(List<Product> productList, List<ProductInfo> metadata) {
    	return productRepository.saveAll(productList);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public void createItem(Product product) {
        System.out.println(product);

        Product item = new Product();
        item.setQuantity(product.getQuantity());
        item.setPrice(product.getPrice());
        item.setDescription(product.getDescription());
        item.setImage(product.getImage());
        item.setName(product.getName());

        productRepository.save(item);
    }

    public void updateItem(int id, Product product) {

        Optional<Product> updatedProduct = productRepository.findById(id);

        updatedProduct.get().setQuantity(product.getQuantity());
        if (product.getPrice() != 0) {
            updatedProduct.get().setPrice(product.getPrice());
        }
        if (product.getDescription() != null) {
            updatedProduct.get().setDescription(product.getDescription());
        }
        if (product.getImage() != null) {
            updatedProduct.get().setImage(product.getImage());
        }
        if (product.getName() != null) {
            updatedProduct.get().setName(product.getName());
        }

        productRepository.save(updatedProduct.get());

    }
}

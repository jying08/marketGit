package com.market.git.web.controller;

import com.market.git.domain.Product;
import com.market.git.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll()
    {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId)
    {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId)
    {
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product)
    {
        return productService.save(product);
    }
    public Optional<List<Product>> getScarseProducts(int categoryId)
    {
        return productService.getScarseProducts(categoryId);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId)
    {
        return productService.delete(productId);
    }
}

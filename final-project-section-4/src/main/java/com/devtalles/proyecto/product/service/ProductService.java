package com.devtalles.proyecto.product.service;

import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws InvalidProductException {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) throws InvalidProductException {
        ProductValidator.validate(product);
        if(!productRepository.existsById(product.getId())){
            productRepository.save(product);
            System.out.println("Producto guardado exitosamente...");
        }else{
            throw new InvalidProductException("¡El producto que desea agregar ya existe!");
        }
    }

    public void deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.delete(id);
            System.out.println("Producto eliminado exitosamente...");
        }else{
            throw new ProductNotFoundException("¡El producto que desea eliminar no existe!");
        }
    }

    public void updateProduct(Product product) throws ProductNotFoundException, InvalidProductException {
        ProductValidator.validate(product);
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            productRepository.update(optionalProduct);
            System.out.println("Producto actualizado exitosamente...");
        }else{
            throw new ProductNotFoundException("¡El producto que desea actualizar no existe!");
        }
    }
}

package com.devtalles.proyecto.product.repository;

import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryServices implements ProductRepository {

    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() throws InvalidProductException {
        if(products.isEmpty()) {
            throw new InvalidProductException("La lista esta vacia");
        }

        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public void update(Optional<Product> product) throws ProductNotFoundException {
        if(product.isPresent()) {
            Long idToUpdate = product.get().getId();
            int index = findIndexById(idToUpdate);
            if(index != -1){
                products.set(index, product.get());
            }else{
                throw new ProductNotFoundException("El producto que quiere actualizar no existe");
            }
        }else{
            throw new ProductNotFoundException("El producto que quiere actualizar no existe");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return products.stream().anyMatch(p -> p.getId().equals(id));
    }

    private int findIndexById(Long id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}

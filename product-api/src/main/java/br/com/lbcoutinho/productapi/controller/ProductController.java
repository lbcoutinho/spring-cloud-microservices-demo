package br.com.lbcoutinho.productapi.controller;

import br.com.lbcoutinho.productapi.entity.Product;
import br.com.lbcoutinho.productapi.exception.ProductNotFoundException;
import br.com.lbcoutinho.productapi.repository.ProductRepository;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product product) {
        product.setId(null);
        product = productRepository.save(product);

        return ResponseEntity.created(URI.create("/product/" + product.getId())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Product product) {
        Product storedProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        if (product.getName() != null) storedProduct.setName(product.getName());
        if (product.getImage() != null) storedProduct.setImage(product.getImage());
        if (product.getBarCode() != null) storedProduct.setBarCode(product.getBarCode());
        if (product.getPrice() != null) storedProduct.setPrice(product.getPrice());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFound(ProductNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Product with id = %d not found", e.getId()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleException(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(" and "));

        return ResponseEntity.badRequest().body(errorMsg);
    }
}

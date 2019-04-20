package br.com.lbcoutinho.productapi.repository;

import br.com.lbcoutinho.productapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

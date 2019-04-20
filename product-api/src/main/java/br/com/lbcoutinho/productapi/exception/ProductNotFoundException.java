package br.com.lbcoutinho.productapi.exception;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException {

    private Long id;

    public ProductNotFoundException(Long id) {
        this.id = id;
    }
}

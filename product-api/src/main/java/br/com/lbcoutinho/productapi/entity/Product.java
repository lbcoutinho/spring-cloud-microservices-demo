package br.com.lbcoutinho.productapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "image is required")
    private String image;
    @NotNull(message = "barCode is required")
    private String barCode;
    @NotNull(message = "price is required")
    @Min(value = 1, message = "price must be greater than zero")
    private Integer price;

    public Product(String name, String image, String barCode, Integer price) {
        this.name = name;
        this.image = image;
        this.barCode = barCode;
        this.price = price;
    }
}

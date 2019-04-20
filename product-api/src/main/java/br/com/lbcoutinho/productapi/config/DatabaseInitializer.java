package br.com.lbcoutinho.productapi.config;

import br.com.lbcoutinho.productapi.entity.Product;
import br.com.lbcoutinho.productapi.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {
        log.info("Starting database initialization...");

        productRepository.saveAll(Arrays.asList(
                new Product("Kitkat", "https://images-na.ssl-images-amazon.com/images/I/81hbTpUm6EL._SX385_.jpg", "00000001", 350),
                new Product("Bis", "https://http2.mlstatic.com/chocolate-bis-lacta-caixa-60-unidades-de-126g-D_NQ_NP_739477-MLB26464937840_112017-F.jpg", "00000002", 300),
                new Product("Doritos", "https://wongfood.vteximg.com.br/arquivos/ids/170855-750-750/33602-01-7466.jpg", "00000003", 400),
                new Product("Água", "https://www.imigrantesbebidas.com.br/bebida/images/products/2893_Agua_Mineral_Crystal_Spal_Sem_Gas_500_ml.1534767661.jpg", "00000004", 150),
                new Product("Guaraná Fruki", "https://w1.ezcdn.com.br/superemkasa/fotos/grande/20444fg1/refrigerante-fruki-guarana-lt-350ml.jpg", "00000005", 300)
        ));

        log.info("Products inserted = {}", productRepository.count());
        log.info("Products = {}", productRepository.findAll());
        log.info("Database initialization finished!");
    }
}
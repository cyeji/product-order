package com.yeji.productorder.product;

import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    ProductAdapter ( ProductRepository productRepository ) {
        this.productRepository = productRepository;
    }

    @Override
    public void save ( Product product ) {
        productRepository.save( product );
    }
}

package com.yeji.productorder.product;

import org.springframework.stereotype.Service;

@Service
class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    ProductAdapter ( ProductRepository productRepository ) {
        this.productRepository = productRepository;
    }

    @Override
    public void save ( Product product ) {
        productRepository.save( product );
    }

    @Override
    public Product getProduct ( Long productId ) {
        return productRepository.findById( productId ).orElseThrow( () -> new IllegalArgumentException( "상품이 존재하지 않습니다." ) );
    }
}

package com.yeji.productorder.product;

import org.springframework.stereotype.Component;

@Component
class ProductService {

    private final ProductPort productPort;

    ProductService ( final ProductPort productPort ) {
        this.productPort = productPort;
    }

    public void addProduct ( AddProductRequest request ) {
        final Product product = new Product( request.name(), request.price(), request.discountPolicy() );

        productPort.save( product );
    }
}

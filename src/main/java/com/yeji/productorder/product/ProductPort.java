package com.yeji.productorder.product;

interface ProductPort {

    void save ( Product product );

    Product getProduct ( Long productId );
}

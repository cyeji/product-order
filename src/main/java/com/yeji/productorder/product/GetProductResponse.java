package com.yeji.productorder.product;

import org.springframework.util.Assert;

record GetProductResponse(Long id, String name, int price, DiscountPolicy discountPolicy) {

    GetProductResponse {
        Assert.notNull( id, "상품 ID는 필수입니다." );
        Assert.hasText( name, "상품명은 필수입니다." );
        Assert.notNull( discountPolicy, "할인 정책은 필수입니다." );
    }

    public static GetProductResponse from ( Product product ) {
        return new GetProductResponse( product.getId(), product.getName(), product.getPrice(), product.getDiscountPolicy() );
    }
}

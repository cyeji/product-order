package com.yeji.productorder.product;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
class ProductRepository {

    private Map<Long, Product> presistence = new HashMap<>();
    private Long sequence = 0L;

    public void save ( Product product ) {

        product.assignId( ++sequence );
        presistence.put( product.getId(), product );
    }
}

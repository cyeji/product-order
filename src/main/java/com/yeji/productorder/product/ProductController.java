package com.yeji.productorder.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/product" )
class ProductController {

    private final ProductPort productPort;

    ProductController ( ProductPort productPort ) {this.productPort = productPort;}

    @PostMapping
    public ResponseEntity<Void> addProduct ( @RequestBody AddProductRequest request ) {
        final Product product = new Product( request.name(), request.price(), request.discountPolicy() );

        productPort.save( product );

        return ResponseEntity.status( HttpStatus.CREATED ).build();
    }

    @GetMapping( "/{productId}" )
    public ResponseEntity<GetProductResponse> getProduct ( @PathVariable Long productId ) {
        final Product product = productPort.getProduct( productId );

        return ResponseEntity.status( HttpStatus.OK ).body( GetProductResponse.from( product ) );
    }
}

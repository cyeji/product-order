package com.yeji.productorder.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;

public class ProductRequest {

    public static ExtractableResponse<Response> requestAddProduct ( AddProductRequest request ) {
        return RestAssured.given().log().all().contentType( ContentType.APPLICATION_JSON.getMimeType() ).body( request ).when().post( "/product" )
            .then().log().all().extract();
    }

    public static AddProductRequest getAddProductRequest () {
        final String name = "상품명";
        final int price = 100;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest( name, price, discountPolicy );
        return request;
    }
}

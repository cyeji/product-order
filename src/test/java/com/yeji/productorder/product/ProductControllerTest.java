package com.yeji.productorder.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.yeji.productorder.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

class ProductControllerTest extends ApiTest {

    @Test
    void 상품등록 () {
        final var request = ProductRequest.getAddProductRequest();

        // API 요청
        final var response = ProductRequest.requestAddProduct( request );

        assertThat( response.statusCode() ).isEqualTo( HttpStatus.SC_CREATED );
    }

    @Test
    void 상품조회 () {
        ProductRequest.requestAddProduct( ProductRequest.getAddProductRequest() );
        Long productId = 1L;

        final ExtractableResponse<Response> response = RestAssured.given().log().all().when().get( "/product/{productId}", productId ).then().log()
            .all().extract();

        assertThat( response.statusCode() ).isEqualTo( HttpStatus.SC_OK );
        assertThat( response.jsonPath().getString( "name" ) ).isEqualTo( "상품명" );
    }

}

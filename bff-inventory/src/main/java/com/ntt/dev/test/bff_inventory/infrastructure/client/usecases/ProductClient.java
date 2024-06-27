package com.ntt.dev.test.bff_inventory.infrastructure.client.usecases;


import com.ntt.dev.test.bff_inventory.domain.model.Product;
import org.apache.commons.lang3.ObjectUtils;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductClient {

    @GET("v1/products/{id}")
    Call<Product> findProductById(
            @Path(value = "id") String id);

    @GET("v1/products/categories/{category}")
    Call<List<Product>> findProductByCategory(
            @Query("category") String category);
    @POST("v1/products/")
    Call<Void> createProduct(
            @Body Product product);

    @PUT("v1/products/")
    Call<Product> modifyProduct(
            @Body Product product);

    @DELETE("v1/products/")
    Call<Product> deleteProduct(
            @Body Product product);

}

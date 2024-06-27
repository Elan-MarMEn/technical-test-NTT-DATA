package com.ntt.dev.test.bff_inventory.infrastructure.client.config;

import com.ntt.dev.test.bff_inventory.infrastructure.client.usecases.ProductClient;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    private final String BASE_URL = "http://localhost:8081/inventory/";

    @Bean
    public ProductClient createProductClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        var retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit.create(ProductClient.class);
    }

}

package com.example.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {
    @Value("%{elasticsearch.address}")
    private String address;
    private static final String SCHEME = "http";
    @Bean
    public RestClientBuilder Es(){
        HttpHost host= new HttpHost(address,9200,SCHEME);
        return RestClient.builder(host);
    }
    @Bean
    public RestHighLevelClient restHighLevelClient(@Autowired RestClientBuilder Es){
        return new RestHighLevelClient(Es());
    }

}

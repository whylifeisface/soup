package com.example.javaelastic.config;

import lombok.Data;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Data
public class es extends AbstractElasticsearchConfiguration {
    @Override
    public RestHighLevelClient elasticsearchClient() {
        return null;
    }
}

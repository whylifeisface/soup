package com.example.serviceImpl;

import com.example.entity.GoodVo;
import com.example.service.Search;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service()

public class SearchImp implements Search {

    @Autowired
    private RestHighLevelClient client;
    @Override
    public List<GoodVo> doSearch(String key, int pageNum, int pageSize)  {
    //指定INDEX
        List<GoodVo> list = null;
        try {
            SearchRequest shop = new SearchRequest("shop");
            //指定查询对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            //分页
            searchSourceBuilder.from((pageNum - 1) * pageSize).size(pageSize);
            //设置高亮
            searchSourceBuilder.query(QueryBuilders.multiMatchQuery(key,"goodName"));
            shop.source(searchSourceBuilder);
            SearchResponse response = client.search(shop, RequestOptions.DEFAULT);
            long value = response.getHits().getTotalHits().value;

            if (0>value){
                return null;
            }
            list = new ArrayList<>();
            SearchHit[] hits = response.getHits().getHits();
            for (SearchHit hit : hits){
                Integer goodId = Integer.valueOf((Integer) hit.getSourceAsMap().get("GoodId"));
                String goodName = String.valueOf(hit.getSourceAsMap().get("GoodName"));
                String goodsNameH1 = String.valueOf(hit.getSourceAsMap().get("goodsNameH1"));
                BigDecimal marketPrice = new BigDecimal(String.valueOf(hit.getSourceAsMap().get("marketPrice")));
                String originalImg = String.valueOf(hit.getSourceAsMap().get("OriginalImg"));
                GoodVo goodVo = new GoodVo(goodId, goodName, goodsNameH1, marketPrice,originalImg);
                list.add(goodVo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
}

package com.example.service;

import com.example.entity.GoodVo;
import com.example.entity.TGoods;

import java.io.IOException;
import java.util.List;

public interface Search {
List<GoodVo> doSearch(String Good, int pageNum, int pageSize) throws IOException;
}

package com.kq.service;

import com.alibaba.fastjson.JSONObject;
import com.kq.vo.GenerateParams;

import java.text.ParseException;

/**
 * Created by huang on 2018/4/21.
 * =============================================
 */
public interface GenerateJsonService {
    JSONObject generateJson(GenerateParams generateParams) throws ParseException;
}

package com.kq.vo;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by huang on 2018/4/22.
 * =============================================
 */
public class ResponseVO {

    private Map<String, Object> result;
    private int resultCode;
    private String resultMessage;

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

}

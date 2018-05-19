package com.kq.vo;

import java.util.List;

/**
 * Created by huang on 2018/4/21.
 * =============================================
 */
public class GenerateParams {

    private String dataType;
    private List<KqiVO> kqiVOList;
    private String startTime;
    private String endTime;
    private Long interval;

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public List<KqiVO> getKqiVOList() {
        return kqiVOList;
    }

    public void setKqiVOList(List<KqiVO> kqiVOList) {
        this.kqiVOList = kqiVOList;
    }
}

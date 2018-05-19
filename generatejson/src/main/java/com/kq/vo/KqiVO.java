package com.kq.vo;

/**
 * Created by huang on 2018/4/21.
 * =============================================
 */
public class KqiVO {
    private String id;
    private int min;
    private int max;
    private int scale;
    private String unit;
    private String serType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }
}

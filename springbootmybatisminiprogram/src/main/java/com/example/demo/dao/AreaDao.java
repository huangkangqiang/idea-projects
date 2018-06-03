package com.example.demo.dao;

import com.example.demo.entity.Area;

import java.util.List;

/**
 * Created by huang on 2018/5/21.
 * =============================================
 */
public interface AreaDao {
    /**
     * 查询所有区域
     *
     * @return 所有区域
     */
    List<Area> queryAreaAll();

    /**
     * 新增区域
     *
     * @param area 区域
     * @return 影响行数
     */
    int insertArea(Area area);

    /**
     * 根据区域id删除区域
     *
     * @param areaId 区域id
     * @return 影响行数
     */
    int removeArea(Integer areaId);

    /**
     * 修改区域
     *
     * @param area 区域
     * @return 影响行数
     */
    int updateArea(Area area);

    /**
     * 根据区域id查找区域
     *
     * @param areaId 区域id
     * @return 区域
     */
    Area queryAreaById(Integer areaId);
}

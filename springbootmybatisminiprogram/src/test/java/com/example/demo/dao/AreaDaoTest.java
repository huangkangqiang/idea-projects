package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by huang on 2018/5/21.
 * =============================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryAreaAll() throws Exception {
        List<Area> areaList=areaDao.queryAreaAll();
        assertEquals(1,areaList.size());
    }

    @Test
    public void queryAreaById() throws Exception {
        Area area=areaDao.queryAreaById(1);
        assertEquals("东城",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() throws Exception {
        Area area=new Area();
        area.setAreaName("西城");
        area.setPriority(100);
        int effectedRowNum=areaDao.insertArea(area);
        assertEquals(1,effectedRowNum);
    }

    @Test
    @Ignore
    public void removeArea() throws Exception {
        Integer areaId=1;
        int effectedRowNum=areaDao.removeArea(areaId);
        assertEquals(1,effectedRowNum);
    }

    @Test
    @Ignore
    public void updateArea() throws Exception {
        Area area=new Area();
        area.setAreaId(1);
        area.setPriority(10);
        area.setAreaName("东城");
        int effectedRowNum=areaDao.updateArea(area);
        assertEquals(1,effectedRowNum);
    }

}
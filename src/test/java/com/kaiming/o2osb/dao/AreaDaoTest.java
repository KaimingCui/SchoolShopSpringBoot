package com.kaiming.o2osb.dao;

import com.kaiming.o2osb.entity.Area;
import com.kaiming.o2osb.util.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest{
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){

        System.out.println(MD5.getMd5("123456"));
//        List<Area> areaList = areaDao.queryArea();
//        assertEquals(3,areaList.size());
    }
}

package com.kaiming.o2osb.dao;

import com.kaiming.o2osb.entity.HeadLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadLineDaoTest{

    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void testQueryHeadLine(){

        List<HeadLine> list = headLineDao.queryHeadLine(new HeadLine());
        assertEquals(4,list.size());
    }
}

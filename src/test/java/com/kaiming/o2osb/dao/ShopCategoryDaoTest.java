package com.kaiming.o2osb.dao;

import com.kaiming.o2osb.entity.ShopCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCategoryDaoTest{
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory(){
//        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
////        assertEquals(23,shopCategoryList.size());
//        ShopCategory shopCategory = new ShopCategory();
//        ShopCategory shopCategoryParent = new ShopCategory();
//        shopCategoryParent.setShopCategoryId(10L);
//        shopCategory.setParent(shopCategoryParent);
//        List<ShopCategory> shopCategoryList1 = shopCategoryDao.queryShopCategory(shopCategory);
//        assertEquals(2,shopCategoryList1.size());
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
        assertEquals(6,shopCategoryList.size());
    }
}

package com.kaiming.o2osb.dao;

import com.kaiming.o2osb.entity.ProductCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest{

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    @Ignore
    public void testBQueryByShopId() throws Exception{
        long shopId = 29L;
        List<ProductCategory> list = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println(list.size());
    }

    @Test
    @Ignore
    public void testABatchInsertProductCategory() throws Exception{
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("商品类别1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("商品类别2");
        productCategory2.setPriority(2);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(1L);
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testCDeletetProductCategory() throws Exception{
        long shopId = 1L;
        List<ProductCategory> list = productCategoryDao.queryProductCategoryList(shopId);
        for (ProductCategory pc : list) {
            if ("商品类别1".equals(pc.getProductCategoryName()) || "商品类别2".equals(pc.getProductCategoryName())) {
                int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(), shopId);
                if(effectedNum <= 0 ){
                    throw new RuntimeException("error");
                }
                assertEquals(1,effectedNum);
            }
        }
    }

}


package com.kaiming.o2osb.service;

import com.kaiming.o2osb.dto.ProductCategoryExecution;
import com.kaiming.o2osb.entity.ProductCategory;
import com.kaiming.o2osb.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 查询指定某个店铺的所有商品类别信息
     *
     * @param shopId
     * @return List<ProductCategory>
     */
    public List<ProductCategory> getProductCategoryList(long shopId);


    /**
     *
     * @param productCategoryList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    /**
     * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}

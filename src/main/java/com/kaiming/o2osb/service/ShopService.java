package com.kaiming.o2osb.service;

import com.kaiming.o2osb.dto.ImageHolder;
import com.kaiming.o2osb.dto.ShopExecution;
import com.kaiming.o2osb.entity.Shop;
import com.kaiming.o2osb.exceptions.ShopOperationException;

public interface ShopService {

    /**
     * 根据shopCondition分页返回列表数据以及数量count
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);


    /**
     * 通过店铺Id获取店铺信息
     *
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);


    /**
     * 更新店铺信息，包括对图片的处理
     *
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;


    /**
     * 注册店铺信息，包括图片处理
     *
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;


}

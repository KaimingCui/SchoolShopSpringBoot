package com.kaiming.o2osb.service;

import com.kaiming.o2osb.dto.UserShopMapExecution;
import com.kaiming.o2osb.entity.UserShopMap;

public interface UserShopMapService {

	/**
	 * 根据传入的查询信息分页查询用户积分列表
	 * 
	 * @param userShopMapCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	UserShopMapExecution listUserShopMap(UserShopMap userShopMapCondition, int pageIndex, int pageSize);

	/**
	 * 根据用户Id和店铺Id返回该用户在某个店铺的积分情况
	 * 
	 * @param userId
	 * @param shopId
	 * @return
	 */
	UserShopMap getUserShopMap(long userId, long shopId);

}

package com.kaiming.o2osb.dao;

import java.util.List;

import com.kaiming.o2osb.entity.Area;

public interface AreaDao {
	/**
	 * 列出区域列表
	 * 
	 * @return areaList
	 */
	List<Area> queryArea();

	/**
	 * 插入区域信息
	 * 
	 * @param area
	 * @return
	 */
	int insertArea(Area area);

	/**
	 * 更新区域信息
	 * 
	 * @param area
	 * @return
	 */
	int updateArea(Area area);

	/**
	 * 删除区域信息
	 * 
	 * @param areaId
	 * @return
	 */
	int deleteArea(long areaId);

	/**
	 * 批量删除区域列表
	 * 
	 * @param areaIdList
	 * @return
	 */
	int batchDeleteArea(List<Long> areaIdList);
}

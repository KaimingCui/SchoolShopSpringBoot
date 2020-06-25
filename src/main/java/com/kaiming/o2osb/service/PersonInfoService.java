package com.kaiming.o2osb.service;

import com.kaiming.o2osb.dto.PersonInfoExecution;
import com.kaiming.o2osb.entity.PersonInfo;

public interface PersonInfoService {

	/**
	 * 根据用户Id获取personInfo信息
	 * 
	 * @param userId
	 * @return
	 */
	PersonInfo getPersonInfoById(Long userId);

	/**
	 * 根据查询条件分页返回用户信息列表
	 * 
	 * @param personInfoCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PersonInfoExecution getPersonInfoList(PersonInfo personInfoCondition, int pageIndex, int pageSize);

	/**
	 * 根据传入的PersonInfo修改对应的用户信息
	 * 
	 * @param pi
	 * @return
	 */
	PersonInfoExecution modifyPersonInfo(PersonInfo pi);
}

package com.ruoyi.customer.service;

import com.ruoyi.customer.domain.Info;
import java.util.List;

/**
 * 顾客 服务层
 * 
 * @author 李其伟
 * @date 2018-11-08
 */
public interface IInfoService 
{
	/**
     * 查询顾客信息
     * 
     * @param custId 顾客ID
     * @return 顾客信息
     */
	public Info selectInfoById(Integer custId);
	
	/**
     * 查询顾客列表
     * 
     * @param info 顾客信息
     * @return 顾客集合
     */
	public List<Info> selectInfoList(Info info);
	
	/**
     * 新增顾客
     * 
     * @param info 顾客信息
     * @return 结果
     */
	public int insertInfo(Info info);
	
	/**
     * 修改顾客
     * 
     * @param info 顾客信息
     * @return 结果
     */
	public int updateInfo(Info info);
		
	/**
     * 删除顾客信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteInfoByIds(String ids);
	
}

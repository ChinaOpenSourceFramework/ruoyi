package com.ruoyi.customer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.customer.mapper.InfoMapper;
import com.ruoyi.customer.domain.Info;
import com.ruoyi.customer.service.IInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 顾客 服务层实现
 * 
 * @author 李其伟
 * @date 2018-11-08
 */
@Service
public class InfoServiceImpl implements IInfoService 
{
	@Autowired
	private InfoMapper infoMapper;

	/**
     * 查询顾客信息
     * 
     * @param custId 顾客ID
     * @return 顾客信息
     */
    @Override
	public Info selectInfoById(Integer custId)
	{
	    return infoMapper.selectInfoById(custId);
	}
	
	/**
     * 查询顾客列表
     * 
     * @param info 顾客信息
     * @return 顾客集合
     */
	@Override
	public List<Info> selectInfoList(Info info)
	{
	    return infoMapper.selectInfoList(info);
	}
	
    /**
     * 新增顾客
     * 
     * @param info 顾客信息
     * @return 结果
     */
	@Override
	public int insertInfo(Info info)
	{
	    return infoMapper.insertInfo(info);
	}
	
	/**
     * 修改顾客
     * 
     * @param info 顾客信息
     * @return 结果
     */
	@Override
	public int updateInfo(Info info)
	{
	    return infoMapper.updateInfo(info);
	}

	/**
     * 删除顾客对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteInfoByIds(String ids)
	{
		return infoMapper.deleteInfoByIds(Convert.toStrArray(ids));
	}
	
}

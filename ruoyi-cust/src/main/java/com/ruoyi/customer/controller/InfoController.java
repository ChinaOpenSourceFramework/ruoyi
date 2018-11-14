package com.ruoyi.customer.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.customer.domain.Info;
import com.ruoyi.customer.service.IInfoService;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.web.core.base.BaseController;

/**
 * 顾客 信息操作处理
 * 
 * @author 李其伟
 * @date 2018-11-08
 */
@Controller
@RequestMapping("/customer/info")
public class InfoController extends BaseController
{
    private String prefix = "customer/info";
	
	@Autowired
	private IInfoService infoService;
	
	@RequiresPermissions("customer:info:view")
	@GetMapping()
	public String info()
	{
	    return prefix + "/info";
	}
	
	/**
	 * 查询顾客列表
	 */
	@RequiresPermissions("customer:info:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Info info)
	{
		startPage();
        List<Info> list = infoService.selectInfoList(info);
		return getDataTable(list);
	}
	
	/**
	 * 新增顾客
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存顾客
	 */
	@RequiresPermissions("customer:info:add")
	@Log(title = "顾客", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Info info)
	{		
		return toAjax(infoService.insertInfo(info));
	}

	/**
	 * 修改顾客
	 */
	@GetMapping("/edit/{custId}")
	public String edit(@PathVariable("custId") Integer custId, ModelMap mmap)
	{
		Info info = infoService.selectInfoById(custId);
		mmap.put("info", info);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存顾客
	 */
	@RequiresPermissions("customer:info:edit")
	@Log(title = "顾客", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Info info)
	{		
		return toAjax(infoService.updateInfo(info));
	}
	
	/**
	 * 删除顾客
	 */
	@RequiresPermissions("customer:info:remove")
	@Log(title = "顾客", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(infoService.deleteInfoByIds(ids));
	}
	
}

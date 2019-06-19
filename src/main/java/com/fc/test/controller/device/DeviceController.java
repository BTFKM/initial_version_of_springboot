package com.fc.test.controller.device;

import com.alibaba.fastjson.JSON;
import com.fc.test.common.base.BaseController;
import com.fc.test.common.domain.AjaxResult;

import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.model.jpa.TDeviceFoundation;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("DeviceController")
@Api(value = "用户数据")
public class DeviceController extends BaseController {
	
	private String prefix = "admin/device";
	//已更改
	@GetMapping("view")
	@RequiresPermissions("system:user:view")
    public String view(Model model)
    {	
		
		setTitle(model, new TitleVo("设备管理", "设备列表", true,"欢迎进入设备界面", true, false));
        return prefix + "/list";
    }
	//已更改
	@PostMapping("list")
	@RequiresPermissions("system:user:list")
	@ResponseBody
	public Object list(Tablepar tablepar, String username){
		PageInfo<TDeviceFoundation> page=deviceService.list(tablepar,username) ;
		TableSplitResult<TDeviceFoundation> result=new TableSplitResult<TDeviceFoundation>(page.getPageNum(), page.getTotal(), page.getList());
		return  result;
	}
	
	/**
	 * 已完成
     * 新增设备
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }

	/**
	 * 已完成
	 * 新增设备
	 */
	@PostMapping("add")
	@RequiresPermissions("system:user:add")
	@ResponseBody
	public AjaxResult add(TDeviceFoundation device, Model model){
		int b=deviceService.insertDevice(device);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 已完成
	 * 删除设备
	 * @param ids
	 * @return
	 */
	@PostMapping("remove")
	@RequiresPermissions("system:user:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=deviceService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 已更改
	 * 检查Stateid
	 * @param tDeviceFoundation
	 * @return
	 */
	@PostMapping("checkStateid")
	@ResponseBody
	public int checkLoginNameUnique(TDeviceFoundation tDeviceFoundation){
//		int b=sysUserService.checkLoginNameUnique(tDeviceFoundation);
		int b=deviceService.checkStateidUnique(tDeviceFoundation);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 修改设备
	 * @param id
	 * @param mmap
	 * @return
	 */
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
		//查询所有角色
        mmap.put("TDeviceFoundation", deviceService.selectByPrimaryKey(id));
        return prefix + "/edit";
    }
	
	/**
     * 修改保存设备
     */
    @RequiresPermissions("system:user:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TDeviceFoundation tDeviceFoundation)
    {
        return toAjax(deviceService.updateDeviceInfo(tDeviceFoundation));
    }

	/**
	 * 修改设备火警状态
	 * @param id
	 *
	 * @return
	 */
	@PostMapping("/setfireon")
	@ResponseBody
	public AjaxResult setfireon(TDeviceFoundation t)
	{	//查询所有角色
		if(deviceService.getFirestate(t.getDeviceId())==0) {
			alarmWorkOrderServer.createOrder(t.getDeviceId());
			return toAjax(deviceService.updateFirestate(t.getDeviceId(),1));
		}
		else
			return toAjax(0);

	}

	/**
	 * 修改设备火警状态
	 * @param id
	 *
	 * @return
	 */
	@PostMapping("/setfireoff")
	@ResponseBody
	public AjaxResult setfireoff(TDeviceFoundation t)
	{	//查询所有角色
		System.out.println();
		System.out.println(t.getDeviceId());
		System.out.println();
		if(deviceService.getFirestate(t.getDeviceId())==1){
			return toAjax(deviceService.updateFirestate(t.getDeviceId(), 0));
		}
		else
			return toAjax(0);

	}


	
}

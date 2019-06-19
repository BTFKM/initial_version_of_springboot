package com.fc.test.controller.workorder;

import com.fc.test.common.base.BaseController;
import com.fc.test.common.domain.AjaxResult;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.model.jpa.TDeviceFoundation;
import com.fc.test.model.workorder.AlarmworkOrder;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Yi
 * @Date: 2019-6-18 20:43
 * @Version 1.0
 */
@Controller
@RequestMapping("OperatorController")
@Api(value = "工单")
public class WorkorderController extends BaseController {

    private String prefix = "admin/jobcontact";
    //已更改
    @GetMapping("view")
    @RequiresPermissions("system:user:view")
    public String view(Model model)
    {

        setTitle(model, new TitleVo("工单列表", "运维管理", true,"欢迎进入运维界面", true, false));
        return prefix + "/list";
    }

    //已更改
    @PostMapping("list")
    @RequiresPermissions("system:user:list")
    @ResponseBody
    public Object list(Tablepar tablepar, String username){
        PageInfo<AlarmworkOrder> page=alarmWorkOrderServer.list(tablepar,username) ;
        TableSplitResult<AlarmworkOrder> result=new TableSplitResult<AlarmworkOrder>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }

    //已更改
    @PostMapping("listdo")
    @RequiresPermissions("system:user:list")
    @ResponseBody
    public Object listdo(Tablepar tablepar, String username){
        PageInfo<AlarmworkOrder> page=alarmWorkOrderServer.listdo(tablepar,username) ;
        TableSplitResult<AlarmworkOrder> result=new TableSplitResult<AlarmworkOrder>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }


    //已更改
    @PostMapping("listundo")
    @RequiresPermissions("system:user:list")
    @ResponseBody
    public Object listundo(Tablepar tablepar, String username){
        PageInfo<AlarmworkOrder> page=alarmWorkOrderServer.listundo(tablepar,username) ;
        TableSplitResult<AlarmworkOrder> result=new TableSplitResult<AlarmworkOrder>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }






    //已更改
    @GetMapping("viewundo")
    @RequiresPermissions("system:user:view")
    public String viewundo(Model model)
    {

        setTitle(model, new TitleVo("工单列表", "运维管理", true,"欢迎进入运维界面", true, false));
        return prefix + "/listundo";
    }

    //已更改
    @GetMapping("viewdo")
    @RequiresPermissions("system:user:view")
    public String viewdo(Model model)
    {

        setTitle(model, new TitleVo("工单列表", "运维管理", true,"欢迎进入运维界面", true, false));
        return prefix + "/listdo";
    }



    /**
     * 修改设备火警状态
     * @param id
     *
     * @return
     */
    @PostMapping("/alreadywork")
    @ResponseBody
    public AjaxResult alreadywork(AlarmworkOrder t)
    {	//查询所有角色

        if(alarmWorkOrderServer.getWorkingtate(t.getOrderId())==0){
            return toAjax(alarmWorkOrderServer.markOrder(t.getOrderId(), 1));
        }
        else
            return toAjax(0);

    }



    @Override
    public void initBinder(WebDataBinder binder) {
        super.initBinder(binder);
    }

    @Override
    protected AjaxResult toAjax(int rows) {
        return super.toAjax(rows);
    }

    @Override
    public AjaxResult success() {
        return super.success();
    }

    @Override
    public AjaxResult error() {
        return super.error();
    }

    @Override
    public AjaxResult success(String message) {
        return super.success(message);
    }

    @Override
    public AjaxResult error(String message) {
        return super.error(message);
    }

    @Override
    public AjaxResult error(int code, String message) {
        return super.error(code, message);
    }

    @Override
    public AjaxResult retobject(int code, Object data) {
        return super.retobject(code, data);
    }

    @Override
    public String redirect(String url) {
        return super.redirect(url);
    }

    @Override
    public void setTitle(Model model, TitleVo titleVo) {
        super.setTitle(model, titleVo);
    }
}

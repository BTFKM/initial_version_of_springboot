package com.fc.test.controller.workorder;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.fc.test.common.base.BaseController;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.model.workorder.AlarmworkOrder;
import com.fc.test.model.workorder.NotificationLog;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Yi
 * @Date: 2019-6-19 15:08
 * @Version 1.0
 */

@Controller
@RequestMapping("MailController")
@Api(value = "工单")
public class MailController extends BaseController {
    private String prefix = "admin/mail";
    //已更改
    @GetMapping("view")
    @RequiresPermissions("system:user:view")
    public String view(Model model)
    {

        setTitle(model, new TitleVo("邮件日志列表", "邮件日志", true,"欢迎进入邮件日志界面", true, false));
        return prefix + "/list";
    }

    //已更改
    @PostMapping("list")
    @RequiresPermissions("system:user:list")
    @ResponseBody
    public Object list(Tablepar tablepar, String username){
        PageInfo<NotificationLog> page=alarmWorkOrderServer.listmail(tablepar,username) ;
        TableSplitResult<NotificationLog> result=new TableSplitResult<NotificationLog>(page.getPageNum(), page.getTotal(), page.getList());
        return  result;
    }


}

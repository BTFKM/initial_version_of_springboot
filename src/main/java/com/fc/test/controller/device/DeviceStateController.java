package com.fc.test.controller.device;

import com.alibaba.fastjson.JSON;
import com.fc.test.common.base.BaseController;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.domain.AjaxResult;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.model.jpa.TDeviceFoundation;
import com.fc.test.model.jpa.TDeviceFoundationExample;
import com.fc.test.service.AlarmWorkOrderServer;
import com.fc.test.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yi
 * @Date: 2019-6-18 16:26
 * @Version 1.0
 */

@RestController
@RequestMapping("DeviceStateController")
public class DeviceStateController  extends BaseController {
    @Autowired
    DeviceService deviceService;
    @Autowired
    AlarmWorkOrderServer alarmWorkOrderServer;
    private String prefix = "admin/device";

    /**
     * 获取所有数据
     */
    @GetMapping(value = "/getallinfo",produces = "application/json; charset=utf-8")
    public String getAllState()
    {
        List<TDeviceFoundation> ll = new ArrayList<TDeviceFoundation>(deviceService.getAllinfo());

        return JSON.toJSONString(ll);
    }

    /**
     * 修改设备火警状态
     * @param id
     *
     * @return
     */






}

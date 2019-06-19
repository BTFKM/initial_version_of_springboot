package com.fc.test.service;

import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.Convert;
import com.fc.test.mapper.jpa.TDeviceFoundationMapper;
import com.fc.test.model.auto.TSysRoleUser;
import com.fc.test.model.auto.TSysRoleUserExample;
import com.fc.test.model.auto.TsysUser;
import com.fc.test.model.auto.TsysUserExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.jpa.TDeviceFoundation;
import com.fc.test.model.jpa.TDeviceFoundationExample;
import com.fc.test.util.MD5Util;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Yi
 * @Date: 2019-6-17 20:56
 * @Version 1.0
 */
@Service
public class DeviceService implements BaseService<TDeviceFoundation,TDeviceFoundationExample> {

    @Autowired
    private TDeviceFoundationMapper tDeviceFoundationMapper;


    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<TDeviceFoundation> list(Tablepar tablepar, String belongname){
        TDeviceFoundationExample testExample=new TDeviceFoundationExample();
        testExample.setOrderByClause("device_id ASC");
        if(belongname!=null&&!"".equals(belongname)){
            testExample.createCriteria().andDeviceBelongLike("%"+belongname+"%");
//            testExample.createCriteria().andUsernameLike("%"+username+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<TDeviceFoundation> list= tDeviceFoundationMapper.selectByExample(testExample);
        PageInfo<TDeviceFoundation> pageInfo = new PageInfo<TDeviceFoundation>(list);
        return  pageInfo;
    }

    /**
     * 检查设备 state_id
     * @param tDeviceFoundation
     * @return
     */
    public int checkStateidUnique(TDeviceFoundation tDeviceFoundation){
        TDeviceFoundationExample example=new TDeviceFoundationExample();
        example.createCriteria().andStateIdEqualTo(tDeviceFoundation.getStateId());
        List<TDeviceFoundation> list=tDeviceFoundationMapper.selectByExample(example);
        return list.size();
    }


    /**
     * 添加设备信息
     * @param record
     *
     * @return
     */
    @Transactional
    public int insertDevice(TDeviceFoundation record) {
        System.out.println();
        System.out.println();
        System.out.println(record.getDeviceBelong());
        System.out.println();
        System.out.println();

        String device_id=SnowflakeIdWorker.getUUID();
        record.setDeviceId(device_id);
        record.setDeviceUserId("admin");
        record.setStateHum((float) 38.1);
        record.setStateTmp((float) 25.2);
        record.setStatePower((float) 100);
        record.setStateIsfire(0);
        record.setDeviceHealth(0);
        return tDeviceFoundationMapper.insertSelective(record);
    }


    //已完成
    @Override
    public int deleteByPrimaryKey(String id) {
        List<String> lista=Convert.toListStrArray(id);
        TDeviceFoundationExample example=new TDeviceFoundationExample();
        example.createCriteria().andDeviceIdIn(lista);
        return tDeviceFoundationMapper.deleteByExample(example);
    }


    /**
     * 修改设备信息
     * @param record
     * @param roles
     * @return
     */
    @Transactional
    public int updateDeviceInfo(TDeviceFoundation record) {
        //先删除这个用户的所有角色

        TDeviceFoundation indatabase = tDeviceFoundationMapper.selectByPrimaryKey(record.getDeviceId());
        record.setDeviceHealth(indatabase.getDeviceHealth());
        record.setStateIsfire(indatabase.getStateIsfire());
        record.setStatePower(indatabase.getStatePower());
        record.setStateTmp(indatabase.getStateTmp());
        record.setStateHum(indatabase.getStateHum());
        record.setDeviceUserId(indatabase.getDeviceUserId());
        tDeviceFoundationMapper.updateByPrimaryKeySelective(record);
        //修改用户信息
        return 1;
    }

    public List<TDeviceFoundation> getAllinfo() {
        TDeviceFoundationExample testExample=new TDeviceFoundationExample();
        testExample.createCriteria().andDeviceIdLike("%"+""+"%");
        List<TDeviceFoundation> list = tDeviceFoundationMapper.selectByExample(testExample);
        return list;
    }


    /**
     * 修改火警状态
     * @param record
     * @return
     */
    public int updateFirestate(String id,int state) {
        TDeviceFoundation tDeviceFoundation = new TDeviceFoundation();
        tDeviceFoundation.setDeviceId(id);
        tDeviceFoundation.setStateIsfire(state);
        //修改用户信息
        return tDeviceFoundationMapper.updateByPrimaryKeySelective(tDeviceFoundation);
    }

    /**
     * 根据ID获取火灾状态
     * @param record
     * @return
     */
    public int getFirestate(String id) {
        return tDeviceFoundationMapper.selectByPrimaryKey(id).getStateIsfire();
    }




    @Override
    public int insertSelective(TDeviceFoundation record) {
        return 0;
    }

    //完成
    @Override
    public TDeviceFoundation selectByPrimaryKey(String id) {

        return tDeviceFoundationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TDeviceFoundation record) {
        return tDeviceFoundationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByExampleSelective(TDeviceFoundation record, TDeviceFoundationExample example) {
        return 0;
    }

    @Override
    public int updateByExample(TDeviceFoundation record, TDeviceFoundationExample example) {
        return 0;
    }

    @Override
    public List<TDeviceFoundation> selectByExample(TDeviceFoundationExample example) {
        return tDeviceFoundationMapper.selectByExample(example);
    }

    @Override
    public long countByExample(TDeviceFoundationExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TDeviceFoundationExample example) {
        return 0;
    }
}

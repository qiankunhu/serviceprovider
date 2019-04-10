package com.hqk.serviceprovision.service.impl;

import com.hqk.serviceprovision.dao.UserinfoMapper;
import com.hqk.serviceprovision.entity.Userinfo;
import com.hqk.serviceprovision.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public List<Userinfo> getlistall(Userinfo dto) {

        List<Userinfo> list=userinfoMapper.getlistall(dto);

        return list;
    }
}

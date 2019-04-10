package com.hqk.serviceprovision.service;

import com.hqk.serviceprovision.entity.Userinfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserinfoService {

    public List<Userinfo> getlistall(Userinfo dto);

}

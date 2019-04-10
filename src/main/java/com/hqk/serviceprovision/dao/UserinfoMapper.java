package com.hqk.serviceprovision.dao;

import com.hqk.serviceprovision.entity.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoMapper {


     public List<Userinfo> getlistall(@Param("param") Userinfo dto);

     public void updateMoney();

     public void updateMoney(String a);

     public void addBumen();


 }

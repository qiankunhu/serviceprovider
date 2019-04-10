package com.hqk.serviceprovision.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-cloub-consumer")
public interface BumenRemote {


     @RequestMapping("api-c/bumen/getlistAll")
     public String getlistAll(@RequestParam(value = "name")String name);



}

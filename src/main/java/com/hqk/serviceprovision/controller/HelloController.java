package com.hqk.serviceprovision.controller;

import com.hqk.serviceprovision.dao.UserinfoMapper;
import com.hqk.serviceprovision.entity.Help;
import com.hqk.serviceprovision.entity.Userinfo;
import com.hqk.serviceprovision.remote.BumenRemote;
import com.hqk.serviceprovision.service.UserinfoService;
import com.hqk.serviceprovision.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
public class HelloController {

    @Value("${server.port}")
    String port;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    UserinfoService userinfoService;
    @Autowired
    BumenRemote bumenRemote;

    @GetMapping(value="/status")
    public Help token(HttpServletRequest httpServletRequest){
        String sessionId=httpServletRequest.getSession().getId();
        Help res=new Help();
        res.setCode("00");
        res.setSuccess("true");
        res.setMsg("服务正常");
        res.setToken(UUID.randomUUID().toString());
        res.setSessionId(sessionId);
        return res;
    }

    @RequestMapping("getlist")
    public ResponseData getlist( String requestBody){

        List<Userinfo> list=userinfoService.getlistall(null);

        ResponseData res=new ResponseData();
        res.setCode("00");
        res.setMsg("操作成功");
        res.setData(list);

        return  res;
    }

    @RequestMapping("hello")
    public  String  gethello(String name){

        return "hi " + name + " ,i am from port:" + port;
    }


    @RequestMapping("bumen")
    //@Transactional
    //@TxcTransaction(timeout = 1000 * 12)
    public  String  getbumen(String name){

        //String xid = TxcContext.getCurrentXid();
        System.out.println("xid："+name);
        String str=bumenRemote.getlistAll(name);
        userinfoMapper.updateMoney();

        return  "hello 这是是服务调用返回的："+str;
    }

}

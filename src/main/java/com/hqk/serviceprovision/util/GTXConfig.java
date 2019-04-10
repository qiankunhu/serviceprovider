package com.hqk.serviceprovision.util;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GTXConfig {

    //定义声明式事务，要想让事务annotation感知的话，要在这里定义一下
   /* @Bean(name = "txcScanner")
    @ConfigurationProperties//(prefix="aluser")
    public TxcTransactionScaner txcTransactionScaner()
    {
        //xxxx填写txc的逻辑组名
        return  new TxcTransactionScaner("myapp","txc_test_public.1129361738553704.QD",1,"https://test-cs-gts.aliyuncs.com");
        //return  new TxcTransactionScaner("huqiankunlol.1108003305224791.SH");
    }*/
}

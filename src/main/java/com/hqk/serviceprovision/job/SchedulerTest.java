package com.hqk.serviceprovision.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTest {

    private int count=0;

  //   @Scheduled(fixedRate = 60000) //表示每隔六秒打印一下内容
    //@Scheduled(cron="*/6 * * * * ?")
    public void dingshi(){

        System.out.println("测试定时任务,次数："+count++);
    }

}

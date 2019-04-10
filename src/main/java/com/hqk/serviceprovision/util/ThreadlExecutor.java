package com.hqk.serviceprovision.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//线程池
public class ThreadlExecutor {

   /*
    创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，
    若无可回收，则新建线程。
    ExecutorService cached= Executors.newCachedThreadPool();
    */

    /*
    创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    ExecutorService fix=Executors.newFixedThreadPool(5);
    */

   /*
   定时线程池，该线程池可用于周期性地去执行任务，通常用于周期性的同步数据。
    ScheduledExecutorService scheduled=Executors.newScheduledThreadPool(3);
    */

   /* 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
    保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    ExecutorService single=Executors.newSingleThreadExecutor();*/

    public static void main(String[] args) {



        IdWorker idWorker=new IdWorker();

        ExecutorService cached= Executors.newCachedThreadPool();
        ExecutorService fix=Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduled=Executors.newScheduledThreadPool(3);
        ExecutorService single=Executors.newSingleThreadExecutor();

        long time1=System.currentTimeMillis();
        System.out.println("开始："+time1);
        for (int i = 0; i < 20; i++) {
            final int index = i;
            try {

                String str=HttpClientUtil.get("http://127.0.0.1:9999/docker");
                System.out.println(">>>>>"+str);
                //idWorker.nextId();
               // System.out.println(idWorker.nextId());
                //if(stringRedisTemplate.opsForValue().setIfAbsent(key,String.valueOf(time)))
                //Thread.sleep(index * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cached.execute(new Runnable() {
                public void run() {
                    //System.out.println("开始时间："+System.currentTimeMillis());
                }
            });
        }
        long time2=System.currentTimeMillis();
       // System.out.println("当前程序耗时："+(time2-time1)+"ms");

        /*for (int i = 0; i < 10; i++) {
            final int index = i;
            fix.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }*/

       /* scheduled.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("延迟五秒之后，每8秒执行一次");
            }
        }, 5,8,TimeUnit.SECONDS);
        */

       /* for (int i = 0; i < 10; i++) {
            final int index = i;
            single.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        single.shutdown();*/
    }

}



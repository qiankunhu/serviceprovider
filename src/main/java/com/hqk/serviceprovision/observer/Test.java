package com.hqk.serviceprovision.observer;

import java.util.Observer;

public class Test {

    public static void main(String[] args) {

        //创建被观察者对象
        Watched watched = new Watched();

        //创建观察者对象，并将被观察者对象登记
        Observer watcher = new Watcher(watched);

        Observer WatcherTwo = new WatcherTwo(watched);

        watched.deleteObserver(watcher);//删除一下观察者试试

        //给被观察者状态赋值
        watched.setData("start");
        watched.setData("run");
        watched.setData("stop");

    }

}

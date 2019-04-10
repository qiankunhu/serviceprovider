package com.hqk.serviceprovision.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class Watcher implements Observer {

    public Watcher(Observable o){
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        System.out.println("大哥 接收到的消息" + ((Watched)o).getData());
    }
}

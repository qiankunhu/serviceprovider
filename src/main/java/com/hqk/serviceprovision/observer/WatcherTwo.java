package com.hqk.serviceprovision.observer;

import java.util.Observable;
import java.util.Observer;

public class WatcherTwo implements Observer{

    public WatcherTwo(Observable o){
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        System.out.println("二哥 接收到的消息" + ((Watched)o).getData());

    }
}

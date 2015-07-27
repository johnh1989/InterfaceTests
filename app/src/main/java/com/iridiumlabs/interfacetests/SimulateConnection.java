package com.iridiumlabs.interfacetests;

import android.os.Handler;

/**
 * Created by doktor on 7/27/2015.
 */
public class SimulateConnection implements Runnable {

    public SimulateConnection(){}

    FiveSecondsPassed fivesecondspassed;

    Handler mHandler = new Handler();

    public interface FiveSecondsPassed{
        public void onFiveSecondsPassed(int time);
    }

    int time = 0;
    @Override
    public void run() {
        while (time != 25){
            try{Thread.sleep(5000);}catch (Exception e){}
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    fivesecondspassed.onFiveSecondsPassed(time);
                }
            });
            time+=5;
        }
    }

    public void setonFiveSecondsPassedListener(FiveSecondsPassed fsp){
        fivesecondspassed = fsp;
    }
}

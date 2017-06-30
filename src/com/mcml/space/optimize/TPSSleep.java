package com.mcml.space.optimize;

import com.mcml.space.core.VLagger;

public class TPSSleep
        implements Runnable {

    public void run() {
        if (VLagger.TPSSleepenable == true) {
            try {
                Thread.sleep(VLagger.TPSSleepPeriod);
            } catch (InterruptedException ex) {
            }
        }
    }
}
package com.mcml.space.optimize;

import com.mcml.space.core.VLagger;
import com.mcml.space.util.AzureAPI;

public class HeapClear implements Runnable {

    @Override
    public void run() {
        if(VLagger.HeapClearenable){
            if(!VLagger.HeapClearMessage.equalsIgnoreCase("none")){
                AzureAPI.log(VLagger.PluginPrefix + VLagger.HeapClearMessage);
            }
            System.gc();
            System.runFinalization();
        }
    }
}

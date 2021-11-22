package com.RESTInPeace.imageAPI;

import com.RESTInPeace.imageAPI.utils.QueueReadUtils;

public class Application {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                public void run() {
                    QueueReadUtils.readQueueAndSavePicture();
                }
            }).start();
        }
    }
}

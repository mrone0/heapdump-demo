package com.mrone.heapdump.controller;


import com.mrone.heapdump.entity.Like;
import com.mrone.heapdump.entity.User;
import com.mrone.heapdump.service.HeapDumpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Thread.sleep;


@RestController
public class HeapDumpController {

    private HeapDumpService heapDumpService;

    public HeapDumpController (HeapDumpService heapDumpService){
        this.heapDumpService=heapDumpService;
    }

    @GetMapping("/start")
    public void add () throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; ; i++) {
                Like like = new Like();
                User user = new User(
                        i,
                        "thread1-" + i,
                        i,
                        "thread1-address-" + i,
                        like
                );
                like.setUser(user);
                heapDumpService.addLike(like);
                heapDumpService.addUser(user);
            }
        }).start();

        for (;;){
            System.out.println("started...");
            Runtime runtime = Runtime.getRuntime();


            long maxMemory = runtime.maxMemory();
            long totalMemory = runtime.totalMemory();
            long freeMemory = runtime.freeMemory();

            System.out.println("Max Memory: " + maxMemory + " bytes");
            System.out.println("Total Memory: " + totalMemory + " bytes");
            System.out.println("Free Memory: " + freeMemory + " bytes");
            sleep(5000);
        }
    }


}

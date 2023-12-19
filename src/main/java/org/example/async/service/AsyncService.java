package org.example.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void ayncTaskRecurssively(int cnt) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(cnt + "::: 비동기 작업 중 :::(" + cnt + ")");
    }
}

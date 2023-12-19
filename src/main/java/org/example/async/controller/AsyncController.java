package org.example.async.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.async.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping("/executeAsyncTask")
    public String executeAsyncTask() throws InterruptedException {
        log.info("비동기 작업이 시작되었습니다.");
        int num = 0;

        for( int i=0 ; i<10; i++ ){
            num++;
            asyncService.ayncTaskRecurssively(num);
        }
        return "비동기 작업 시작!";
    }
}


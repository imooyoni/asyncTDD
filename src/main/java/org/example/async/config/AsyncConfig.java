package org.example.async.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Slf4j
@Configuration
public class AsyncConfig extends AsyncConfigurerSupport {

    @Override
    @PostConstruct
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(2);

        // ( 최대 스레드+대기열 크기)가 실행 코드 수 보다 작을 때, java.util.concurrent.RejectedExcutionException이 발생.
        // 최대 스레드 만큼 실행되고 초과하는 실행 코드 수는 대기열에 들어가 최초 스레드 실행 이후 대기열 코드 수 만큼 추가 실행.
        // ( 최대 스레드 + 대기열 크기 )를 초과하는 실행 코드 들은 실행 되지 않음.

        executor.setThreadNamePrefix("ASYNC-");
        executor.initialize();

        log.info("####Async Executor Initialized: CorePoolSize={}, MaxPoolSize={}, QueueCapacity={}",
                executor.getCorePoolSize(), executor.getMaxPoolSize(), executor.getQueueCapacity());

        return executor;
    }

}

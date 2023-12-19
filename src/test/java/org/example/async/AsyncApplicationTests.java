package org.example.async;

import lombok.RequiredArgsConstructor;
import org.example.async.config.AsyncConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class AsyncApplicationTests {

    AsyncConfig asyncConfig = new AsyncConfig();

    @Test
    void contextLoads() {
    }

    @Test
    void setAsyncConfig() {
        asyncConfig.getAsyncExecutor();
    }

}

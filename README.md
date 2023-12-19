# Java Async annotaion
Spring Framework는 @Async 어노테이션을 통해 비동기 작업을 구현하고 스레드 관리를 할 수 있다.

##  문제상황 및 목표
aws sagemaker를 활용하는 프로젝트의 대용량 데이터 송수신 과정에서 timeout이 발생했다. java의 async 어노테이션을 통한 비동기 방식을 활용하여 스레드 관리를 통해 데이터 처리 시간을 단축하는 것이 목표이다.

## 프로젝트 세팅하기
비동기 작업을 위한 async 어노테이션은 spring 3.0부터, 스레드 제어를 위한 Excutor는 java 5 버전부터 사용이 가능하므로 버전에 크게 구애받지 않을 것으로 예상된다.</br></br>

의존성 추가
```gradle
implementation 'org.springframework.boot:spring-boot-starter-async'

```
스레드 제어를 위한 Config 클래스 작성
```java
@EnableAsync
@Slf4j
@Configuration
public class AsyncConfig extends AsyncConfigurerSupport {

    @Override
    @PostConstruct
    public Executor getAsyncExecutor() {
        
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(2);
        
        executor.setThreadNamePrefix("ASYNC-");
        executor.initialize();
        
        log.info("####Async Executor Initialized: CorePoolSize={}, MaxPoolSize={}, QueueCapacity={}",
                executor.getCorePoolSize(), executor.getMaxPoolSize(), executor.getQueueCapacity());

        return executor;
    }

}
```
비동기 작업을 위한 Async 메서드 작성
```java

```
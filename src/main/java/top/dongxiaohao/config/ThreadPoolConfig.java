package top.dongxiaohao.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 17:55
 */
@Slf4j
@Configuration
public class ThreadPoolConfig {
    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 10;
    public static final int QUEUE_CAPACITY = 100;
    public static final int KEEP_ALIVE_TIME = 1;
    public static final String THREAD_NAME_PREFIX = "asyncArtisan-";

  //  @Bean("asyncPool")
  //  ThreadPoolExecutor executorService(){
  //      final int cpuSize = Runtime.getRuntime().availableProcessors();
  //      return new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
  //              new ArrayBlockingQueue<>(QUEUE_CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());
  //}

    @Bean
    public ThreadPoolTaskExecutor asyncExecutor() {
        final int cpuSize = Runtime.getRuntime().availableProcessors();
        log.info("cpuSize:{}", cpuSize);
        ArtisanThreadPoolTaskExecutor executor = new ArtisanThreadPoolTaskExecutor();
        executor.setCorePoolSize(cpuSize);
        executor.setMaxPoolSize(2 * cpuSize);
        executor.setQueueCapacity(500);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("asyncArtisan-");
        executor.initialize();
        return executor;
    }

}

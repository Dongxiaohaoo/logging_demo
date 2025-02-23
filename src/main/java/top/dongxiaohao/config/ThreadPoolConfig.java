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

    @Bean("threadPool")
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

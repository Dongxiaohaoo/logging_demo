package top.dongxiaohao.demos.web;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 17:52
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final ThreadPoolTaskExecutor pool;
    @SneakyThrows
    //@Async("customPoolTaskExecutor")
    public String test() {
        pool.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.error("test 接口被调用,线程池");
        });
        log.error("test 接口被调用");
        return "test";
    }
}

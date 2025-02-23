package top.dongxiaohao.config;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 18:16
 */

import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import top.dongxiaohao.util.ThreadMdcUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ArtisanThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
    public ArtisanThreadPoolTaskExecutor() {
        super();
    }

    /**
     * 执行任务，传递父线程的MDC上下文信息到子线程中
     */
    @Override
    public void execute(Runnable task) {
        super.execute(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
    }

    /**
     * 提交带有返回值的任务，传递父线程的MDC上下文信息到子线程中
     */
    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
    }

    /**
     * 提交无返回值的任务，传递父线程的MDC上下文信息到子线程中
     */
    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
    }
}

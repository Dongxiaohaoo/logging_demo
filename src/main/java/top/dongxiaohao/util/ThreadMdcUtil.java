package top.dongxiaohao.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 * <p>
 * 线程MDC工具类，用于在多线程环境中传递MDC上下文信息
 */
public class ThreadMdcUtil {

    private static final String TRACE_ID = "TRACE_ID";

    /**
     * 生成唯一的追踪ID
     */
    public static String generateTraceId() {
        return UUID.randomUUID().toString();
    }

    /**
     * 如果当前MDC中不存在追踪ID，则设置追踪ID
     */
    public static void setTraceIdIfAbsent() {
        if (MDC.get(TRACE_ID) == null) {
            MDC.put(TRACE_ID, generateTraceId());
        }
    }

    /**
     * 用于在父线程向线程池中提交任务时，将父线程的MDC上下文信息复制给子线程
     *
     * @param callable 要执行的任务
     * @param context  父线程的MDC上下文信息
     * @param <T>      任务返回类型
     * @return 复制了父线程MDC上下文信息的任务
     */
    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                return callable.call();
            } finally {
                MDC.clear();
            }
        };
    }

    /**
     * 用于在父线程向线程池中提交任务时，将父线程的MDC上下文信息复制给子线程
     *
     * @param runnable 要执行的任务
     * @param context  父线程的MDC上下文信息
     * @return 复制了父线程MDC上下文信息的任务
     */
    public static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}

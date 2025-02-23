package top.dongxiaohao.interceptor;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 17:44
 */
import cn.hutool.core.lang.UUID;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 * <p>
 * MDC(Mapped Diagnostic Context)诊断上下文映射，是@Slf4j提供的一个支持动态打印日志信息的工具
 */
public class TraceLogInterceptor implements HandlerInterceptor {

    // 追踪ID在MDC中的键名
    private static final String TRACE_ID = "TRACE_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 生成追踪ID，如果客户端传入了追踪ID，则使用客户端传入的追踪ID，否则使用默认的ULID生成
        String tid = UUID.randomUUID().toString();
        if (StringUtils.hasLength(request.getHeader(TRACE_ID))) {
            tid = request.getHeader(TRACE_ID);
        }
        // 将追踪ID放入MDC中
        MDC.put(TRACE_ID, tid);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) {
        // 请求处理完成后，从MDC中移除追踪ID
        MDC.remove(TRACE_ID);
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}

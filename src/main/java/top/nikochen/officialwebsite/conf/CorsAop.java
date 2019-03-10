package top.nikochen.officialwebsite.conf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 *@作者
 *@功能描述
 *@时间9:43
 *@方法09
 *2018/9/10
 */
@Aspect
@Order(2)
@Component
public class CorsAop {
    @Pointcut("@annotation(top.nikochen.officialwebsite.conf.CORS)")
    public void pointcut() {}
    private Logger log = LoggerFactory.getLogger(CorsAop.class);


    @AfterReturning(value = "pointcut()", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, Object result) {
        log.info("[拦截请求:]-[{}]","CORS-跨域拦截");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();//获取request
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();//获取response
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        log.info("[执行结果:]-[{}]", result);
        return result;
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("[执行异常:]-[{}]-[{}]",ex.getMessage(),ex.getStackTrace());
    }
}

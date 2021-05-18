package com.bin.bole.api.aop;

import com.bin.bole.dao.OpLogMapper;
import com.bin.bole.domain.hr.Hr;
import com.bin.bole.domain.sys.OpLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Objects;

/**
 * function:  使用aop实现记录接口的访问日志
 */
@Aspect
@Component
@Slf4j
public class OpLogMonitorAdvice {

    @Autowired
    private OpLogMapper opLogMapper;

    /**
     * 打印监控的初始日志内容
     *
     * @apiNote 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次
     * PostConstruct在构造函数之后执行，init（）方法之前执行
     */
    @PostConstruct
    public void init() {
        log.info("opLog monitor advice init...");
    }

    @AfterThrowing(value = "@annotation(opLogMonitor)")
    public void afterThrow(OpLogMonitor opLogMonitor) {
        String monitorName = opLogMonitor.op();
        log.error("{} error", monitorName);
    }

    /**
     * 接口的监控切点
     *
     * @param pjp          方法连接点
     * @param opLogMonitor 方法中的监控注解
     * @apiNote 凡是有连接点的方法都会被动态监控，都会先执行此方法
     */
    @Around("@annotation(opLogMonitor)")
    @ResponseBody
    public Object monitor(ProceedingJoinPoint pjp, OpLogMonitor opLogMonitor) throws Throwable {
        String monitorName = null;
        if (Objects.nonNull(opLogMonitor)) {
            monitorName = opLogMonitor.op();
        } else {
            log.error("can^t get monitor annotation error");
        }
        Object result;

        //通过反射去执行连接点方法，并将执行结果返回
        result = pjp.proceed();

        // 记录操作日志
        try {
            Object[] args = pjp.getArgs();
            Integer hrId = -1;
            for (Object o : args) {
                if (o instanceof Authentication) {
                    Authentication authentication = (Authentication) o;
                    Hr hr = (Hr) authentication.getPrincipal();
                    hrId = hr.getId();
                }
            }
            OpLog opLog = new OpLog();
            opLog.setHrId(hrId);
            opLog.setAddDate(new Date());
            opLog.setOperate(monitorName);
            opLogMapper.insertSelective(opLog);
        } catch (Exception e) {
            log.error("error:{}", e);
            return result;
        }

        return result;
    }


}

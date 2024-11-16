package com.yh.ar.task;

import com.yh.ar.cache.ProductCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ScheduledTaskService
 * @Description:
 * @Author: system
 * @Date: 2024-11-16 11:21
 * @Version: 1.0
 **/
@Component
public class ScheduledTaskService {

    @Autowired
    ProductCache productCache;

    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * @Author: system
     * @Description: 刷新产品信息缓存 隔2小时执行一次
     * @Date: 2024-11-16 11:30:37
     * @Param:
     * @return: void
     **/
    @Scheduled(cron = "0 0 0/2 * * ?")
    public void refreshProductCache() {
        try {
            productCache.loadCache();
        } catch (Exception e) {
            logger.error("产品信息缓存刷新失败!");
            e.printStackTrace();
        }
    }

}
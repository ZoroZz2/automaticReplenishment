package com.yh.ar.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName: BusinessUtils
 * @Description: 业务工具类
 * @Author: system
 * @Date: 2024-11-03 23:33
 * @Version: 1.0
 **/
public class BusinessUtils {

    private BusinessUtils() {
    }


    /**
     * @Author: system
     * @Description: 获取批次号
     * @Date: 2024-11-03 23:35:12
     * @Param:
     * @return: String
     **/
    public static String getBatchNumber() {
        // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = dateFormat.format(new Date());
        // 获取随机6位数
        Random random = new Random();
        int number = random.nextInt(900000);
        return today + number;
    }


}
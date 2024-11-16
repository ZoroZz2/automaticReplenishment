package com.yh.ar.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * @Author: system
     * @Description: 获取修改数据列表
     * @Date: 2024-11-15 11:52:26
     * @Param: params
     * @return: List<Map>
     **/
    public static List<Map> getOperateList(Map<String, Object> params) {
        String updListStr = params.entrySet().stream()
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
        Map<String, Object> dataMap = JSON.parseObject(updListStr, new TypeReference<>() {
        });
        JSONArray dataArr = (JSONArray) dataMap.get("operateList");

        return dataArr.toJavaList(Map.class);
    }

    /**
     * @Author: system
     * @Description: 获取指定包下的对象实例
     * @Date: 2024-10-30 22:27:24
     * @Param: packageName
     * @return: List<Class < ?>>
     **/
    public static List<Class<?>> getClazzList(String packageName) {
        List<Class<?>> clazzes = new ArrayList<>();
        // 获取包名对应的路径
        String path = packageName.replace('.', '/');
        // 获取包的URL
        URL resource = Thread.currentThread().getContextClassLoader().getResource(path);

        if (resource != null) {
            // 获取文件目录
            File directory = new File(resource.getFile());

            if (directory.exists()) {
                // 获取该目录下的所有文件
                File[] files = directory.listFiles();
                for (File file : files) {
                    // 检查文件是不是以.class结尾
                    if (file.isFile() && file.getName().endsWith(".class")) {
                        String className = packageName + '.' + file.getName().replace(".class", "");
                        try {
                            // 通过类名获取Class对象
                            Class<?> clazz = Class.forName(className);
                            // 将Class对象添加到列表
                            clazzes.add(clazz);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return clazzes;
    }

}
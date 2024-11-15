package com.yh.ar.util;

import ch.qos.logback.core.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @ClassName: paramUtils
 * @Description: 参数处理工具类
 * @Author: system
 * @Date: 2024-10-26 10:31
 * @Version: 1.0
 **/
public class ParamUtils {

    private void paramUtils() {
    }

    /**
     * 字符源，可以剔除O、L、0和1，避免0和1与O和L混淆，这里没有剔除<br/>
     * 可以根据需要加入小写英文字母和特殊字符等
     */
    private static final String[] GENERATE_SOURCE = new String[]{"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    private static final int STR_LEN = GENERATE_SOURCE.length;

    /**
     * @Author: system
     * @Description: 使用 Collections.shuffle 生成六位随机字符串
     * @Date: 2024-11-14 17:12:59
     * @Param:
     * @return: String
     **/
    public static String generateByShuffle() {
        List<String> list = Arrays.asList(GENERATE_SOURCE);
        //打乱元素排序，增加反推难度
        Collections.shuffle(list);
        StringBuilder randomStr = new StringBuilder();
        for (int i = 0; i < STR_LEN; i++) {
            randomStr.append(list.get(i));
        }
        //更改下面两个数字可以取到不同位数的随机数
        return randomStr.substring(4, 10);
    }

    /**
     * @Author: system
     * @Description: 字符串转Map
     * @Date: 2024-10-28 23:52:24
     * @Param: param
     * @return: Map<String, Object>
     **/
    public static Map<String, Object> stringToMap(String param) {
        if (StringUtil.isNullOrEmpty(param)) {
            return new HashMap<>();
        }
        return JSON.parseObject(param, new TypeReference<HashMap<String, Object>>() {
        });
    }

    /**
     * @Author: system
     * @Description: 字符串转List
     * @Date: 2024-10-28 23:52:42
     * @Param: param
     * @return: List<String>
     **/
    public static List<String> stringToList(String param) {
        if (StringUtil.isNullOrEmpty(param)) {
            return new ArrayList<>();
        }
        return Arrays.asList(param.split(","));
    }

    /**
     * @Author: system
     * @Description: Map转Bean
     * @Date: 2024-10-30 17:18:45
     * @Param: map
     * @Param: beanClass
     * @return: T
     **/
    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) throws Exception {
        T bean = beanClass.newInstance();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String fieldName = entry.getKey();
            Field field = bean.getClass().getDeclaredField(fieldName);
            field.setAccessible(true); // 使私有属性也可以访问
            field.set(bean, entry.getValue());
        }

        return bean;
    }

    /**
     * @Author: system
     * @Description: 字符串转List
     * @Date: 2024-10-28 23:52:42
     * @Param: param
     * @return: List<String>
     **/
    public static void multiFieldToList(Map<String, Object> param) {
        if (param.isEmpty()) {
            return;
        }

        param.forEach((key, value) -> {
            if (key.contains(Constants.MULTI_FIELD_MARK)) { // 包含多选字段
                List<String> list = stringToList((String) value);
                param.put(key, list);
            }
        });
    }

    /**
     * @Author: system
     * @Description: 判断多个字符串是否为空
     * @Date: 2024-10-28 23:52:48
     * @Param: str
     * @return: boolean
     **/
    public static boolean isNullOrEmpty(String... str) {
        String s = str.toString();
        if (StringUtil.isNullOrEmpty(s)) {
            return false;
        }
        String[] strArr = s.split(",");
        for (String val : strArr) {
            if (StringUtil.isNullOrEmpty(val)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Author: system
     * @Description: 首字母变成大写
     * @Date: 2024-11-08 23:32:22
     * @Param: str
     * @return: String
     **/
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * @Author: system
     * @Description: List<Object>转换成List<Map>
     * @Date: 2024-11-09 11:21:25
     * @Param: list
     * @return: List<Map < String, Object>>
     **/
    public static <T> List<Map<String, Object>> convertListToMaps(List<T> list) {
        return list.stream()
                .map(item -> {
                    Map<String, Object> map = new HashMap<>();
                    for (Field field : item.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        try {
                            map.put(field.getName(), field.get(item));
                        } catch (IllegalAccessException e) {
                            // Handle exception
                        }
                    }
                    return map;
                })
                .collect(ArrayList::new, List::add, List::addAll);
    }

    /**
     * @Author: system
     * @Description: 处理空字符串
     * @Date: 2024-11-13 17:51:58
     * @Param: params
     * @return: List<Map < String, Object>>
     **/
    public static void processingEmptyStrings(Map<String, Object> params) {
        params.forEach((key, value) -> {
            if (StringUtil.isNullOrEmpty((String) value)) { // 值为空
                params.put(key, "-9999");
            }
        });
    }

}

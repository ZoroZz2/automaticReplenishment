package com.yh.ar.util;

import com.yh.ar.business.pojo.ResultData;

/**
 * @ClassName: ResultDataUtils
 * @Description: 响应信息工具
 * @Author: system
 * @Date: 2024-10-27 11:54
 * @Version: 1.0
 **/
public class ResultDataUtils {

    private ResultDataUtils() {
    }

    /**
     * @Author: system
     * @Description: 请求处理成功
     * @Date: 2024-10-28 23:53:00
     * @Param: data
     * @return: ResultData<T>
     **/
    public static <T> ResultData<T> success(T data) {
        ResultData<T> result = new ResultData<>();
        result.setCode(Constants.SUCCESS_CODE);
        result.setMessage("请求成功");
        result.setData(data);
        return result;
    }

    /**
     * @Author: system
     * @Description: 请求处理失败
     * @Date: 2024-10-28 23:53:08
     * @Param: message
     * @return: ResultData<T>
     **/
    public static <T> ResultData<T> fail(String message) {
        ResultData<T> result = new ResultData<>();
        result.setCode(Constants.FAIL_CODE);
        result.setMessage(message);
        return result;
    }

}

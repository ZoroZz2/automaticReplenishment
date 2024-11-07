package com.yh.ar.business.pojo;

import lombok.Data;

/**
 * @ClassName: ResultData
 * @Description: 响应结果信息
 * @Author: system
 * @Date: 2024-10-27 11:52
 * @Version: 1.0
 **/
@Data
public class ResultData<T> {

    // 状态码
    private int code;
    // 提示信息
    private String message;
    // 返回数据
    private T data;

}

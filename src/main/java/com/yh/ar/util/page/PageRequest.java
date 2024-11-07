package com.yh.ar.util.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: PageRequest
 * @Description: 分页参数
 * @Author: system
 * @Date: 2024-10-29 22:57
 * @Version: 1.0
 **/
@Data
public class PageRequest {
    /**
     * @Author: system
     * @Description: 当前页码
     **/
    private int pageNum = 1;
    /**
     * @Author: system
     * @Description: 每页数量
     **/
    private int pageSize = 10;
    /**
     * @Author: system
     * @Description: 查询参数
     **/
    private Map<String, Object> params = new HashMap<>();

}
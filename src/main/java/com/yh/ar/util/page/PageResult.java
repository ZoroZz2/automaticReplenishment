package com.yh.ar.util.page;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PageResult
 * @Description: 响应参数
 * @Author: system
 * @Date: 2024-10-29 23:00
 * @Version: 1.0
 **/
@Data
public class PageResult {
    /**
     * @Author: system
     * @Description: 当前页码
     **/
    private int pageNum;
    /**
     * @Author: system
     * @Description: 每页数量
     **/
    private int pagesize;
    /**
     * @Author: system
     * @Description: 记录总数
     **/
    private long totalSize;
    /**
     * @Author: system
     * @Description: 页码总数
     **/
    private int totalPages;
    /**
     * @Author: system
     * @Description: 结果数据
     **/
    private List<Map<String, Object>> dataList = new ArrayList<>();

}
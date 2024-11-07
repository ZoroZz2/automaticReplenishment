package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.util.Map;

/**
 * @ClassName: DataBoardService
 * @Description: 数据看板
 * @Author: system
 * @Date: 2024-11-02 15:38
 * @Version: 1.0
 **/
public interface DataBoardService {

    ResultData<PageResult> queryDataStatisticsList(Map<String, Object> params);

    ResultData<PageResult> queryInventorySituationList(Map<String, Object> params);

}
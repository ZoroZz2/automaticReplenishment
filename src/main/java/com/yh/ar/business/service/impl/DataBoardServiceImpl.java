package com.yh.ar.business.service.impl;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.DataBoardService;
import com.yh.ar.util.page.PageResult;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: DataBoardServiceImpl
 * @Description: 数据看板逻辑实现
 * @Author: system
 * @Date: 2024-11-02 15:42
 * @Version: 1.0
 **/
@Service("dataBoardService")
public class DataBoardServiceImpl implements DataBoardService {

    /**
     * @Author: system
     * @Description: 查询数据统计
     * @Date: 2024-11-03 18:10:39
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<PageResult> queryDataStatisticsList(Map<String, Object> params) {
        return null;
    }

    /**
     * @Author: system
     * @Description: 查询库存情况
     * @Date: 2024-11-03 18:10:47
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<PageResult> queryInventorySituationList(Map<String, Object> params) {
        return null;
    }
}
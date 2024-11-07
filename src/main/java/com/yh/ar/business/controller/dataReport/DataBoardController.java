package com.yh.ar.business.controller.dataReport;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.DataBoardService;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: dataBoardController
 * @Description: 数据看板
 * @Author: system
 * @Date: 2024-10-25 17:37
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/dataReport")
public class DataBoardController {

    @Autowired
    DataBoardService dataBoardService;

    /**
     * @Author: system
     * @Description: 查询数据统计
     * @Date: 2024-11-03 18:09:02
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/queryDataStatisticsList", method = RequestMethod.POST)
    public ResultData<PageResult> queryDataStatisticsList(@RequestParam Map<String, Object> params) {
        return dataBoardService.queryDataStatisticsList(params);
    }

    /**
     * @Author: system
     * @Description: 查询库存情况
     * @Date: 2024-11-03 18:09:16
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @RequestMapping(value = "/queryInventorySituationList", method = RequestMethod.POST)
    public ResultData<PageResult> queryInventorySituationList(@RequestParam Map<String, Object> params) {
        return dataBoardService.queryInventorySituationList(params);
    }

}

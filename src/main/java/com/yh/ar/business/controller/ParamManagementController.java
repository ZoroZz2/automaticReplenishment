package com.yh.ar.business.controller;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.ParamManagementService;
import com.yh.ar.cache.ParamManagementCache;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ParamManagementController
 * @Description: 参数管理
 * @Author: system
 * @Date: 2024-10-25 17:34
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/paramManagement")
public class ParamManagementController {

    @Autowired
    ParamManagementService paramManagementService;

    @Autowired
    ParamManagementCache paramManagementCache;

    /**
     * @Author: system
     * @Description: 获取指定参数缓存值
     * @Date: 2024-11-09 11:15:12
     * @Param: paramKey
     * @return: List<Object>
     **/
    @GetMapping("/getParamCacheList")
    public List<Object> getParamCacheList(String cacheKey) {
        return paramManagementCache.getParamCacheList(cacheKey);
    }

    /**
     * @Author: system
     * @Description: 提醒设置列表查询
     * @Date: 2024-11-03 16:02:21
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryRemindStandardizationList")
    public ResultData<PageResult> queryRemindStandardizationList(@RequestParam Map<String, Object> params) {
        return paramManagementService.queryRemindStandardizationList(params);
    }

    /**
     * @Author: system
     * @Description: 新增提醒设置
     * @Date: 2024-11-03 18:22:13
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/addRemindStandardization", method = RequestMethod.POST)
    public ResultData<String> addRemindStandardization(@RequestParam Map<String, Object> params) {
        return paramManagementService.addRemindStandardization(params);
    }

    /**
     * @Author: system
     * @Description: 修改提醒设置
     * @Date: 2024-11-03 18:22:22
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updRemindStandardization", method = RequestMethod.POST)
    public ResultData<String> updRemindStandardization(@RequestParam Map<String, Object> params) {
        return paramManagementService.updRemindStandardization(params);
    }

    /**
     * @Author: system
     * @Description: 删除提醒设置
     * @Date: 2024-11-03 18:22:30
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/delRemindStandardization", method = RequestMethod.POST)
    public ResultData<String> delRemindStandardization(@RequestParam Map<String, Object> params) {
        return paramManagementService.delRemindStandardization(params);
    }

    /**
     * @Author: system
     * @Description: 补货规则列表查询
     * @Date: 2024-11-03 16:02:21
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryRestockingRulesList")
    public ResultData<PageResult> queryRestockingRulesList(@RequestParam Map<String, Object> params) {
        return paramManagementService.queryRestockingRulesList(params);
    }

    /**
     * @Author: system
     * @Description: 新增补货规则
     * @Date: 2024-11-03 18:22:13
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/addRestockingRules", method = RequestMethod.POST)
    public ResultData<String> addRestockingRules(@RequestParam Map<String, Object> params) {
        return paramManagementService.addRestockingRules(params);
    }

    /**
     * @Author: system
     * @Description: 修改补货规则
     * @Date: 2024-11-03 18:22:22
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updRestockingRules", method = RequestMethod.POST)
    public ResultData<String> updRestockingRules(@RequestParam Map<String, Object> params) {
        return paramManagementService.updRestockingRules(params);
    }

    /**
     * @Author: system
     * @Description: 删除补货规则
     * @Date: 2024-11-03 18:22:30
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/delRestockingRules", method = RequestMethod.POST)
    public ResultData<String> delRestockingRules(@RequestParam Map<String, Object> params) {
        return paramManagementService.delRestockingRules(params);
    }

    /**
     * @Author: system
     * @Description: 各链路系数列表查询
     * @Date: 2024-11-03 16:02:21
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryLinkCoefficientList")
    public ResultData<PageResult> queryLinkCoefficientList(@RequestParam Map<String, Object> params) {
        return paramManagementService.queryLinkCoefficientList(params);
    }

    /**
     * @Author: system
     * @Description: 修改各链路系数
     * @Date: 2024-11-03 18:22:22
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updLinkCoefficient", method = RequestMethod.POST)
    public ResultData<String> updLinkCoefficient(@RequestParam Map<String, Object> params) {
        return paramManagementService.updLinkCoefficient(params);
    }

    /**
     * @Author: system
     * @Description: 库内系数列表查询
     * @Date: 2024-11-03 16:02:21
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryWarehouseCoefficientList")
    public ResultData<PageResult> queryWarehouseCoefficientList(@RequestParam Map<String, Object> params) {
        return paramManagementService.queryWarehouseCoefficientList(params);
    }

    /**
     * @Author: system
     * @Description: 修改库内系数（支持批量修改）
     * @Date: 2024-11-03 18:22:22
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updWarehouseCoefficient", method = RequestMethod.POST)
    public ResultData<String> updWarehouseCoefficient(@RequestParam Map<String, Object> params) {
        return paramManagementService.updWarehouseCoefficient(params);
    }

    /**
     * @Author: system
     * @Description: 销售等级列表查询
     * @Date: 2024-11-03 16:02:21
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/querySalesLevelList")
    public ResultData<PageResult> querySalesLevelList(@RequestParam Map<String, Object> params) {
        return paramManagementService.querySalesLevelList(params);
    }

    /**
     * @Author: system
     * @Description: 修改销售等级（支持批量修改）
     * @Date: 2024-11-03 18:22:22
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updSalesLevel", method = RequestMethod.POST)
    public ResultData<String> updSalesLevel(@RequestParam Map<String, Object> params) {
        return paramManagementService.updSalesLevel(params);
    }

    /**
     * @Author: system
     * @Description: 发货等级列表查询
     * @Date: 2024-11-03 16:02:21
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryShippingGradeList")
    public ResultData<PageResult> queryShippingGradeList(@RequestParam Map<String, Object> params) {
        return paramManagementService.queryShippingGradeList(params);
    }

    /**
     * @Author: system
     * @Description: 新增发货等级
     * @Date: 2024-11-03 18:22:13
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/addShippingGrade", method = RequestMethod.POST)
    public ResultData<String> addShippingGrade(@RequestParam Map<String, Object> params) {
        return paramManagementService.addShippingGrade(params);
    }

    /**
     * @Author: system
     * @Description: 修改发货等级
     * @Date: 2024-11-03 18:22:22
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updShippingGrade", method = RequestMethod.POST)
    public ResultData<String> updShippingGrade(@RequestParam Map<String, Object> params) {
        return paramManagementService.updShippingGrade(params);
    }

    /**
     * @Author: system
     * @Description: 删除发货等级
     * @Date: 2024-11-03 18:22:30
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/delShippingGrade", method = RequestMethod.POST)
    public ResultData<String> delShippingGrade(@RequestParam Map<String, Object> params) {
        return paramManagementService.delShippingGrade(params);
    }

    /**
     * @Author: system
     * @Description: 高风险产品下单安全系数
     * @Date: 2024-11-03 16:02:21
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryOrderSafetyFactorList")
    public ResultData<PageResult> queryOrderSafetyFactorList(@RequestParam Map<String, Object> params) {
        return paramManagementService.queryOrderSafetyFactorList(params);
    }

    /**
     * @Author: system
     * @Description: 修改高风险产品下单安全系数
     * @Date: 2024-11-03 18:22:22
     * @Param: params
     * @return: ResultData<String>
     **/
    @RequestMapping(value = "/updOrderSafetyFactor", method = RequestMethod.POST)
    public ResultData<String> updOrderSafetyFactor(@RequestParam Map<String, Object> params) {
        return paramManagementService.updOrderSafetyFactor(params);
    }

}

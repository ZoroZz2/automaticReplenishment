package com.yh.ar.business.service.impl;

import com.yh.ar.business.mapper.UpdateDataMapper;
import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.ParamManagementService;
import com.yh.ar.cache.ParamManagementCache;
import com.yh.ar.export.annotation.ExportAnnotation;
import com.yh.ar.util.Constants;
import com.yh.ar.util.ParamUtils;
import com.yh.ar.util.ResultDataUtils;
import com.yh.ar.util.page.PageResult;
import com.yh.ar.util.page.SelectDataAtom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ParamManagementServiceImpl
 * @Description: 参数管理业务逻辑实现
 * @Author: system
 * @Date: 2024-11-02 15:46
 * @Version: 1.0
 **/
@Service("paramManagementService")
public class ParamManagementServiceImpl implements ParamManagementService {

    @Autowired
    UpdateDataMapper updateDataMapper;

    @Autowired
    ParamManagementCache paramManagementCache;

    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * @Author: system
     * @Description: 查询提醒设置列表
     * @Date: 2024-11-03 18:36:12
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<PageResult> queryRemindStandardizationList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryRemindStandardizationList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增提醒设置列表
     * @Date: 2024-11-03 18:36:12
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<String> addRemindStandardization(Map<String, Object> params) {
        try {
            updateDataMapper.addRemindStandardization(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.REMIND_STANDARDIZATION_LIST);
        }
        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改提醒设置列表
     * @Date: 2024-11-03 18:36:12
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<String> updRemindStandardization(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updRemindStandardization(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.REMIND_STANDARDIZATION_LIST);
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 删除提醒设置列表
     * @Date: 2024-11-03 18:36:12
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<String> delRemindStandardization(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("删除失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.delRemindStandardization(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("删除失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.REMIND_STANDARDIZATION_LIST);
        }

        return ResultDataUtils.success("删除成功");
    }

    @Override
    public ResultData<PageResult> queryRestockingRulesList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryRestockingRulesList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增补货规则
     * @Date: 2024-11-03 20:23:37
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> addRestockingRules(Map<String, Object> params) {
        try {
            updateDataMapper.addRestockingRules(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.RESTOCKING_RULES_LIST);
        }
        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改补货规则
     * @Date: 2024-11-03 20:23:37
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updRestockingRules(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updRestockingRules(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.RESTOCKING_RULES_LIST);
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 删除补货规则
     * @Date: 2024-11-03 20:23:37
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> delRestockingRules(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("删除失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.delRestockingRules(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("删除失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.RESTOCKING_RULES_LIST);
        }

        return ResultDataUtils.success("删除成功");
    }


    @Override
    public ResultData<PageResult> queryLinkCoefficientList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryLinkCoefficientList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 修改各链路系数
     * @Date: 2024-11-03 20:32:26
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<String> updLinkCoefficient(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updLinkCoefficient(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.LINK_COEFFICIENT_LIST);
        }

        return ResultDataUtils.success("修改成功");
    }

    @Override
    public ResultData<PageResult> queryWarehouseCoefficientList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryWarehouseCoefficientList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 修改库内系数（支持批量修改）
     * @Date: 2024-11-03 20:48:26
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updWarehouseCoefficient(Map<String, Object> params) {
        List<Map> dataList = (List) params.get("updList");
        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("修改失败:请求参数[updList]不能为空!");
        }
        try {
            for (Map dataMap : dataList) {
                String id = (String) dataMap.get("id");
                if (!ParamUtils.isNullOrEmpty(id)) {
                    logger.error("修改库内系数失败，参数id为空！{}", dataMap);
                    continue;
                }
                updateDataMapper.updWarehouseCoefficient(dataMap);
            }
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.WAREHOUSE_COEFFICIENT_LIST);
        }
        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 查询销量等级
     * @Date: 2024-11-04 19:35:14
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    public ResultData<PageResult> querySalesLevelList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("querySalesLevelList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 修改销量等级（支持批量修改）
     * @Date: 2024-11-03 20:48:26
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updSalesLevel(Map<String, Object> params) {
        List<Map> dataList = (List) params.get("updList");
        if (null != dataList && dataList.isEmpty()) {
            return ResultDataUtils.fail("修改失败:请求参数[updList]不能为空!");
        }
        try {
            for (Map dataMap : dataList) {
                String id = (String) dataMap.get("id");
                if (!ParamUtils.isNullOrEmpty(id)) {
                    logger.error("修改销量等级失败，参数id为空！{}", dataMap);
                    continue;
                }
                updateDataMapper.updSalesLevel(dataMap);
            }
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.SALES_LEVEL_LIST);
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 查询发货等级
     * @Date: 2024-11-06 22:33:55
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "shippingGrade")
    public ResultData<PageResult> queryShippingGradeList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryShippingGradeList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 新增发货等级
     * @Date: 2024-11-03 21:04:30
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> addShippingGrade(Map<String, Object> params) {
        try {
            updateDataMapper.addShippingGrade(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("新增失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.SHIPPING_GRADE_LIST);
        }
        return ResultDataUtils.success("新增成功");
    }

    /**
     * @Author: system
     * @Description: 修改发货等级
     * @Date: 2024-11-03 21:04:30
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updShippingGrade(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updShippingGrade(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.SHIPPING_GRADE_LIST);
        }

        return ResultDataUtils.success("修改成功");
    }

    /**
     * @Author: system
     * @Description: 删除发货等级
     * @Date: 2024-11-03 21:04:30
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> delShippingGrade(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("删除失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.delShippingGrade(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("删除失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.SHIPPING_GRADE_LIST);
        }

        return ResultDataUtils.success("删除成功");
    }

    /**
     * @Author: system
     * @Description: 查询高风险产品下单安全系数
     * @Date: 2024-11-06 22:34:43
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @Override
    @ExportAnnotation(menuId = "orderSafetyFactor")
    public ResultData<PageResult> queryOrderSafetyFactorList(Map<String, Object> params) {
        PageResult pageResult = SelectDataAtom.selectDataList("queryOrderSafetyFactorList", params);
        return ResultDataUtils.success(pageResult);
    }

    /**
     * @Author: system
     * @Description: 高风险产品下单安全系数
     * @Date: 2024-11-03 21:04:30
     * @Param: params
     * @return: ResultData<String>
     **/
    @Override
    public ResultData<String> updOrderSafetyFactor(Map<String, Object> params) {
        String id = (String) params.get("id");
        if (!ParamUtils.isNullOrEmpty(id)) {
            return ResultDataUtils.fail("修改失败:请求参数[id]不能为空!");
        }

        try {
            updateDataMapper.updOrderSafetyFactor(params);
        } catch (Exception e) {
            return ResultDataUtils.fail("修改失败:请联系工作人员!");
        } finally {
            // 重新加载缓存
            paramManagementCache.loadParamCache(Constants.ORDER_SAFETY_FACTOR_LIST);
        }

        return ResultDataUtils.success("修改成功");
    }
}
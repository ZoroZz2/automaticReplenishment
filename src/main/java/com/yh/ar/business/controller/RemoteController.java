package com.yh.ar.business.controller;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.business.service.RemoteService;
import com.yh.ar.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RemoteController
 * @Description: 远程服务
 * @Author: system
 * @Date: 2024-11-14 23:38
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/api/remote")
public class RemoteController {

    @Autowired
    RemoteService remoteService;

    /**
     * @Author: system
     * @Description: 查询产品分类列表
     * @Date: 2024-11-14 23:42:03
     * @Param: params
     * @return: ResultData<PageResult>
     **/
    @GetMapping("/queryProductTypeList")
    public ResultData<List<String>> queryProductTypeList(@RequestParam Map<String, Object> params) throws IOException {
        return remoteService.queryProductTypeList(params);
    }

}
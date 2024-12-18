package com.yh.ar.business.service;

import com.yh.ar.business.pojo.ResultData;
import com.yh.ar.util.page.PageResult;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: RemoteService
 * @Description: 远程服务接口
 * @Author: system
 * @Date: 2024-11-14 23:39
 * @Version: 1.0
 **/
public interface RemoteService {
    ResultData<Map<String, Set>> queryProductDictList(Map<String, Object> params);
}
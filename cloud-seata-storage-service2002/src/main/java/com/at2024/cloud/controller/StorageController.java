package com.at2024.cloud.controller;

import com.at2024.cloud.resp.ResultData;
import com.at2024.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyh
 * @date 2024-08-11 18:59:10
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}

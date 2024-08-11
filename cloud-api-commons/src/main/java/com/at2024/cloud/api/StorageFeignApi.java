package com.at2024.cloud.api;

import com.at2024.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lyh
 * @date 2024-08-11 16:49:00
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {
    /**
     * 扣减库存
     * @param productId 商品ID
     * @param count 扣减数量
     * @return 结果集
     */
    @PostMapping("/storage/decrease")
    ResultData<Object> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

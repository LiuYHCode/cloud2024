package com.at2024.cloud.api;

import com.at2024.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lyh
 * @date 2024-08-11 16:47:18
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {
    /**
     * 余额扣减
     * @param userId 用户id
     * @param money 扣了多少钱
     * @return 结果集
     */
    @PostMapping("/account/decrease")
    ResultData<Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}

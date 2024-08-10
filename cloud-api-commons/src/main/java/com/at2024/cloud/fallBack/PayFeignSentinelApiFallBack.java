package com.at2024.cloud.fallBack;

import com.at2024.cloud.api.PayFeignSentinelApi;
import com.at2024.cloud.resp.ResultData;
import com.at2024.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @author lyh
 * @date 2024-08-10 21:28:28
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}

package com.at2024.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author lyh
 * @date 2024-08-11 19:06:27
 */
public interface AccountService {
    /**
     * 扣减账户余额 At
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}

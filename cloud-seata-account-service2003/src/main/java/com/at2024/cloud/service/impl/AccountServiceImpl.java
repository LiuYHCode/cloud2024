package com.at2024.cloud.service.impl;

import com.at2024.cloud.mapper.AccountMapper;
import com.at2024.cloud.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lyh
 * @date 2024-08-11 19:08:56
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, Long money) {
        log.info("------->account-service中扣减账户余额开始");
        accountMapper.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}

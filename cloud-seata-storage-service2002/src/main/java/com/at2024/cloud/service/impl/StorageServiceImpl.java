package com.at2024.cloud.service.impl;

import com.at2024.cloud.mapper.StorageMapper;
import com.at2024.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lyh
 * @date 2024-08-11 19:03:10
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}

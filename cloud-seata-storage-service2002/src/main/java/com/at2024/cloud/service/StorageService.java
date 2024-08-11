package com.at2024.cloud.service;

/**
 * @author lyh
 * @date 2024-08-11 19:02:15
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}

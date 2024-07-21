package com.at2024.cloud.service;

import com.at2024.cloud.entities.Pay;

import java.util.List;

/**
 * @author lyh
 * @date 2024-07-14 18:16:37
 */
public interface PayService {
    public int insert(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);
    public Pay getById(Integer id);
    public List<Pay> getAll();
}

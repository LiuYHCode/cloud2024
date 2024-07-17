package com.at2024.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lyh
 * @date 2024-07-14 18:36:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {

    private Integer id;
    /**
     * 支付流水号
     */
    private String payNo;
    /**
     * 订单流水号
     */
    private String orderNo;
    /**
     * 用户账号ID
     */
    private Integer userId;
    /**
     * 交易金额
     */
    private BigDecimal amount;
}

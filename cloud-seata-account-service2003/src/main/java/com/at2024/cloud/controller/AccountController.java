package com.at2024.cloud.controller;

import com.at2024.cloud.resp.ResultData;
import com.at2024.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyh
 * @date 2024-08-11 19:06:08
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money){
        accountService.decrease(userId,money);
        return ResultData.success("扣减账户余额成功！");
    }
}

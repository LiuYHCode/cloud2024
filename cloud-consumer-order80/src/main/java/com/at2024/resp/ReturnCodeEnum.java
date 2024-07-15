package com.at2024.resp;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author lyh
 * @date 2024-07-14 21:53:19
 */
@Getter
public enum ReturnCodeEnum {
    //1.举值
    RC999("999","操作xxx失败"),
    RC200("200","success"),
    RC201("201","服务开启降级保护，请稍后在试"),
    RC401("401","匿名用户访问无权限资源时的异常"),
    RC404("404","404页面找不到的异常"),
    RC500("500","服务器内部错误");

    private final String code;
    private final String message;

    //2.构造
    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    //3.遍历
    //3.1传统版
    public static ReturnCodeEnum getReturnCodeEnumV1(String code) {
        for (ReturnCodeEnum element : ReturnCodeEnum.values()) {
            if (element.getCode().equalsIgnoreCase(code)) {
                return element;
            }
        }
        return null;
    }
    //3.2流式计算版
    public static ReturnCodeEnum getReturnCodeEnumV2(String code) {
        return Arrays.stream(ReturnCodeEnum.values())
                     .filter(x -> x.getCode().equalsIgnoreCase(code))
                     .findFirst()
                     .orElse(null);
    }
}

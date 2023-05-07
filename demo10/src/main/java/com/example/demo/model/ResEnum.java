package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ResEnum {
    PAY_Success(200,"pay_success"),
    LOGIN_SUCCESS(200,"loginsuccess"),
    UserNotFind(400,"UserNotFindOrUserIsEmpty"),
    SELL_TOOMUCH(400,"超卖"),
    TIME_ISNOTNOW(403,"现在不是支付时间"),
    CANNOT_SEC_SECOND(400,"不能重复秒杀"),

    UPDATE_T_ORDER_ERROR(400,"减库存失败"),

    SUCCESS( 200,"Success" ),
     ERROR(400, "错误"),

     LOGIN_ERROR(500,"登录出错"),
    PAY_ERROR(500,"支付失败");

    private final Integer code;
    private final String message;
}

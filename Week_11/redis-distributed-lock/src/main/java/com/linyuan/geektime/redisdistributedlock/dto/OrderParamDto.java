package com.linyuan.geektime.redisdistributedlock.dto;



import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author linyuan
 * @desc:描述
 */
@Data
@ToString
public class OrderParamDto {

    @NotNull
    @Min(value = 1, message = "productId 必须大于0")
    private Integer productId;

    @NotNull
    private OpCode type;

    @Min(value = 1, message = "num 必须大于0")
    private Integer num;
}
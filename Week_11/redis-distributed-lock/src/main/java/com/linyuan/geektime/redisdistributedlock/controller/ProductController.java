package com.linyuan.geektime.redisdistributedlock.controller;

import com.linyuan.geektime.commonlib.api.BaseResponse;
import com.linyuan.geektime.redisdistributedlock.dto.OrderParamDto;
import com.linyuan.geektime.redisdistributedlock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linyuan
 * @desc:描述
 */
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/order")
    public BaseResponse order(@RequestBody @Validated OrderParamDto orderParamDto){
        productService.order(orderParamDto);
        return BaseResponse.Ok();
    }
}
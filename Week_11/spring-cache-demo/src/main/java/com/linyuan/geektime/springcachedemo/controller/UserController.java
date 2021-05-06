package com.linyuan.geektime.springcachedemo.controller;

import com.linyuan.geektime.commonlib.api.BaseResponse;
import com.linyuan.geektime.springcachedemo.domain.UserPO;
import com.linyuan.geektime.springcachedemo.service.UserServiceV1;
import com.linyuan.geektime.springcachedemo.service.UserServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @Author linyuan
 * @desc:描述
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceV2")
    private UserServiceV2 userService;

    @PostMapping(path = "/add")
    public BaseResponse save(@RequestBody UserPO userPO){
        return BaseResponse.Ok(userService.save(userPO));
    }

    @GetMapping(path = "/{id}")
    public BaseResponse getUserById(@PathVariable(name = "id") Integer id){
        return BaseResponse.Ok(userService.getByUserId(id));
    }

    @PostMapping(path = "/{id}")
    public BaseResponse updateUser(@RequestBody UserPO userPO){
        userService.update(userPO);
        return BaseResponse.Ok();
    }

    @DeleteMapping(path = "/{id}")
    public BaseResponse deleteUser(@PathVariable(name = "id") Integer userId){
        userService.delete(userId);
        return BaseResponse.Ok();
    }
}
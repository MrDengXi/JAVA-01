package com.linyuan.geektime.dubbohmilytccdemo.service;


import com.linyuan.geektime.dubbohmilytccapi.Account;
import com.linyuan.geektime.dubbohmilytccapi.OrderService;
import com.linyuan.geektime.dubbohmilytccdemo.bussiness.TransferBusiness;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author linyuan
 * @desc:描述
 */
@DubboService(version = "1.0.0", retries = 0)
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TransferBusiness transferBusiness;

    @Override
    public void transfer(Account from, long amount, Account to) {
        log.info("transfer {}-{} money from {} to {}", amount, from.getType(), from.getId(), to.getId());
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public void transfer() {
        transferBusiness.transferA();
        //transferBusiness.transferB();
    }

    //@Transactional(rollbackFor = Exception.class)
    public boolean confirm(){
        transferBusiness.confirmA();
        //transferBusiness.confirmB();
        return true;
    }

    //@Transactional(rollbackFor = Exception.class)
    public boolean cancel(){
        transferBusiness.cancelA();
        //transferBusiness.cancelB();
        return true;
    }
}
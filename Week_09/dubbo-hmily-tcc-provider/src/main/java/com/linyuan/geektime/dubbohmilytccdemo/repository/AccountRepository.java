package com.linyuan.geektime.dubbohmilytccdemo.repository;

import com.linyuan.geektime.dubbohmilytccdemo.entity.AccountPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author linyuan
 * @desc:描述
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountPO, Long> {

    AccountPO findAccountPOByUserIdAndAccountType(Long userId, Integer accountType);

    List<AccountPO> findAllByUserId(Long userId);
}

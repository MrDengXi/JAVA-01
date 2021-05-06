package com.linyuan.geektime.dubbohmilytccdemo.repository;

import com.linyuan.geektime.dubbohmilytccdemo.entity.TransactionPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author linyuan
 * @desc:描述
 */
@Repository
public interface TransactionRepository extends JpaRepository<TransactionPO, Long> {

    TransactionPO findFirstByUserId(Long userId);
}

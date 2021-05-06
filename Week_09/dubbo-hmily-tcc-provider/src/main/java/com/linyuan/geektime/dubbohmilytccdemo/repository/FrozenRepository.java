package com.linyuan.geektime.dubbohmilytccdemo.repository;

import com.linyuan.geektime.dubbohmilytccdemo.entity.FrozenPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author linyuan
 * @desc:描述
 */
@Repository
public interface FrozenRepository extends JpaRepository<FrozenPO,Long> {

    void deleteAllByTransactionId(long transactionId);

    FrozenPO findFirstByTransactionId(long transactionId);
}

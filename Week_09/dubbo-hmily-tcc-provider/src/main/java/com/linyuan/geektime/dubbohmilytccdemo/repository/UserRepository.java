package com.linyuan.geektime.dubbohmilytccdemo.repository;

import com.linyuan.geektime.dubbohmilytccdemo.entity.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author linyuan
 * @desc:描述
 */
@Repository
public interface UserRepository extends JpaRepository<UserPO, Long> {
}

package com.linyuan.mysql01.service;

import com.linyuan.mysql01.bean.Orders;
import com.linyuan.mysql01.bean.Patient;
import com.linyuan.mysql01.dao.OrdersMapper;
import com.linyuan.mysql01.dao.PatientMapper;
import com.linyuan.mysql01.utils.SnowflakeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author DengXi
 * @Date 2021/3/7 11:09 下午
 * @desc:描述
 */
@Service
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;

    private static volatile Long time = 0L;

    public int insertByThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000000));
        SnowflakeId snowflakeId = new SnowflakeId(1, 31);
        for (int i = 1; i <= 100000; i++) {
            threadPoolExecutor.execute(() -> {
                long startTime1 = System.currentTimeMillis();
                for (int i1 = 1; i1 <= 1000; i1++) {
                    Patient patient = new Patient();
                    patient.setId(snowflakeId.nextId());
                    patient.setStoreId(snowflakeId.nextId());
                    Long phone = 0L;
                    phone += 13*1000000000L;
                    phone += (i1 % 2 == 0 ? 7 :5) * 100000000L;
                    Random random = new Random();
                    phone += random.nextInt(99999999);
                    patient.setMobile(String.valueOf(phone));
                    patient.setName("张三"+ i1);
                    patient.setIdNo(String.valueOf(snowflakeId.nextId()));
                    patient.setGender(i1%2 == 1?0:1);
                    patient.setAges(new Random().nextInt(20) + 19);
                    patient.setPatientType(i1%2 == 1?1:0);
                    patient.setCreateTime(LocalDateTime.now());
                    patientMapper.insert(patient);
                }
            });
        }
        return 1;
    }
}

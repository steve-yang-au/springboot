package com.steve.boot.launch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RedisLockTest {
    @Resource
    private RedisLockRegistry redisLockRegistry;

    @Test
    public void updateUser() {
        String lockKey = "lock_user";
        Lock lock = redisLockRegistry.obtain(lockKey);  //获取锁资源
        try {
            lock.lock();   //加锁
            System.out.println("ok...");
            //这里写需要处理业务的业务代码
        } finally {
            lock.unlock();   //释放锁
        }
    }

}

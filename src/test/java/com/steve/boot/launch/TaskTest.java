package com.steve.boot.launch;

import com.steve.boot.launch.config.task.AsyncCallBackTask;
import com.steve.boot.launch.config.task.AsyncExecutorTask;
import com.steve.boot.launch.config.task.AsyncTask;
import com.steve.boot.launch.config.task.SyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {
    @Resource
    private SyncTask task;
    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private AsyncCallBackTask asyncCallBackTask;

    @Autowired
    private AsyncExecutorTask asyncExecutorTask;



    @Test
    public void testSyncTasks() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    @Test
    public void testAsyncTasks() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }

    @Test
    public void testAsyncCallbackTask() throws Exception {
        long start = currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.doTaskOneCallback();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallback();
        Future<String> task3 = asyncCallBackTask.doTaskThreeCallback();

        // 三个任务都调用完成，退出循环等待
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            sleep(1000);
        }

        long end = currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }


    @Test
    public void testAsyncExecutorTask() throws Exception {
        asyncExecutorTask.doTaskOneCallback();
        asyncExecutorTask.doTaskTwoCallback();
        asyncExecutorTask.doTaskThreeCallback();

        sleep(30 * 1000L);
    }
}
package com.yangnan.mall.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        // 需要适配类和Thread建立关联
        FutureTask<String> futureTask = new FutureTask<String>(myCallable);
        Thread thread = new Thread(futureTask, "CallableDemo");
        thread.start();
        String str = futureTask.get();
        System.out.println(str);
    }
    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("MyCallable.call");
            return "abc";
        }
    }
}

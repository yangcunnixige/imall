package com.yangnan.mall.test;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("aaaaa");
        }
    }
}
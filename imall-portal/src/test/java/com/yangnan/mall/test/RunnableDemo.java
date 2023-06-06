package com.yangnan.mall.test;


public class RunnableDemo {
    public static void main(String[] args) {
        newThread thread = new newThread();
        new Thread(thread).start();
    }

    static class newThread implements Runnable {
        @Override
        public void run() {
            System.out.println("bbbb");
        }
    }
}
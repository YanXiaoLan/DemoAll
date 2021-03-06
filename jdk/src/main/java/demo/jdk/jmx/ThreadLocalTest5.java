/**
 * sharemer.com Inc.
 * Copyright (c) 2009-2019 All Rights Reserved.
 */
package demo.jdk.jmx;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 *
 * @author sunqinwen
 * @version \: ThreadLocalTest5.java,v 0.1 2019-02-22 18:02 
 *
 */
public class ThreadLocalTest5 {

    private static ThreadLocal<Integer> tl = new TransmittableThreadLocal<>();

    public static void main(String[] args) {

        new Thread(() -> {

            String mainThreadName = "main_01";

            tl.set(1);

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(1), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            sleep(1L); //确保上面的会在tl.set执行之前执行
            tl.set(2); // 等上面的线程池第一次启用完了，父线程再给自己赋值

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(2), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

        }).start();


        new Thread(() -> {

            String mainThreadName = "main_02";

            tl.set(3);

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之前(3), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            sleep(1L); //确保上面的会在tl.set执行之前执行
            tl.set(4); // 等上面的线程池第一次启用完了，父线程再给自己赋值

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            new Thread(() -> {
                sleep(1L);
                System.out.println(String.format("本地变量改变之后(4), 父线程名称-%s, 子线程名称-%s, 变量值=%s", mainThreadName, Thread.currentThread().getName(), tl.get()));
            }).start();

            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

        }).start();

    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

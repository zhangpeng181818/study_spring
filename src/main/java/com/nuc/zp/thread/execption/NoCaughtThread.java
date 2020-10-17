package com.nuc.zp.thread.execption;

/**
 * 当单线程的程序发生一个未捕获的异常时我们可以采用try....catch进行异常的捕获，
 * 但是在多线程环境中，线程抛出的异常是不能用try....catch捕获的，
 * 这样就有可能导致一些问题的出现，比如异常的时候无法回收一些系统资源，或者没有关闭当前的连接等等。
 *
 *
 *  可以看到在多线程中通过try....catch试图捕获线程的异常是不可取的。
 *
 *
 *
 * Thread的run方法是不抛出任何检查型异常的，但是它自身却可能因为一个异常而被中止，导致这个线程的终结。
 * 首先介绍一下如何在线程池内部构建一个工作者线程，如果任务抛出了一个未检查异常，那么它将使线程终结，
 * 但会首先通知框架该现场已经终结。然后框架可能会用新的线程来代替这个工作线程，也可能不会，因为线程池正在关闭，
 * 或者当前已有足够多的线程能满足需要。当编写一个向线程池提交任务的工作者类线程类时，或者调用不可信的外部代码时
 * （例如动态加载的插件），使用这些方法中的某一种可以避免某个编写得糟糕的任务或插件不会影响调用它的整个线程
 */
public class NoCaughtThread {
    public static void main(String[] args) {
        try
        {
            Thread thread = new Thread(new Task());
            thread.start();
        }
        catch (Exception e) {
            System.out.println("==Exception: " + e.getMessage());
        }
    }


}

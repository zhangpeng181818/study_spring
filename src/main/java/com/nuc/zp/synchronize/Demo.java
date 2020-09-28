package com.nuc.zp.synchronize;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁
 * 偏向锁在Java 6之后是默认启用的，但在应用程序启动几秒钟之后才激活，
 * 可以使用 -XX:BiasedLockingStartupDelay=0 参数关闭延迟，如果确定应用程序中所有锁通常情况下处于竞争 状态，
 * 可以通过 XX:-UseBiasedLocking=false 参数关闭偏向锁。
 *
 * java.lang.Object object internals:
 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
 *       0     4        (object header)                           68 68 0c 0c (01101000 01101000 00001100 00001100) (202139752)
 *       4     4        (object header)                           00 70 00 00 (00000000 01110000 00000000 00000000) (28672)
 *       8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
 *      12     4        (loss due to the next object alignment)
 * Instance size: 16 bytes
 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
 *
 *
 *
 * java.lang.Object object internals:
 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
 *       0     4        (object header)                           05 98 9c 9e (00000101 10011000 10011100 10011110) (-1633904635)
 *       4     4        (object header)                           a0 7f 00 00 (10100000 01111111 00000000 00000000) (32672)
 *       8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
 *      12     4        (loss due to the next object alignment)
 * Instance size: 16 bytes
 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
 *
 */
public class Demo {

    static Object object = new Object();

    public static void main(String[] args) {


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (object) {
                    System.out.println(ClassLayout.parseInstance(object).toPrintable());
                }
            }
        }).start();
    }
}

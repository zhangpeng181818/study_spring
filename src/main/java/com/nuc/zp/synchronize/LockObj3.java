package com.nuc.zp.synchronize;

import org.openjdk.jol.info.ClassLayout;

public class LockObj3 {

    private int x;
    private boolean y;

    public static void main(String[] args) {
        LockObj3 lockObj = new LockObj3();
        System.out.println(lockObj.hashCode());
        System.out.println(Integer.toHexString(lockObj.hashCode()));
        System.out.println(ClassLayout.parseInstance(lockObj).toPrintable());
    }

    /**
     *   824909230
     *   312b1dae
     *
     *   开启指针压缩：
     *
     *   com.nuc.zp.synchronize.LockObj3 object internals:
     *  OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
     *       0     4           (object header)                           01 ae 1d 2b (00000001 10101110 00011101 00101011) (723365377)
     *       4     4           (object header)                           31 00 00 00 (00110001 00000000 00000000 00000000) (49)
     *       8     4           (object header)                           05 c1 00 f8 (00000101 11000001 00000000 11111000) (-134168315)
     *      12     4       int LockObj3.x                                0
     *      16     1   boolean LockObj3.y                                false
     *      17     7           (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 7 bytes external = 7 bytes total
     *
     */



    /**
     *
     *  824909230
     *  312b1dae
     *  未开启指针压缩：
     *
     *  com.nuc.zp.synchronize.LockObj3 object internals:
     *  OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
     *       0     4           (object header)                           01 ae 1d 2b (00000001 10101110 00011101 00101011) (723365377)
     *       4     4           (object header)                           31 00 00 00 (00110001 00000000 00000000 00000000) (49)
     *       8     4           (object header)                           28 e0 ca 9c (00101000 11100000 11001010 10011100) (-1664425944)
     *      12     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *      16     4       int LockObj3.x                                0
     *      20     1   boolean LockObj3.y                                false
     *      21     3           (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
     *
     */

}

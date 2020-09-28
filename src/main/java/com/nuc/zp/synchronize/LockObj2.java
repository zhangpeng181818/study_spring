package com.nuc.zp.synchronize;

import org.openjdk.jol.info.ClassLayout;

public class LockObj2 {

    private int x;
    private boolean y;

    public static void main(String[] args) {
        LockObj2 lockObj = new LockObj2();
        System.out.println(ClassLayout.parseInstance(lockObj).toPrintable());
    }

    /**
     *
     *   开启指针压缩：
     *
         com.nuc.zp.synchronize.LockObj2 object internals:
         OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
         0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         8     4           (object header)                           05 c1 00 f8 (00000101 11000001 00000000 11111000) (-134168315)
         12     4       int LockObj2.x                                0
         16     1   boolean LockObj2.y                                false
         17     7           (loLockObj2ss due to the next object alignment)
         Instance size: 24 bytes
         Space losses: 0 bytes internal + 7 bytes external = 7 bytes total
     */



    /**
     *
     *  未开启指针压缩：
     *
     *  com.nuc.zp.synchronize.LockObj2 object internals:
     *  OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
     *       0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4           (object header)                           28 10 ec 08 (00101000 00010000 11101100 00001000) (149688360)
     *      12     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *      16     4       int LockObj2.x                                0
     *      20     1   boolean LockObj2.y                                false
     *      21     3           (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
     *
     *
     */

}

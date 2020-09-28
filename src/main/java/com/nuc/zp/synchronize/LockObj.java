package com.nuc.zp.synchronize;

import org.openjdk.jol.info.ClassLayout;

public class LockObj {

    private int x;

    public static void main(String[] args) {
        LockObj lockObj = new LockObj();
        System.out.println(ClassLayout.parseInstance(lockObj).toPrintable());
    }

    /**
     *
         com.nuc.zp.synchronize.LockObj object internals:
         OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         8     4        (object header)                           05 c1 00 f8 (00000101 11000001 00000000 11111000) (-134168315)
         12     4    int LockObj.x                                 0
         Instance size: 16 bytes
         Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     */

    /**
     *
     *  com.nuc.zp.synchronize.LockObj object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           28 00 49 11 (00101000 00000000 01001001 00010001) (289996840)
     *      12     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *      16     4    int LockObj.x                                 0
     *      20     4        (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     *
     *
     */

}

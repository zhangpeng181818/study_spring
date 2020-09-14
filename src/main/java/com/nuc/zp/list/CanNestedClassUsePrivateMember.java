package com.nuc.zp.list;

public class CanNestedClassUsePrivateMember {
     int whatever;

    class Inner {
        void access() {
            System.out.println(whatever);
        }
    }

    public static void main(String[] args) {
        new CanNestedClassUsePrivateMember().new Inner().access();
    }
}
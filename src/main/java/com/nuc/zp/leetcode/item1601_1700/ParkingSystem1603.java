package com.nuc.zp.leetcode.item1601_1700;

public class ParkingSystem1603 {

    int big = 0;
    int medium = 0;
    int small = 0;

    public ParkingSystem1603(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;

    }

    public boolean addCar(int carType) {
        if (carType == 1 && big > 0) {
            big--;
            return true;
        } else if (carType == 2 && medium > 0) {
            medium--;
            return true;
        } else if (carType == 3 && small > 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem1603 parkingSystem1603 = new ParkingSystem1603(1,1,0);
        System.out.println(parkingSystem1603.addCar(1));
        System.out.println(parkingSystem1603.addCar(2));
        System.out.println(parkingSystem1603.addCar(3));
        System.out.println(parkingSystem1603.addCar(1));
    }
}
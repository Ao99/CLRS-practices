package com.company;

public class Main {

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7, 13, -3, 25, 20, -3, -16, -23, 18, 20, -7, 25, 20, -3, -16, 20, -7, 12, -5, -22, 15, -4};
        SubArrayIndexes sub = findMaxSubArrayLinear(a);
        printSubArray(a, sub);

    }

    public static SubArrayIndexes findMaxSubArrayLinear(int[] a) {
        int max = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        int tempLow = 0;
        int low = 0;
        int high = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            if (sum > 0) {
                sum += a[i];
            } else {
                sum = a[i];
                tempLow = i;
            }
            if (sum > max) {
                max = sum;
                low = tempLow;
                high = i;
            }
        }
        return new SubArrayIndexes(low, high, max);
    }

    public static void printSubArray(int[] a, SubArrayIndexes sub) {
        System.out.println("The max subarray contains length is " + (sub.getHigh() - sub.getLow() + 1));
        for (int i = sub.getLow(); i <= sub.getHigh(); i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

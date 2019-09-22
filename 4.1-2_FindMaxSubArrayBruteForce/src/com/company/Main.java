package com.company;

public class Main {

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7,13, -3, 25, 20, -3, -16,-23, 18, 20, -7,25, 20, -3, -16,20, -7, 12, -5, -22, 15, -4};
        SubArrayIndexes sub = findMaxSubArrayBruteForce(a, 0, a.length - 1);
        printSubArray(a, sub);
    }

    public static SubArrayIndexes findMaxSubArrayBruteForce(int[] a, int low, int high) {
        int maxSum = Integer.MIN_VALUE;
        int maxLow = 0;
        int maxHigh = 0;
        for (int i = low; i <= high; i++) {
            int sum = 0;
            for (int j = i; j <= high; j++) {
                sum += a[j];
                if (sum > maxSum) {
                    maxLow = i;
                    maxHigh = j;
                    maxSum = sum;
                }
            }
        }
        return new SubArrayIndexes(maxLow,maxHigh, maxSum);
    }

    public static void printSubArray(int[] a, SubArrayIndexes sub) {
        System.out.println("The max subarray contains length is " + (sub.getHigh() - sub.getLow() + 1));
        for (int i = sub.getLow(); i <= sub.getHigh(); i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

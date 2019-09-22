package com.company;

public class Main {

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7,13, -3, 25, 20, -3, -16,-23, 18, 20, -7,25, 20, -3, -16,20, -7, 12, -5, -22, 15, -4};
        SubArrayIndexes sub = findMaxSubArray(a, 0, a.length - 1);
        printSubArray(a, sub);

    }

    public static SubArrayIndexes findMaxCrossingSubArray(int[] a, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new SubArrayIndexes(maxLeft, maxRight, leftSum + rightSum);
    }

    public static SubArrayIndexes findMaxSubArray(int[] a, int low, int high) {
        if (low == high) {
            return new SubArrayIndexes(low, high, a[low]);
        } else {
            int mid = (low + high) / 2;
            SubArrayIndexes left = findMaxSubArray(a, low, mid);
            SubArrayIndexes right = findMaxSubArray(a, mid + 1, high);
            SubArrayIndexes cross = findMaxCrossingSubArray(a, low, mid, high);
            if (left.getSum() >= right.getSum() && left.getSum() >= cross.getSum()) {
                return left;
            } else if (right.getSum() >= left.getSum() && right.getSum() >= cross.getSum()) {
                return right;
            } else {
                return cross;
            }
        }
    }

    public static void printSubArray(int[] a, SubArrayIndexes sub) {
        System.out.println("The max subarray contains length is " + (sub.getHigh() - sub.getLow() + 1));
        for (int i = sub.getLow(); i <= sub.getHigh(); i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

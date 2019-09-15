package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {13, -25, 25, 18, 100, 27, -1, -9, 19, 33, 15, -16, 8, -15, -16, 18, 26, 27, 2, 25, 3};
        System.out.println(honorsPolyEval(array, 5));
        System.out.println(naivePolyEval(array, 5));
    }

    public static Integer honorsPolyEval(int[] a, int x) {
        int y = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            y = a[i] + x * y;
        }
        return y;
    }

    public static Integer naivePolyEval(int[] a, int x) {
        int y = 0;
        for (int i = 0; i < a.length; i++) {
            int p = 1;
            for (int j = 0; j < i; j++) {
                p *= x;
            }
            y += a[i] * p;
        }
        return y;
    }
}

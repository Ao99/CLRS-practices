package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 1, 0, 1};
        int[] b = {0, 1, 1, 1, 0, 1, 1};
        int[] c = addBinary(a, b);
        System.out.println(Arrays.toString(c));
    }

    public static int[] addBinary(int[] a, int[] b) {
        int[] c = new int[a.length + 1];
        int carry = 0;
        for (int i = 0; i < a.length - 1; i++) {
            c[i] = (a[i] + b[i] + carry) % 2;
            carry = (a[i] + b[i] + carry) / 2;
        }
        c[a.length] = carry;
        return c;
    }
}

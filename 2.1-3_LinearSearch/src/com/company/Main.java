package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {13, -25, 25, 18, 100, 27, -1, -9, 19, 33, 15, -16, 8, -15, -16, 18, 26, 27, 2, 25, 3};
        System.out.println(linearSearch(array, 19));
        System.out.println(linearSearch(array, 1919));
    }

    public static Integer linearSearch(int[] a, int v) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v) {
                return i;
            }
        }
        return null;
    }
}

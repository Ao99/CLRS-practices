package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 9, 2, 1, -1, 6, -13};
        insertionSort(array,array.length-1);
        System.out.println(Arrays.toString(array));

//        List<Integer> arrayList = Arrays.asList(4, 11, 9, 2, 1, -1, 6, -13);
//        insertionSort(arrayList);
//        printList(arrayList);
    }

    public static void insertionSort(int[] a, int n) {
        if (n > 0) {
            insertionSort(a, n - 1);
            insert(a, n);
        }
    }

    public static void insert(int[] a, int n) {
        int key = a[n];
        int i = n - 1;
        while (i >= 0 && a[i] > key) {
            a[i + 1] = a[i];
            i--;
        }
        a[i + 1] = key;
    }
}

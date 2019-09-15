package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 9, 2, 1, -1, 6, -13};
        insertionSort(array);
        System.out.println(Arrays.toString(array));

        List<Integer> arrayList = Arrays.asList(4, 11, 9, 2, 1, -1, 6, -13);
        insertionSort(arrayList);
        printList(arrayList);
    }

    public static void insertionSort(int[] a) {
        if (a.length > 2) {
            for (int j = 1; j < a.length; j++) {
                int key = a[j];
                int i = j - 1;
//                while (i >= 0 && a[i] < key) {
//                non-increasing order
                while (i >= 0 && a[i] > key) {

                    a[i + 1] = a[i];
                    i--;
                }
                a[i + 1] = key;
            }
        }
    }

    public static void insertionSort(List<Integer> a) {
        if (a.size() > 2) {
            for (int j = 1; j < a.size(); j++) {
                int key = a.get(j);
                int i = j - 1;
//                while (i >= 0 && a.get(i) < key) {
//                non-increasing order
                while (i >= 0 && a.get(i) > key) {

                    a.set(i + 1, a.get(i));
                    i--;
                }
                a.set(i + 1, key);
            }
        }
    }

    public static void printList(List<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }
}

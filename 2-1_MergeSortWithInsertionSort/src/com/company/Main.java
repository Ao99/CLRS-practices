package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {13, -25, 25, 18, 100, 27, -1, -9, 19, 33, 15, -16, 8, -15, -16, 18, 26, 27, 2, 25, 3};
        mergeSort(array, 4, 0, array.length - 1);
//        insertionSort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));


    }

    public static void mergeSort(int[] a, int k, int low, int high) {
        System.out.println("Merge");
        if (low < high) {
            if (high - low + 1 > k) {
                int mid = (low + high) / 2;
                mergeSort(a, k, low, mid);
                mergeSort(a, k, mid + 1, high);
                merge(a, low, mid, high);
            } else {
                insertionSort(a, low, high);
            }
        }

    }

    public static void merge(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = a[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = a[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        for (int k = low; k <= high; k++) {
            if (i > n1 - 1) {
                a[k] = right[j];
                j++;
            } else if (j > n2 - 1) {
                a[k] = left[i];
                i++;
            } else if (left[i] > right[j]) {
                a[k] = right[j];
                j++;
            } else {
                a[k] = left[i];
                i++;
            }
        }


    }

    public static void insertionSort(int[] a, int low, int high) {
        System.out.println("Insertion");
        int i = high - 1;
        if (i - low > 0) {
            insertionSort(a, low, high - 1);
        }
        int key = a[high];
        while (i >= 0 && a[i] > key) {
            a[i + 1] = a[i];
            i--;
        }
        a[i + 1] = key;
    }
}

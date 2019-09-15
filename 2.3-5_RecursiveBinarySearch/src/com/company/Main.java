package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 9, 2, 1, -1, 6, -13};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch(array, 1,0,array.length-1));
        System.out.println(binarySearch(array, 6,0,array.length-1));
    }

    public static Integer binarySearch(int[] a, int v, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < v) {
                return binarySearch(a, v, mid + 1, high);
            } else if (a[mid] > v) {
                return binarySearch(a, v, low, mid - 1);
            } else {
                return mid;
            }
        }
        return null;
    }

    public static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = a[q + 1 + j];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
        }
    }
}
package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {13, -25, 25, 18, 100, 27, -1, -9, 19, 33, 15, -16, 8};
//        mergeSort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));
        System.out.println(findTwoElementsBinarySearch(array, -10));
        System.out.println(findTwoElementsBinarySearch(array, 24));
        System.out.println(findTwoElementsBinarySearch(array, 125));
        System.out.println(findTwoElementsBinarySearch(array, -1000));

        System.out.println(findTwoElementsTwoPointers(array, -10));
        System.out.println(findTwoElementsTwoPointers(array, 24));
        System.out.println(findTwoElementsTwoPointers(array, 125));
        System.out.println(findTwoElementsTwoPointers(array, -1000));

    }

    public static boolean findTwoElementsBinarySearch(int[] a, int x) {
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length - 2; i++) {
            int key = x - a[i];
            if (binarySearch(a, key, i + 1, a.length - 1) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean findTwoElementsTwoPointers(int[] a, int x) {
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum > x) {
                right--;
            } else if (sum < x) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    //    merge without sentinels
    public static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = a[q + 1 + j];
        }
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
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
}

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = {13, -25, 25, 18, 100, 27, -1, -9, 19, 33, 15, -16, 8};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        List<Integer> arrayList = Arrays.asList(13, -25, 25, 18, 100, 27, -1, -9, 19, 33, 15, -16, 8);
        mergeSort(arrayList, 0, arrayList.size() - 1);
        printList(arrayList);
    }

    public static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void mergeSort(List<Integer> a, int p, int r) {
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

    public static void merge(List<Integer> a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            left.add(a.get(p + i));
        }
        for (int j = 0; j < n2; j++) {
            right.add(a.get(q + 1 + j));
        }
        left.add(Integer.MAX_VALUE);
        right.add(Integer.MAX_VALUE);
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (left.get(i) <= right.get(j)){
                a.set(k,left.get(i));
                i++;
            }else {
                a.set(k,right.get(j));
                j++;
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

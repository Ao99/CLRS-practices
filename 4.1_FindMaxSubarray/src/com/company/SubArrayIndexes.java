package com.company;

public class SubArrayIndexes {
    private int low;
    private int high;
    private int sum;

    public SubArrayIndexes(int low, int high, int sum) {
        this.low = low;
        this.high = high;
        this.sum = sum;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public int getSum() {
        return sum;
    }
}

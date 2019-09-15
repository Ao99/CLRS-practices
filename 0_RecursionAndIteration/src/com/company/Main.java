package com.company;

public class Main {

    public static void main(String[] args) {
//	    calculate factorial number
//      input must be no less than 1
        long a = factorialRecursive(5);
        System.out.println("a = " + a);
        long b = factorialIterative(5);
        System.out.println("b = " + b);
    }

    public static long factorialRecursive(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * factorialRecursive(number - 1);
        }
    }

    public static long factorialIterative(int number) {
        long factorialNumber = 1;
        for (int i = 1; i <= number; i++) {
            factorialNumber *= i;
        }
        return factorialNumber;
    }
}

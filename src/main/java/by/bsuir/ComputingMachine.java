package by.bsuir;

import java.util.Arrays;

public class ComputingMachine {
    public double task1(double x, double y) {
        return (1 + Math.pow(Math.sin(x+ y), 2))/(2 + Math.abs(x - 2*x/(1 + x*x*y*y))) + x;
    }

    public boolean task2(double x, double y) {
        if ((Math.abs(x) - 4) < 0 && y >=0 && y - 5 < 0) {
            return true;
        } else return Math.abs(x) - 6 < 0 && y + 3 <= 3 && y + 3 >= 0;
    }

    public int[] task4(int[] arr, int N) {
        int[] resArr = new int[N];
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (isPrime(arr[j])) {
                resArr[i] = j;
                i++;
            }
        }
        return resArr;
    }

    public double[][] task6(double[] arr, int size) {
        double[][] resultMatrix = new double[size][];
        for (int i = 0; i < size; i++) {
            resultMatrix[i] = new double[size];
        }
        for (int i = 0; i < size; i++) {
            assignValues(resultMatrix, arr, i);
        }
        return resultMatrix;
    }

    public double[][] task3(int a, int b, double h) {
        if (a > b) {return null;}
        int steps = (int) ((b-a)/h);
        double[][] res = new double[steps + 1][2];
        double x = a;
        for (int i = 0; i < steps + 1; i++) {
            res[i][0] = x;
            res[i][1] = Math.tan(x);
            x += h;
        }
        return res;
    }

    public double[] task7(double[] arr) {
        int size = arr.length;
        int i = 0;
        while (i < size - 1) {
            if (arr[i] > arr[i + 1]) {
                double temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i -= 1;
            } else {
                i+=1;
            }
            if (i == -1) {i = 0;}
        }
        return arr;
    }

    public int[] task8(double[] arrA, double[] arrB) {
        int lengthA = arrA.length;
        int lengthB = arrB.length;
        int[] insertPlaces = new int[lengthB];
        int i = 0;
        int j = 0;
        while (i < lengthA && j < lengthB) {
            if (arrA[i] <= arrB[j]) {
                i++;
            } else {
                insertPlaces[j] = i;
                j++;
            }
        }
        while (j < lengthB) {
            insertPlaces[j] = lengthA;
            j++;
        }
        return insertPlaces;
    }

    public int task5(int[] arr) {
        int size = arr.length;
        int[] sequenceSizes = new int[size];
        Arrays.fill(sequenceSizes, 1);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && sequenceSizes[i] < sequenceSizes[j] + 1) {
                    sequenceSizes[i] = sequenceSizes[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (sequenceSizes[i] > max) {
                max = sequenceSizes[i];
            }
        }
        return size - max;
    }

    private double[][] assignValues(double[][] matr, double[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            matr[i][j] = arr[(j + i) % arr.length];
        }
        return matr;
    }

    private boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
}

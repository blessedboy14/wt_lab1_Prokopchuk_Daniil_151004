package by.bsuir;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComputingMachine myComputingMachine = new ComputingMachine();
        Scanner sc = new Scanner(System.in);
        String answer = "";
        while (!Objects.equals(answer, "exit")) {
            System.out.print("Enter task number(1-9): ");
            answer = sc.nextLine();
            if (Objects.equals(answer, "exit")) {break;}
            try{
                if (Integer.parseInt(answer) > 0 && Integer.parseInt(answer) < 10) {
                    String taskFunctionName = "task" + answer;
                    Method callableMethod = Main.class.getDeclaredMethod(taskFunctionName, Scanner.class, ComputingMachine.class);
                    callableMethod.invoke(Main.class, sc, myComputingMachine);
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            sc.nextLine();
        }
    }

    protected static void task1(Scanner sc, ComputingMachine myComputingMachine) {
        System.out.println("task 1. Enter x, then y: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        System.out.println("task1 result: " + myComputingMachine.task1(x, y) + "\n");
    }

    protected static void task2(Scanner sc, ComputingMachine myComputingMachine) {
        System.out.println("Task 2");
        System.out.print("Enter x coordinate: ");
        double x = sc.nextDouble();
        System.out.print("Enter y coordinate: ");
        double y = sc.nextDouble();
        System.out.println(myComputingMachine.task2(x, y) + "\n");

    }

    protected static void task6(Scanner sc, ComputingMachine myComputingMachine) {
        System.out.println("task6");
        double[] arr = {1, 2, 3, 4, 5, 6};
        System.out.print("Base arr: ");
        for (double num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        double[][] res = myComputingMachine.task6(arr, 6);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    protected static void task4(Scanner sc, ComputingMachine myComputingMachine) {
        System.out.println("task4.");
        int[] arr = {1, 3, 7, 4, 8, 11, 14};
        int[] res = myComputingMachine.task4(arr, arr.length);
        System.out.println("base arr");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nPrimes positions");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println("\n");
    }

    protected static void task3(Scanner sc, ComputingMachine myComputingMachine) {
        System.out.print("Task 3. Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.print("Enter h: ");
        double h = sc.nextDouble();
        int steps = (int) ((b - a) / h);
        double[][] resDouble = myComputingMachine.task3(a, b, h);
        for (int i = 0; i < steps + 1; i++) {
            System.out.println("Argument " + resDouble[i][0] + " ,value " + resDouble[i][1]);
//        }
        }

    }

    protected static void task7(Scanner sc, ComputingMachine myComputingMachine) {
        System.out.println("\nTask7(sort)\nBase arr");
        double[] arr = {5.4, 3.2, 1.8, 4.6, 2.1, 0.8};
        for (double num: arr) {
            System.out.print(num + " ");
        }
        arr = myComputingMachine.task7(arr);
        System.out.println("Result: ");
        for (double num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    protected static void task8(Scanner sc, ComputingMachine myComputingMachine) {
        System.out.println("Task 8");
        double[] arrA = {1.5, 2.5, 4.0, 5.0, 7.0};
        double[] arrB = {1.0, 3.0, 4.5, 6, 10, 12};
        printArr(arrA);
        System.out.println();
        printArr(arrB);
        System.out.println();
        int[] res = myComputingMachine.task8(arrA, arrB);
        System.out.print("Result: ");
        printArr(res);
        System.out.println();
    }

    protected static void task5(Scanner sc, ComputingMachine myComputingMachine) {
        System.out.println("Task 5");
        int[] arr = {5, 2, 8, 6, 3, 6, 9, 7, 15, 11, 16, 17};
        System.out.print("Array: ");
        printArr(arr);
        System.out.println();
        int res = myComputingMachine.task5(arr);
        System.out.println("Min number of pop items is: " + res + "\n");
    }

    protected static void task9(Scanner sc, ComputingMachine myComputingMachine) {
        Basket myBasket = new Basket(new Ball[]{new Ball(9, Color.GREEN), new Ball(1, Color.BLUE),
                new Ball(13, Color.RED), new Ball(2, Color.BLUE), new Ball(10)});
        System.out.println("Weight of all balls is: " + myBasket.countBallsWeight());
        System.out.println("Number of blue balls is: " + myBasket.countBlueBalls());
    }

    private static void printArr(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
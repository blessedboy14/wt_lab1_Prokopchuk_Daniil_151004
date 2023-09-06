package by.bsuir;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    ComputingMachine computingMachine;

    @BeforeEach
    void setUp() {
        computingMachine = new ComputingMachine();
    }

    @Test
    void task1TestWorkPart1() {
        double expected = 0.5;
        double x = 0;
        double y = 0;
        double actual = computingMachine.task1(x, y);
        assertEquals(expected, actual, 10e-8);
    }

    @Test
    void task1TestWorkPart2() {
        double expected = -0.5;
        double x = -1;
        double y = 1;
        double actual = computingMachine.task1(x, y);
        assertEquals(expected, actual, 10e-8);
    }

    @Test
    void task2TestMatchPoint() {
        double x = 0;
        double y = 0;
        assertTrue(computingMachine.task2(x, y));
    }

    @Test
    void task2TestNoMatchPoint() {
        double x = 5;
        double y = 3;
        assertFalse(computingMachine.task2(x, y));
    }

    @Test
    void task3TestSolving() {
        int a = 0;
        int b = 1;
        double h = 0.5;
        double[] expected = {0, 0.5463, 1.5574};
        double[][] res = computingMachine.task3(a, b, h);
        double[] actual = new double[res.length];
        for (int i = 0; i < res.length; i++) {
            actual[i] = res[i][1];
        }
        assertArrayEquals(expected, actual, 10e-4);
    }

    @Test
    void task3TestWrongData() {
        int a = 1;
        int b = 0;
        double h = 0.5;
        double[][] actual = computingMachine.task3(a,b,h);
        assertNull(actual);
    }

    @Test
    void task4TestValidData() {
        int[] array = {1, 3, 7, 4, 8, 11, 14};
        int[] expected = {1, 2, 5, 0, 0, 0, 0};
        int[] actual = computingMachine.task4(array, 7);
        assertArrayEquals(expected, actual);
    }

    @Test
    void task4TestCloseToFailData() {
        int[] array = {1};
        int[] expected = {0};
        int[] actual = computingMachine.task4(array, 1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void task5TestValidData1() {
        int[] sequence = {1, 3, 5, 7};
        int expected = 0;
        int actual = computingMachine.task5(sequence);
        assertEquals(expected, actual);
    }

    @Test
    void task5TestValidData2() {
        int[] sequence = {1, 3, 2, 1, 7};
        int expected = 2;
        int actual = computingMachine.task5(sequence);
        assertEquals(expected, actual);
    }

    @Test
    void task6TestSmallData() {
        double[] arr = {1, 2, 3};
        double[][] expected = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        double[][] actual = computingMachine.task6(arr, 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    void task7TestOnUnsortedArr() {
        double[] arr = {1.0, 2, -4, 7, 3, 11, 14, 10};
        double[] expected = {-4, 1.0, 2, 3, 7, 10, 11, 14};
        double[] actual = computingMachine.task7(arr);
        assertArrayEquals(expected, actual, 10e-2);
    }

    @Test
    void task7TestOnSortedArr() {
        double[] arr = {1.0, 2, 3, 10, 14, 18};
        double[] expected = {1.0, 2, 3, 10, 14, 18};
        double[] actual = computingMachine.task7(arr);
        assertArrayEquals(expected, actual, 10e-2);
    }

    @Test
    void task8TestOnValidData() {
        double[] arrA = {1, 4, 5, 5, 7};
        double[] arrB = {2, 3, 10, 11};
        int[] expected = {1, 1, 5, 5};
        int[] actual = computingMachine.task8(arrA, arrB);
        assertArrayEquals(expected, actual);
    }

    @Test
    void task8TestOnWeirdData() {
        double[] arrA = {1, 2, 3, 4};
        double[] arrB = {5, 6, 7, 8};
        int[] expected = {4, 4, 4, 4};
        int[] actual = computingMachine.task8(arrA, arrB);
        assertArrayEquals(expected, actual);
    }

    @Test
    void task9TestOnValidDataTestWeight() {
        Basket testBasket = new Basket(new Ball[]{new Ball(3, Color.RED), new Ball(7, Color.BLUE),
        new Ball(10, Color.BLUE), new Ball(12, Color.GREEN)});
        int expected = 32;
        int actual = testBasket.countBallsWeight();
        assertEquals(expected, actual);
    }

    @Test
    void task9TestOnValidDataTestColor() {
        Basket testBasket = new Basket(new Ball[]{new Ball(3, Color.RED), new Ball(7, Color.BLUE),
                new Ball(10, Color.BLUE), new Ball(12, Color.GREEN)});
        int expected = 2;
        int actual = testBasket.countBlueBalls();
        assertEquals(expected, actual);
    }

    @Test
    void task14TestCloneFunction() {
        Book myBook = new Book("Game of Thrones" , "John Martin", 120, 1);
        Book cloneOfMyBook = myBook.clone();
        assertEquals(myBook, cloneOfMyBook);
    }

    @Test
    void task15TestSorting() {
        Book[] myBooks = new Book[]{new Book("Game of Thrones" , "John Martin", 120, 1, 1145),
                new Book("10 niggas" , "Agata Kristi", 70, 3, 2331),
                new Book("Doctor Sleep" , "Stephen King", 40, 2, 1003),
                new Book("Shout", "Gregor Morgan", 55, 1, 3441)};
        Arrays.sort(myBooks);
        Book[] expected = new Book[]{new Book("Doctor Sleep" , "Stephen King", 40, 2, 1003),
                new Book("Game of Thrones" , "John Martin", 120, 1, 1145),
                new Book("10 niggas" , "Agata Kristi", 70, 3, 2331),
                new Book("Shout", "Gregor Morgan", 55, 1, 3441)};
        assertArrayEquals(expected, myBooks);
    }

    @Test
    void task16TestNameComparator() {
        List<Book> myBooks = new ArrayList<>(List.of(new Book[]{new Book("Game of Thrones", "John Martin", 120, 1, 1145),
                new Book("10 niggas", "Agata Kristi", 70, 3, 2331),
                new Book("Doctor Sleep", "Stephen King", 40, 2, 1003),
                new Book("Shout", "Gregor Morgan", 55, 1, 3441)}));
        NameComparator nameComparator = new NameComparator();
        myBooks.sort(nameComparator);
        List<Book> expected = new ArrayList<>(List.of(new Book[]{new Book("10 niggas" , "Agata Kristi", 70, 3, 2331),
                new Book("Doctor Sleep" , "Stephen King", 40, 2, 1003),
                new Book("Game of Thrones" , "John Martin", 120, 1, 1145),
                new Book("Shout", "Gregor Morgan", 55, 1, 3441)}));
        assertEquals(myBooks, expected);
    }

    @Test
    void task16TestNameThenAuthorComparator() {
        List<Book> myBooks = new ArrayList<>(List.of(new Book[]{new Book("Game of Thrones", "John Martin", 120, 1, 1145),
                new Book("10 niggas", "Agata Kristi", 70, 3, 2331),
                new Book("Doctor Sleep", "Stephen King", 40, 2, 1003),
                new Book("Doctor Sleep", "Aregor Morgan", 55, 1, 3441)}));
        NameThenAuthorComparator nameComparator = new NameThenAuthorComparator();
        myBooks.sort(nameComparator);
        List<Book> expected = new ArrayList<>(List.of(new Book[]{new Book("10 niggas" , "Agata Kristi", 70, 3, 2331),
                new Book("Doctor Sleep" , "Aregor Morgan", 40, 2, 1003),
                new Book("Doctor Sleep", "Stephen King", 55, 1, 3441),
                new Book("Game of Thrones" , "John Martin", 120, 1, 1145)}));
        assertEquals(myBooks, expected);
    }

    @Test
    void task16AuthorThenNameComparator() {
        List<Book> myBooks = new ArrayList<>(List.of(new Book[]{new Book("Game of Thrones", "John Martin", 120, 1, 1145),
                new Book("10 niggas", "Agata Kristi", 70, 3, 2331),
                new Book("Doctor Sleep", "Stephen King", 40, 2, 1003),
                new Book("Alabama", "Stephen King", 55, 1, 3441)}));
        AuthorThenNameComparator nameComparator = new AuthorThenNameComparator();
        myBooks.sort(nameComparator);
        List<Book> expected = new ArrayList<>(List.of(new Book[]{new Book("10 niggas" , "Agata Kristi", 70, 3, 2331),
                new Book("Game of Thrones" , "John Martin", 120, 1, 1145),
                new Book("Alabama", "Stephen King", 55, 1, 3441),
                new Book("Doctor Sleep" , "Stephen King", 40, 2, 1003)}));
        assertEquals(myBooks, expected);
    }

    @Test
    void task16NameThenAuthorThenPriceComparator() {
        List<Book> myBooks = new ArrayList<>(List.of(new Book[]{new Book("Feast of Scavengers", "John Martin", 120, 1, 1145),
                new Book("Doctor Sleep", "Stephen King", 70, 3, 2331),
                new Book("Doctor Sleep", "Stephen King", 40, 2, 1003),
                new Book("Doctor Sleep", "Aregor Morgan", 55, 1, 3441)}));
        NameThenAuthorComparator nameComparator = new NameThenAuthorComparator();
        myBooks.sort(nameComparator);
        List<Book> expected = new ArrayList<>(List.of(new Book[]{new Book("Doctor Sleep" , "Aregor Morgan", 55, 2, 1003),
                new Book("Doctor Sleep", "Stephen King", 40, 1, 3441),
                new Book("Doctor Sleep" , "Stephen King", 70, 3, 2331),
                new Book("Feast of Scavengers" , "John Martin", 120, 1, 1145)}));
        assertEquals(myBooks, expected);
    }
}
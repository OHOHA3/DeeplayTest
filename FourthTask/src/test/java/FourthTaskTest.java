import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FourthTaskTest {
    @Test
    void withPositiveNumbers() {
        FourthTask fourthTask = new FourthTask();
        int K = 2;
        Integer[] numbers = {10, 11, 7, 7, 12};
        SplitAnswer answer = fourthTask.findSplit(numbers, K);

        Assertions.assertEquals(true, answer.isOpportunity());
        Assertions.assertEquals(23, answer.getL());

        ArrayList<Integer> expected = new ArrayList<>(List.of(11, 12));
        Assertions.assertTrue(answer.getSplits().get(0).containsAll(expected));
        Assertions.assertTrue(expected.containsAll(answer.getSplits().get(0)));

        expected = new ArrayList<>(List.of(10, 7, 7));
        Assertions.assertTrue(answer.getSplits().get(1).containsAll(expected));
        Assertions.assertTrue(expected.containsAll(answer.getSplits().get(1)));
    }

    @Test
    void formulaImpossibleSplit() {
        FourthTask fourthTask = new FourthTask();
        int K = 3;
        Integer[] numbers = {5, 2, 6, 4, 3, 6};
        SplitAnswer answer = fourthTask.findSplit(numbers, K);

        Assertions.assertEquals(false, answer.isOpportunity());
    }

    @Test
    void recursiveImpossibleSplit() {
        FourthTask fourthTask = new FourthTask();
        int K = 2;
        Integer[] numbers = {3, 6};
        SplitAnswer answer = fourthTask.findSplit(numbers, K);

        Assertions.assertEquals(false, answer.isOpportunity());
    }

    @Test
    void negativeNumbers() {
        FourthTask fourthTask = new FourthTask();
        int K = 2;
        Integer[] numbers = {-10, -11, -7, -7, -12};
        SplitAnswer answer = fourthTask.findSplit(numbers, K);

        Assertions.assertEquals(true, answer.isOpportunity());
        Assertions.assertEquals(-24, answer.getL());

        ArrayList<Integer> expected = new ArrayList<>(List.of(-10, -7, -7));
        Assertions.assertTrue(answer.getSplits().get(0).containsAll(expected));
        Assertions.assertTrue(expected.containsAll(answer.getSplits().get(0)));

        expected = new ArrayList<>(List.of(-11, -12));
        Assertions.assertTrue(answer.getSplits().get(1).containsAll(expected));
        Assertions.assertTrue(expected.containsAll(answer.getSplits().get(1)));
    }

    @Test
    void withAnyNumbers() {
        FourthTask fourthTask = new FourthTask();
        int K = 3;
        Integer[] numbers = {100, -54, -45, 0, -1};
        SplitAnswer answer = fourthTask.findSplit(numbers, K);

        Assertions.assertEquals(true, answer.isOpportunity());
        Assertions.assertEquals(-1, answer.getL());

        ArrayList<Integer> expected = new ArrayList<>(List.of(-1));
        Assertions.assertTrue(answer.getSplits().get(0).containsAll(expected));
        Assertions.assertTrue(expected.containsAll(answer.getSplits().get(0)));

        expected = new ArrayList<>(List.of(0));
        Assertions.assertTrue(answer.getSplits().get(1).containsAll(expected));
        Assertions.assertTrue(expected.containsAll(answer.getSplits().get(1)));

        expected = new ArrayList<>(List.of(100, -54, -45));
        Assertions.assertTrue(answer.getSplits().get(2).containsAll(expected));
        Assertions.assertTrue(expected.containsAll(answer.getSplits().get(2)));
    }
}

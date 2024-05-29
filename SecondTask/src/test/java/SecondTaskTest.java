import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SecondTaskTest {
    @Test
    void withOneFrequent() {
        SecondTask secondTask = new SecondTask();
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 2, -1, -2, -1, -1, -4));
        FrequentAnswer answer = secondTask.findFrequentNumbers(numbers);
        Assertions.assertEquals(answer.getFrequency(), 3);
        Assertions.assertArrayEquals(answer.getNumbers().toArray(), new Integer[]{-1});
    }

    @Test
    void withManyFrequent() {
        SecondTask secondTask = new SecondTask();
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 1, 2, 3, 3, 2, -1, -2, -1, -4));
        FrequentAnswer answer = secondTask.findFrequentNumbers(numbers);
        Assertions.assertEquals(answer.getFrequency(), 2);
        Assertions.assertArrayEquals(answer.getNumbers().toArray(), new Integer[]{-1, 1, 2, 3});
    }
}

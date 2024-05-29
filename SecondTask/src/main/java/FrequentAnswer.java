import lombok.Getter;

import java.util.List;

/**
 * Класс, содержащий элементы, необходимые для вывода результата:
 * Максимальную частоту повторений и список самых частых чисел
 */
@Getter
public class FrequentAnswer {
    private final List<Integer> numbers;
    private final int frequency;

    public FrequentAnswer(List<Integer> numbers, int frequency) {
        this.numbers = numbers;
        this.frequency = frequency;
    }

    /**
     * Вывод результата
     */
    public void printAnswer() {
        System.out.print("Самые частые числа: ");
        System.out.println(numbers);
        System.out.println("Их частота: " + frequency);
    }
}

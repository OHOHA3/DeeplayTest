import java.util.*;

public class SecondTask {
    private final int RANDOM_MIN = -100;
    private final int RANDOM_MAX = 100;

    /**
     * Метод, представляющий интерактив для пользователя и запускающий решение задачи
     * Необходимо ввести одно целое число, чтобы получить ответ
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int len = scanner.nextInt();

        ArrayList<Integer> arr = createRandomArray(len);
        System.out.println("Массив: " + arr);

        FrequentAnswer answer = findFrequentNumbers(arr);
        answer.printAnswer();

        scanner.close();
    }

    /**
     * Генерирует массив из случайных чисел от RANDOM_MIN до RANDOM_MAX
     *
     * @param len длина желаемого массива
     * @return полученный массив
     */
    private ArrayList<Integer> createRandomArray(int len) {
        Random random = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            arr.add(random.nextInt(RANDOM_MIN, RANDOM_MAX));
        }
        return arr;
    }

    /**
     * Метод для поиска чисел с наибольшей частотой повторений.
     * Алгоритм проходится по данному массиву и считает частоту повторений каждого числа,
     * дабавляя значения в мапу. Потом идет проход по мапе, находящий максимальную частоту повторений.
     * По этому числу на втором проходе по мапе находим самые частые числа
     *
     * @param arr массив в котором необходимо найти числа с наибольшей частотой повторений
     * @return объект, содержащий ответ
     */
    public FrequentAnswer findFrequentNumbers(ArrayList<Integer> arr) {
        Map<Integer, Integer> frequent = new HashMap<>();
        for (int i : arr) {
            if (frequent.containsKey(i)) {
                frequent.put(i, frequent.get(i) + 1);
            } else {
                frequent.put(i, 1);
            }
        }

        int maxFrequent = frequent.values().stream().max(Integer::compareTo).get();
        List<Integer> frequentNumbers = frequent.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequent).map(Map.Entry::getKey).toList();

        return new FrequentAnswer(frequentNumbers, maxFrequent);
    }
}

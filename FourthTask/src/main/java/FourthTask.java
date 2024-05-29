import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FourthTask {
    /**
     * Метод, представляющий интерактив для пользователя и запускающий решение задачи
     * Необходимо ввести строку из последовательности чисел, а затем целое число,
     * чтобы получить ответ
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите числа: ");
        String input = scanner.nextLine();
        Integer[] numbers = toIntArray(input);

        System.out.print("Введите K: ");
        int K = scanner.nextInt();

        SplitAnswer splitAnswer = findSplit(numbers, K);
        splitAnswer.printAnswer();

        scanner.close();
    }

    /**
     * Метод, конвертирующий строку из последовательных чисел
     * в массив целых чисел
     *
     * @param input строка из последовательности чисел
     * @return массив целых чисел
     */
    private Integer[] toIntArray(String input) {
        String[] parts = input.split(" ");
        return Arrays.stream(parts).map(Integer::parseInt).toArray(Integer[]::new);
    }

    /**
     * Метод, который находит возможность разбиения на подмножества.
     * Сначала ищется возможность разбить через формулы арифметической прогрессии.
     * Если успешно, то начинается алгоритм backtracking для разбиения и последующей
     * проверки возможности
     *
     * @param numbers множество чисел, которые надо разбить
     * @param K       количество подмножеств
     * @return объект, содержащий ответ
     */
    public SplitAnswer findSplit(Integer[] numbers, int K) {
        int sum = Arrays.stream(numbers).mapToInt(Integer::intValue).sum();
        int minSum = Arrays.stream(numbers).filter(i -> i < 0).mapToInt(Integer::intValue).sum();
        int L = (2 * sum - K * (K - 1)) / (2 * K);
        if ((2 * sum - K * (K - 1)) % (2 * K) != 0 || L < minSum) {
            return new SplitAnswer();
        }

        Arrays.sort(numbers);

        ArrayList<ArrayList<Integer>> splits = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            splits.add(new ArrayList<>());
        }

        Integer[] targets = new Integer[K];
        for (int i = 0; i < K; i++) {
            targets[i] = L + i;
        }

        if (canSplit(numbers, targets, splits, 0)) {
            return new SplitAnswer(splits, L, K);
        } else {
            return new SplitAnswer();
        }
    }

    /**
     * Рекурсивный алгоритм, разбиващий множество на подмножества
     * перебором чисел. Проходимся по отсортированному множеству и проверяем,
     * можем ли мы добавить это число в подмножество, если да то уходим в рекурсию и смотрим
     * следующее число, если нет, то пробуем добавить в следующее подмножество. Если подмножеств не
     * осталось, то поднимаемся по рекурсии...
     * Если мы прошлись по всем числам, то проверям, правильные ли мы суммы собрали и не осталось ли пустых
     * подмножеств, если успешно, возвращаем true иначе поднимаемся по рекурсии.
     * В цикле присутствует критерий, что число множества должно быть меньше или равно требуемой суммы,
     * чтобы сделать перебор меньше. Множество должно быть отсортированным, чтобы мы не начали с большого числа,
     * которое бы не вошло ни в одно из подмножеств при наличии отрицательных чисел.
     *
     * @param numbers множество чисел
     * @param targets суммы, которые необходимо получить
     * @param splits  подмножества
     * @param index   индекс рассматриваемого числа в множестве
     * @return возможность разбиения
     */
    private boolean canSplit(Integer[] numbers, Integer[] targets, ArrayList<ArrayList<Integer>> splits, int index) {
        if (index == numbers.length) {
            for (int i = 0; i < targets.length; i++) {
                if (targets[i] != 0 || splits.get(i).isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < targets.length; i++) {
            if (numbers[index] < 0 || numbers[index] <= targets[i]) {
                splits.get(i).add(numbers[index]);
                targets[i] -= numbers[index];
                if (canSplit(numbers, targets, splits, index + 1)) {
                    return true;
                }
                splits.get(i).remove(splits.get(i).size() - 1);
                targets[i] += numbers[index];
            }
        }
        return false;
    }
}

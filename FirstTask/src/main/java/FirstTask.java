import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class FirstTask {
    private final int RANDOM_MIN = -100;
    private final int RANDOM_MAX = 100;

    /**
     * Метод, представляющий интерактив для пользователя и запускающий решение задачи.
     * Необходимо ввести одно целое число, чтобы получить ответ
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int len = scanner.nextInt();

        ArrayList<Integer> arr = createRandomArray(len);
        System.out.println("Массив: " + arr);

        sort(arr);
        System.out.println("Отсортированный массив: " + arr);

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
     * Метод, сортирующий массив, в котором сначала в порядке неубывания
     * идут нечетные числа, затем нули, а потом четные чила в порядке невозрастания.
     * Алгоритм проходится по первоначальному массиву и из него саздает массивы
     * нечетных чисел, четных и нулей, затем их сортирует по отдельности и объединяет.
     *
     * @param arr массив, который нужно отсортировать
     */
    public void sort(ArrayList<Integer> arr) {
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> zeros = new ArrayList<>();

        for (int i : arr) {
            if (i == 0) {
                zeros.add(i);
            } else if (i % 2 == 0) {
                evenNumbers.add(i);
            } else {
                oddNumbers.add(i);
            }
        }
        Collections.sort(oddNumbers);
        evenNumbers.sort(Collections.reverseOrder());

        arr.clear();
        arr.addAll(oddNumbers);
        arr.addAll(zeros);
        arr.addAll(evenNumbers);
    }
}

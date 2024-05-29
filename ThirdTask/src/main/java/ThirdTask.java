import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ThirdTask {
    private final int FACES_COUNT = 6;
    private final int SIMULATION_COUNT = 5_000_000;
    private final Random random = new Random();

    /**
     * Метод, представляющий интерактив для пользователя и запускающий решение задачи
     * Необходимо ввести 3 целых для первого игрока, для второго игрока и количество бросков
     * чтобы получить ответ
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите последовательность первого игрока: ");
        int[] firstPlayerSeq = new int[3];
        for (int i = 0; i < 3; i++) {
            firstPlayerSeq[i] = scanner.nextInt();
        }

        System.out.print("Введите последовательность второго игрока: ");
        int[] secondPlayerSeq = new int[3];
        for (int i = 0; i < 3; i++) {
            secondPlayerSeq[i] = scanner.nextInt();
        }

        System.out.print("Введите количество бросков: ");
        int throwsCount = scanner.nextInt();

        ChanceAnswer answer = findVictoryChance(firstPlayerSeq, secondPlayerSeq, throwsCount);
        answer.printAnswer();

        scanner.close();
    }

    /**
     * Метод, создающий последовательность бросков шестигранного кубика
     *
     * @param len количество бросков
     * @return последовательность бросков
     */
    private int[] createThrowsSequence(int len) {
        int[] throwsSequence = new int[len];
        throwsSequence = Arrays.stream(throwsSequence).map(i -> random.nextInt(FACES_COUNT) + 1).toArray();
        return throwsSequence;
    }

    /**
     * Метод, считающий количество очков игрока.
     * Алгоритм проходится по массиву бросков и сравнивает последовательность игрока
     * с последовательностью трех последовательных бросков кубика. Если нашлось
     * совпадение, то счет увеличивается на единицу и смещаемся на три броска, иначе на один
     *
     * @param playerSeq Последовательность игрока
     * @param throwsSeq Последовательность полученных бросков
     * @return количество очков
     */
    private int calculateScore(int[] playerSeq, int[] throwsSeq) {
        int score = 0;
        int i = 0;
        while (i <= throwsSeq.length - 3) {
            if (throwsSeq[i] == playerSeq[0] && throwsSeq[i + 1] == playerSeq[1] && throwsSeq[i + 2] == playerSeq[2]) {
                score++;
                i += 3;
            } else {
                i++;
            }
        }
        return score;
    }

    /**
     * Метод, подсчитывающий вероятность побед или ничьи игроков.
     * Применяется метод Монте-Карло для подсчета очков. Для этого
     * мы имитируем игру SIMULATION_COUNT раз и считаем количество
     * побед игроков, далее подсчитываем примерные вероятности.
     *
     * @param firstPlayerSeq  последовательность первого игрока
     * @param secondPlayerSeq последовательность второго игрока
     * @param throwsCount     количество бросков
     * @return объект, содержащий ответ
     */
    public ChanceAnswer findVictoryChance(int[] firstPlayerSeq, int[] secondPlayerSeq, int throwsCount) {
        int firstPlayerWin = 0;
        int SecondPlayerWin = 0;
        int draw = 0;

        for (int i = 0; i < SIMULATION_COUNT; i++) {
            int[] throwsSeq = createThrowsSequence(throwsCount);
            int firstPlayerScore = calculateScore(firstPlayerSeq, throwsSeq);
            int secondPlayerScore = calculateScore(secondPlayerSeq, throwsSeq);
            if (firstPlayerScore > secondPlayerScore) {
                firstPlayerWin++;
            } else if (firstPlayerScore < secondPlayerScore) {
                SecondPlayerWin++;
            } else {
                draw++;
            }
        }

        return new ChanceAnswer((double) firstPlayerWin / SIMULATION_COUNT,
                (double) SecondPlayerWin / SIMULATION_COUNT,
                (double) draw / SIMULATION_COUNT);
    }
}

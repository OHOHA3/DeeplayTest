import lombok.Getter;

import java.util.ArrayList;

/**
 * Класс, содержащий элементы, необходимые для вывода результата:
 * возможность разбиения, разбиение на подмножества, сумму первого подмножества,
 * количество подмножеств
 */
@Getter
public class SplitAnswer {
    private final boolean opportunity;
    private ArrayList<ArrayList<Integer>> splits;
    private int L;
    private int K;

    public SplitAnswer() {
        this.opportunity = false;
    }

    public SplitAnswer(ArrayList<ArrayList<Integer>> splits, int L, int K) {
        this.opportunity = true;
        this.splits = splits;
        this.L = L;
        this.K = K;
    }

    public void printAnswer() {
        if (opportunity) {
            for (int i = 0; i < K; i++) {
                System.out.print(splits.get(i) + "," + (L + i) + ",");
            }
            System.out.println("K=" + K);
        } else {
            System.out.println("Невозможно");
        }
    }
}

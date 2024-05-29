import lombok.Getter;

/**
 * Класс, содержащий элементы, необходимые для вывода результата:
 * шанс выигрыша первого игрока, шанс выигрыша второго игрока, шанс ничьи
 */
@Getter
public class ChanceAnswer {
    private final double firstWinChance;
    private final double secondWinChance;
    private final double drawChance;

    public ChanceAnswer(double firstWinChance, double secondWinChance, double drawChance) {
        this.firstWinChance = firstWinChance;
        this.secondWinChance = secondWinChance;
        this.drawChance = drawChance;
    }

    /**
     * Вывод результата
     */
    public void printAnswer() {
        System.out.println("Вероятность победы первого игрока: " + firstWinChance * 100 + "%");
        System.out.println("Вероятность победы второго игрока: " + secondWinChance * 100 + "%");
        System.out.println("Вероятность ничьи: " + drawChance * 100 + "%");
    }
}

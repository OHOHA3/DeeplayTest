import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdTaskTest {
    @Test
    public void test() {
        ThirdTask thirdTask = new ThirdTask();
        int[] firstSeq = new int[]{1, 2, 3};
        int[] secondSeq = new int[]{2, 3, 1};
        int throwsCount = 3;
        double eps = 0.0001;
        ChanceAnswer answer = thirdTask.findVictoryChance(firstSeq, secondSeq, throwsCount);
        Assertions.assertEquals(answer.getFirstWinChance(), 0.0046, eps);
        Assertions.assertEquals(answer.getSecondWinChance(), 0.0046, eps);
        Assertions.assertEquals(answer.getDrawChance(), 0.9907, eps);
    }
}

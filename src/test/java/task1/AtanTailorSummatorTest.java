package task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class AtanTailorSummatorTest {
    double eps = 0.1;

    //TODO do smth with 10?? n = 10
    @ParameterizedTest
    @ValueSource(doubles = {-0.5, -0.75, -1.0, -100}) //todo big values: wrong!
    public void testNegativeValues(double x) {
        assertEquals(Math.atan(x), AtanTailorSummator.getSum(x, 30), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5, 0.75, 1.0, 100})
    public void testPositiveValues(double x) {
        assertEquals(Math.atan(x), AtanTailorSummator.getSum(x, 30), eps);
    }

    @Test
    public void testZeroValue() {
        assertEquals(0.0, AtanTailorSummator.getSum(0.0, 10), eps);
    }
}

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ThirdTest {

    @Test
    void showIntervals() {
        Third th = new Third();
        int[] a = {9, 19, 29, 39, 49, 59, 69, 109};
        int[] b = {10, 15, 30, 50, 110};
        int[] array = {9};
        int[] c = th.showIntervals(a, b);
        assertTrue(Arrays.equals(array, c));
    }
}
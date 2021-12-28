import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FifthTest {

    @Test
    void createArray() {
        Fifth f = new Fifth();
        int[] a = {13, 22, 10, 1, 0, -13, 100, 23};
        int[] b = f.createArray(90, 2, a);
        int[] ex = {13, 22, 10, 2, 2, 2, 90, 23};
        assertTrue(Arrays.equals(b, ex));
    }
}
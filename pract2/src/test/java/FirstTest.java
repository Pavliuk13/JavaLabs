import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FirstTest {
    @org.junit.jupiter.api.Test
    void createArray() {
        First f = new First();
        int[] inArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] expArray = {0, 2, 4, 6, 8, 9, 7, 5, 3, 1};
        int[] outArray = f.CreateArray(inArray);
        assertTrue(Arrays.equals(expArray, outArray));
    }
}
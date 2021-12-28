import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondTest {

    @Test
    void checkArray() {
        Second s = new Second();
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4, 5, 5, 6};
        boolean b1 = s.checkArray(arr1);
        boolean b2 = s.checkArray(arr2);
        assertTrue((b1 == true) && (b2 == false));
    }
}
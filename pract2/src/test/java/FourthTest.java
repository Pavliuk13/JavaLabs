import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourthTest {

    @Test
    void dayInTheYear() {
        Fourth f = new Fourth();
        int exp = 366;
        int cur = f.dayInTheYear(31, 12, true);
        assertEquals(exp, cur);
    }
}
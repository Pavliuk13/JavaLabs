import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversTest {
    @Test
    void reverseStr() {
        Revers r = new Revers("Kyiv");
        String expect = r.reverseStr();
        Assert.assertEquals("Must be equals", "viyK", expect);
    }
}
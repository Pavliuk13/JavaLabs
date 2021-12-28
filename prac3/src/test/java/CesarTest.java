import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CesarTest {
    @Test
    void encrypt() {
        Cesar s = new Cesar();
        Assert.assertEquals(s.encrypt("Pavliuk", "Vasiliy"), "Lbouudj");
    }

    @Test
    void decrypt() {
        Cesar s = new Cesar();
        assertEquals(s.decrypt("Lbouudj", "Vasiliy"), "Pavliuk");
    }
}
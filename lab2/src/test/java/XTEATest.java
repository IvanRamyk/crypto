import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class XTEATest {
    private static final XTEA xtea = new XTEA("124562sa35jfjgas".getBytes());

    @Test
    void decipherOfEncipherResultShouldBeEqualsToOriginalString() {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < random.nextInt(100) + 1; j++) {
                string.append((char) random.nextInt(92) + 33);
            }
            assertEquals(string.toString(), xtea.decipher(xtea.encipher(string.toString())));
        }
    }
}
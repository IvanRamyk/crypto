import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class TestFermaTest {
    private static final int iterations = 100;


    @Test
    void isOnePrimeShouldReturnFalse() {
        assertFalse(Ferma.isPrime(BigInteger.ONE, iterations));
    }

    @Test
    void isTwoPrimeShouldReturnTrue() {
        assertTrue(Ferma.isPrime(BigInteger.TWO, iterations));
    }

    @Test
    void negativeCertaintyAlwaysReturnFalse() {
        assertFalse(Ferma.isPrime(BigInteger.valueOf(13), -1));
        assertFalse(Ferma.isPrime(BigInteger.valueOf(1000), -1));
    }

    @Test
    void zeroCertaintyAlwaysReturnFalse() {
        assertFalse(Ferma.isPrime(BigInteger.valueOf(13), 0));
        assertFalse(Ferma.isPrime(BigInteger.valueOf(1000), 0));
    }

}
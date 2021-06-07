import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MillerRabinTest {

    private static final int iterations = 100;


    @Test
    void testOne() {
        assertFalse(MillerRabin.isPrime(BigInteger.ONE, iterations));
    }

    @Test
    void testTwo() {
        assertTrue(MillerRabin.isPrime(BigInteger.TWO, iterations));
    }

    @Test
    void testNegativeIterations() {
        assertFalse(MillerRabin.isPrime(BigInteger.valueOf(13), -1));
        assertFalse(MillerRabin.isPrime(BigInteger.valueOf(1000), -1));
    }

    @Test
    void zeroCertaintyAlwaysReturnFalse() {
        assertTrue(MillerRabin.isPrime(BigInteger.valueOf(13), 10));
        assertFalse(MillerRabin.isPrime(BigInteger.valueOf(1000), 0));
    }


}
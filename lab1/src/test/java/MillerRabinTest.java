import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MillerRabinPrimalityTestTest {

    private static final int certainty = 100;


    @Test
    void isOnePrimeShouldReturnFalse() {
        assertFalse(MillerRabin.isProbablePrime(BigInteger.ONE, certainty));
    }

    @Test
    void isTwoPrimeShouldReturnTrue() {
        assertTrue(MillerRabin.isProbablePrime(BigInteger.TWO, certainty));
    }

    @Test
    void negativeCertaintyAlwaysReturnFalse() {
        assertFalse(MillerRabin.isProbablePrime(BigInteger.valueOf(13), -1));
        assertFalse(MillerRabin.isProbablePrime(BigInteger.valueOf(1000), -1));
    }

    @Test
    void zeroCertaintyAlwaysReturnFalse() {
        assertFalse(MillerRabin.isProbablePrime(BigInteger.valueOf(13), 0));
        assertFalse(MillerRabin.isProbablePrime(BigInteger.valueOf(1000), 0));
    }


}
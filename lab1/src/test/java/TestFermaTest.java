import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FermatPrimalityTestTest {
    private static final int iterations = 100;

//    @Test
//    void isZeroPrimeShouldThrowArithmeticException() {
//        assertThrows(ArithmeticException.class,
//                () -> TestFerma.isPrime(BigInteger.ZERO, iterations),
//                "BigInteger: modulus not positive");
//    }
//
//    @Test
//    void isNegativePrimeShouldThrowArithmeticException() {
//        assertThrows(ArithmeticException.class,
//                () -> TestFerma.isPrime(BigInteger.valueOf(-1000), iterations),
//                "BigInteger: modulus not positive");
//    }

    @Test
    void isOnePrimeShouldReturnFalse() {
        assertFalse(TestFerma.isPrime(BigInteger.ONE, iterations));
    }

    @Test
    void isTwoPrimeShouldReturnTrue() {
        assertTrue(TestFerma.isPrime(BigInteger.TWO, iterations));
    }

    @Test
    void negativeCertaintyAlwaysReturnFalse() {
        assertFalse(TestFerma.isPrime(BigInteger.valueOf(13), -1));
        assertFalse(TestFerma.isPrime(BigInteger.valueOf(1000), -1));
    }

    @Test
    void zeroCertaintyAlwaysReturnFalse() {
        assertFalse(TestFerma.isPrime(BigInteger.valueOf(13), 0));
        assertFalse(TestFerma.isPrime(BigInteger.valueOf(1000), 0));
    }

//    @Test
//    void isProbablyPrimeShouldReturnTrueForSmallPrimes() {
//        for (BigInteger prime : PrimesConstant.primes) {
//            assertTrue(TestFerma.isProbablyPrime(prime, iterations));
//        }
//    }

//    @Test
//    void isProbablyPrimeShouldReturnFalseForSmallNotPrimes() {
//        for (BigInteger notPrime : PrimesConstant.notPrimes) {
//            assertFalse(FermatPrimalityTest.isProbablyPrime(notPrime, iterations));
//        }
//    }
//
//    @Test
//    void isProbablyPrimeShouldReturnFalseForNotPrimesBiggerThanInt() {
//        int numberOfIsPrimeFalseReturns = 0;
//        for (BigInteger bigInteger : PrimesConstant.bigNotPrimes) {
//            if (!FermatPrimalityTest.isProbablyPrime(bigInteger, iterations)) {
//                ++numberOfIsPrimeFalseReturns;
//            }
//        }
//
//        assertEquals(99, numberOfIsPrimeFalseReturns, 1);
//    }
//
//    @Test
//    void isProbablyPrimeShouldReturnTrueForPrimesBiggerThanInt() {
//        int numberOfIsPrimeTrueReturns = 0;
//        for (BigInteger bigInteger : PrimesConstant.bigPrimes) {
//            if (FermatPrimalityTest.isProbablyPrime(bigInteger, iterations)) {
//                ++numberOfIsPrimeTrueReturns;
//            }
//        }
//
//        assertEquals(99, numberOfIsPrimeTrueReturns, 1);
//    }
}
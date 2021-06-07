import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultKarazubaTest {

    @Test
    void multiplicationOnZeroShouldReturnZero() {
        assertEquals(BigInteger.ZERO,
                MultiKaratsuba.karazubaMult(new BigInteger("2034954578765486095"), BigInteger.ZERO));
    }

    @Test
    void negativeNumberShouldReturnNegativeWithMultiplyingOnPositive() {
        assertEquals(new BigInteger("-500000000000000"),
                MultiKaratsuba.karazubaMult(new BigInteger("-5"), new BigInteger("100000000000000")));
    }

    @Test
    void negativeNumberShouldReturnPositiveWithMultiplyingOnNegative() {
        assertEquals(new BigInteger("500000000000000"),
                MultiKaratsuba.karazubaMult(new BigInteger("-5"), new BigInteger("-100000000000000")));
    }

    @Test
    void resultsForMultiplicationShouldBeSameAsLibMultiplication() {
        BigInteger a, b;
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            a = BigInteger.valueOf(Math.abs(rand.nextLong()));
            b = BigInteger.valueOf(Math.abs(rand.nextLong()));

            assertEquals(a.multiply(b), MultiKaratsuba.karazubaMult(a, b));
        }
    }
}
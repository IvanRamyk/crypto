import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinPowTest {

    @Test
    public void binPow() {
        BigInteger exp1 = BinPow.compute(new BigInteger("100"), new BigInteger("5"), new BigInteger("7"));
        BigInteger exp2 = BinPow.compute(ZERO, new BigInteger("123"), new BigInteger("7"));
        BigInteger exp3 = BinPow.compute(ONE, new BigInteger("7576234374"), new BigInteger("7"));
        BigInteger exp4 = BinPow.compute(new BigInteger("72657634"), ZERO, new BigInteger("7"));
        BigInteger exp5 = BinPow.compute(new BigInteger("72657635"), ONE, new BigInteger("7"));

        assertEquals(exp1, new BigInteger("4"));
        assertEquals(exp2, ZERO);
        assertEquals(exp3, ONE);
        assertEquals(exp4, ONE);
        assertEquals(exp5, ONE);
    }
}
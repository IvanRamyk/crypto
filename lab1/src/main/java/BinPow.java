import java.math.BigInteger;

import static java.math.BigInteger.*;

public class BinPow {

    public static BigInteger compute(BigInteger a, BigInteger b, BigInteger mod) {
        if (b.equals(ZERO))
            return ONE;
        if (b.equals(ONE))
            return a.mod(mod);

        if (b.mod(TWO).equals(ONE)) {
            return a.multiply(compute(a, b.subtract(ONE), mod)).mod(mod);
        }

        return compute(a, b.divide(TWO), mod).pow(2).mod(mod);
    }

}
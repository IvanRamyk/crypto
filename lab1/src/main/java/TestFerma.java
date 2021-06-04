import java.math.BigInteger;
import java.util.Random;

public class TestFerma {

    private final static Random rand = new Random();

    private static BigInteger getRandomFermatBase(BigInteger n) {
        while (true) {
            final BigInteger a = new BigInteger(n.bitLength(), rand);

            if (BigInteger.ONE.compareTo(a) <= 0 && a.compareTo(n) < 0)
                return a;
        }
    }

    public static boolean isPrime(BigInteger x, int iterations) {
        if (iterations <= 0) {
            return false;
        }

        if (x.equals(BigInteger.ONE)) {
            return false;
        }
        if (x.equals(BigInteger.TWO)) {
            return true;
        }

        for (int i = 0; i < iterations; i++) {
            BigInteger curr = getRandomFermatBase(x);
            if (!curr.gcd(x).equals(BigInteger.ONE)) {
                return false;
            }
            if (!curr.modPow(x.subtract(BigInteger.ONE), x).equals(BigInteger.ONE)) {
                return false;
            }
        }
        return true;
    }
}
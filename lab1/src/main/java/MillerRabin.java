import java.math.BigInteger;

import java.util.Random;

import static java.math.BigInteger.*;

public class MillerRabin {

    public static boolean isPrime(BigInteger n, int maxIterations) {
        if (maxIterations <= 0)
            return false;
        if (n.equals(BigInteger.ONE))
            return false;
        if (n.equals(BigInteger.TWO))
            return true;

        int s = 0;
        BigInteger d = n.subtract(ONE);

        while (d.mod(TWO).equals(ZERO)) {
            s++;
            d = d.divide(TWO);
        }

        for (int i = 0; i < maxIterations; i++) {
            BigInteger a = uniformRandom(n.subtract(ONE));
            BigInteger x = a.modPow(d, n);

            if (x.equals(ONE) || x.equals(n.subtract(ONE)))
                continue;

            int r = 0;
            for (; r < s; r++) {
                x = x.modPow(TWO, n);    // x = x^2 mod n

                if (x.equals(ONE))
                    return false;

                if (x.equals(n.subtract(ONE)))
                    break;
            }

            if (r == s)
                return false;
        }
        return true;
    }

    private static BigInteger uniformRandom(BigInteger top) {
        Random rnd = new Random();

        BigInteger res;
        do {
            res = new BigInteger(top.bitLength(), rnd);
        } while (res.compareTo(TWO) < 0 || res.compareTo(top) > 0);
        return res;
    }
}

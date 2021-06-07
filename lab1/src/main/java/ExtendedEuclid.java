import java.math.BigInteger;

public class ExtendedEuclid {
    public static BigInteger[] compute(BigInteger a, BigInteger b) {
        BigInteger[] ans = new BigInteger[3];   // { gcd, x, y }

        if (b.equals(BigInteger.ZERO)) {
            ans[0] = a;
            ans[1] = BigInteger.valueOf(1);
            ans[2] = BigInteger.valueOf(0);
        } else {
            BigInteger q = a.divide(b);
            ans = compute(b, a.remainder(b));

            BigInteger temp = ans[1].subtract(ans[2].multiply(q));
            ans[1] = ans[2];
            ans[2] = temp;
        }
        return ans;
    }
}

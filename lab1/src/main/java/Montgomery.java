
import java.math.BigInteger;

public class Montgomery {

    private final BigInteger N;
    private final BigInteger R;
    private final BigInteger R2;

    Montgomery(BigInteger N) {
        this.N = N;
        this.R = BigInteger.ONE.shiftLeft(N.bitLength());
        this.R2 = this.R.multiply(R).mod(N);
    }

    private BigInteger MontgomeryProd(BigInteger T) {
        BigInteger[] array = ExtendedEuclid.compute(N, R);
        BigInteger m = T
                .multiply(array[1].negate())
                .and(R.subtract(BigInteger.ONE));
        BigInteger u = T
                .add(m.multiply(N))
                .shiftRight(N.bitLength());
        while (u.compareTo(N) >= 0) { // must be only one iteration
            u = u.subtract(N);
        }
        return u.mod(N);
    }

    public BigInteger multiply(BigInteger a, BigInteger b) {
        BigInteger a1 = MontgomeryProd(a.multiply(R2));
        BigInteger b1 = MontgomeryProd(b.multiply(R2));
        BigInteger c1 = MontgomeryProd(a1.multiply(b1));
        return MontgomeryProd(c1);
    }

    public BigInteger pow(BigInteger a, BigInteger e) {
        BigInteger a1 =  MontgomeryProd(a.multiply(R2));
        BigInteger x1 = MontgomeryProd(R2);
        for (int i = e.bitLength() - 1; i >= 0; i--) {
            x1 = MontgomeryProd(x1.multiply(x1));
            if (e.testBit(i)) {
                x1 = MontgomeryProd(x1.multiply(a1));
            }
        }
        return MontgomeryProd(x1);
    }

}
